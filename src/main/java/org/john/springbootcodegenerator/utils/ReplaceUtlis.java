package org.john.springbootcodegenerator.utils;

import java.util.HashMap;
import java.util.Map;

public class ReplaceUtlis {

	public static String replace(String text, Map<String, Object> map) {
		if (map != null && map.size() > 0) {
			for (Map.Entry<String, Object> entry : map.entrySet()) {
				text = text.replace("${" + entry.getKey() + "}", entry.getValue().toString());
			}
		}
		return text;
	}

	
	public static void main(String[] args) {
		String str = "sdfsf ${name} sdfsd";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "1234");
		str = replace(str, map);
		System.out.println(str);
	}
}
