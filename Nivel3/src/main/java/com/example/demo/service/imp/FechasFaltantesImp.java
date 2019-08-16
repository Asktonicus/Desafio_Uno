package com.example.demo.service.imp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dto.RequestDTO;
import com.example.demo.dto.ResponseDTO;
import com.example.demo.service.IFechasFaltantes;
import com.example.demo.utils.Utilitarios;

@Component
public class FechasFaltantesImp implements IFechasFaltantes{
	
	private static final String URL = "http://localhost:8080/periodos/api";
	private static final Logger LOGGER = LoggerFactory.getLogger(FechasFaltantesImp.class);
	
	@Override
	public ResponseDTO getFechasFaltantes() {
		LOGGER.info("Ingresando a Implementacion");
		ResponseDTO response = new ResponseDTO();
		RequestDTO request = new RequestDTO();
		RestTemplate rt = new RestTemplate();
		
		request = rt.getForObject(URL, RequestDTO.class);
		response.setId(request.getId());
		response.setFechaCreacion(request.getFechaCreacion());
		response.setFechaFin(request.getFechaFin());
		response.setFechas(request.getFechas());
		
		List<String> allDates = getListadoEntreFechas(request.getFechaCreacion(), request.getFechaFin(), request.getFechas());
		
		response.setFechasFaltantes(allDates.toArray(new String[allDates.size()]));
		
		return response;
	}
	
	private List<String> getListadoEntreFechas(String fechaInicio, String fechaFin, String[] listadoCompleto) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar init = Utilitarios.getCalendar(fechaInicio);
		Calendar end = Utilitarios.getCalendar(fechaFin);
		List<String> newListElement = new ArrayList<String>();
		int i = 0;
		
		while(!init.after(end)) {
			//Consulta si el indice ya es mayor al largo del arreglo, en caso de que así sea, agrega la fecha actual al nuevo arreglo
			if(i >= listadoCompleto.length) {
				String month =  init.get(Calendar.MONTH) < 9 ? "0" + (init.get(Calendar.MONTH) + 1) : init.get(Calendar.MONTH) + 1 + "";
				newListElement.add(init.get(Calendar.YEAR) + "-" + month  + "-0"  + init.get(Calendar.DAY_OF_MONTH));
				init.add(Calendar.MONTH, 1);
				continue;
			}
			try {
				Date currentDate = sdf.parse(listadoCompleto[i]);
				Calendar currentCalendar = Calendar.getInstance();
				currentCalendar.setTime(currentDate);
				//compara si existe el mes y el año en el arreglo antiguo y en caso de que no esté, lo agrega al nuevo
				if(init.get(Calendar.MONTH) == currentCalendar.get(Calendar.MONTH) && init.get(Calendar.YEAR) == currentCalendar.get(Calendar.YEAR)) {
					i++;
				} else {
					String month =  init.get(Calendar.MONTH) < 9 ? "0" + (init.get(Calendar.MONTH) + 1) : init.get(Calendar.MONTH) + 1 + "";
					newListElement.add(init.get(Calendar.YEAR) + "-" + month + "-0"  + init.get(Calendar.DAY_OF_MONTH));
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
			init.add(Calendar.MONTH, 1);
		}
		return newListElement;
	}
}
