package util;

import java.sql.Date;

import java.text.SimpleDateFormat;

public class Libreria {

	public static Date toFecha(String str) {
		Date date = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			date = new Date(sdf.parse(str).getTime());
		} catch (Exception e) {
			e.printStackTrace();

		}
		return date;
	}
		
}