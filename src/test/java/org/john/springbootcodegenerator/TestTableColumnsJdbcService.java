package org.john.springbootcodegenerator;

import java.util.List;

import javax.annotation.Resource;

import org.john.springbootcodegenerator.entity.TableColumns;
import org.john.springbootcodegenerator.service.TableColumnsJdbcService;
import org.junit.Test;

import com.alibaba.fastjson.JSON;

public class TestTableColumnsJdbcService extends TestBase {

	@Resource
	private TableColumnsJdbcService tableColumnsJdbcService;
	
	@Test
	@Override
	public void test() {
		List<TableColumns> list=tableColumnsJdbcService.getListByTable("tb_user");
		logger.info(JSON.toJSONString(list));
	}

}
