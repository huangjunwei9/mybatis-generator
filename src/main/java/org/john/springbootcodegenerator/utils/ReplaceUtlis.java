package org.john.springbootcodegenerator.utils;

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

}
