package org.john.springbootcodegenerator.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeUtils {

	public  static String getDatatime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		return sdf.format(new Date());
	}
}
