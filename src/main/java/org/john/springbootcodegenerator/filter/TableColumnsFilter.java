package org.john.springbootcodegenerator.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * 过滤表字段
 * 
 * @author johnDeng
 * @dataTime 2019年3月5日下午3:50:31
 */
public class TableColumnsFilter {

	/**
	 * 获取过滤表字段列表
	 * 
	 * @author johnDeng
	 * @dataTime 2019年3月5日下午3:50:52
	 * @return
	 */
	public List<String> getFilterColumnsList() {
		List<String> columnsList = new ArrayList<String>();
		columnsList.add("id");
		return columnsList;
	}
}
