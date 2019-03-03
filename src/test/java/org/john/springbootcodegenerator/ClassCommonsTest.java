package org.john.springbootcodegenerator;

import org.john.springbootcodegenerator.config.CodeGeneratorConfig;
import org.john.springbootcodegenerator.utils.DateTimeUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class ClassCommonsTest extends SpringbootCodeGeneratorApplicationTests {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	public CodeGeneratorConfig classCommons;
	@Autowired
	public CodeGeneratorConfig jdbcCommons;

	public void classCommonsTest() {
		logger.info("author:" + classCommons.getAuthor());
		logger.info("datatime:" + DateTimeUtils.getDatatime());
		logger.info("packgePath:" + classCommons.getPackgePath());
	}

	@Test
	public void jdbcCommonsTest() {
		logger.info("tableName:" + jdbcCommons.getDatabaseName());
	}

}
