package org.john.springbootcodegenerator;

import org.john.springbootcodegenerator.enums.DataTypeEnums;
import org.junit.Test;

public class TestDataTypeEnums  extends TestBase{

	@Test
	@Override
	public void test() {
		String s=DataTypeEnums.getJavaDataTypeByMysqlDataType("int");
		logger.info(s);
	}

	
}
