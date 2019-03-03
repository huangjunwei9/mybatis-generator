package org.john.springbootcodegenerator.utils;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;

public class ReplaceUtlis {

	public String replace(String text, List<Map<String, Object>> list) {
		if (CollectionUtils.isNotEmpty(list)) {
			for (int i = 0; i < list.size(); i++) {
				text = text.replaceAll("${" + list.get(i).keySet() + "}", list.get(i).toString());
			}
		}
		return text;
	}
}
