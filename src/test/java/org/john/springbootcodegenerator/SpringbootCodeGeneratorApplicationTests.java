package org.john.springbootcodegenerator;

import org.john.springbootcodegenerator.service.TemplateGeneratorService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 测试用例
 * @author JohnDeng
 * @dateTime 2019年6月17日下午4:27:36
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes=SpringbootCodeGeneratorApplication.class)
public class SpringbootCodeGeneratorApplicationTests {
	@Autowired
	public TemplateGeneratorService codeGenerator;
	/**
	 * 
	 * @author JohnDeng
	 * @datatime 2019年1月21日下午4:14:55
	 */
	@Test
	public void codeGeneratorTest(){
//		String tableName="tb_account_user",classDescription="系统用户管理";
		String tableName="tb_sys_user",classDescription="系统用户管理";
		codeGenerator.createEntityTemplate(tableName, classDescription);
		codeGenerator.createDaoTemplate(tableName, classDescription);
		codeGenerator.createServiceTemplate(tableName, classDescription);
		codeGenerator.createServiceImplTemplate(tableName, classDescription);
		codeGenerator.createControllerTemplate(tableName, classDescription);
		codeGenerator.createMapperTeplate(tableName, classDescription);
		
	}
	
}
