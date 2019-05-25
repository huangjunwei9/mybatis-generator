package org.john.springbootcodegenerator.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * 时间工具类
 * @author JohnDeng
 * @datatime 2019年5月25日下午10:57:37
 */
public class DateTimeUtils {

	public  static String getDatatime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		return sdf.format(new Date());
	}
}
