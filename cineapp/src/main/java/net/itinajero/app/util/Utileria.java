package net.itinajero.app.util;

import java.text.SimpleDateFormat;
import java.util.*;

public class Utileria {
	
	/**
	 * METODO PARA QUE REGRESE FECHAS SIGUIENTES SEGUN EL PARAMETRO COUNT
	 * 
	 * @param count
	 * @return
	 */
	
	public static List<String> getNextDays(int count) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		
		// Fecha de hoy
		Date start = new Date();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, count);  // Los n siguientes dias que se pasan como parámetro
		Date endDate = cal.getTime();
		
		GregorianCalendar gcal = new GregorianCalendar();
		gcal.setTime(start);
		
		List<String> nextDays = new ArrayList<String>();
		
		while(!gcal.getTime().after(endDate)) {
			Date d = gcal.getTime();
			gcal.add(Calendar.DATE, 1);
			nextDays.add(sdf.format(d));
		}

		return nextDays;
		
		
	}
	
	
}