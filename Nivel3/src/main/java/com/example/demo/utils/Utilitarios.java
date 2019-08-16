package com.example.demo.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Utilitarios {
	
	public static Calendar getCalendar(String date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dateInit = new Date();
		try {
			dateInit = sdf.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Calendar init = Calendar.getInstance();
		init.setTime(dateInit);
		return init;
	}
}
