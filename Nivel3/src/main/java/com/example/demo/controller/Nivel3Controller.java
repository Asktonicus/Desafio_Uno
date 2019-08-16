package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ResponseDTO;
import com.example.demo.service.IFechasFaltantes;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = { "API Fechas Faltantes" })
@RestController
@Controller
public class Nivel3Controller {
	public static final Logger LOG = LoggerFactory.getLogger(Nivel3Controller.class);
	private final IFechasFaltantes fechasFaltantes;
	
	@Autowired
	public Nivel3Controller(IFechasFaltantes fechasFaltantes) {
		this.fechasFaltantes = fechasFaltantes;
	}

    @ApiOperation(nickname = "Fechas Faltantes", value = "Obtener Fechas Faltantes",response = Nivel3Controller.class)
    @ApiResponses(value= {
    		@ApiResponse(code=200,message="Fechas Faltantes al periodo recibido"),
    		@ApiResponse(code=500,message="Internal Server Error"),
    		@ApiResponse(code=404,message="Not found")
    })
	@RequestMapping(method = RequestMethod.GET, value="/fechasFaltantes", produces = "application/json")
	@ResponseBody
	public ResponseDTO getFechasFaltantes(){
		LOG.info("Enter Controller");
		return fechasFaltantes.getFechasFaltantes();
	}
}
