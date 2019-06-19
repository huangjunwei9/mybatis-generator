package org.john.springbootcodegenerator;

import org.john.springbootcodegenerator.service.impl.TemplateDefaultGeneratorServiceImpl;
import org.john.springbootcodegenerator.service.impl.TemplateNeedExtendGeneratorServiceImpl;
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
	public TemplateDefaultGeneratorServiceImpl templateDefaultGeneratorServiceImpl;
	@Autowired
	public TemplateNeedExtendGeneratorServiceImpl templateNeedExtendGeneratorServiceImpl;
	
	/**
	 * 使用默认（不继承类）生成代码
	 * @author JohnDeng
	 * @datatime 2019年1月21日下午4:14:55
	 */
	@Test
	public void defaultGeneratorTest(){
		String tableName="tb_sys_user",classDescription="系统用户管理";
		templateDefaultGeneratorServiceImpl.createEntityTemplate(tableName, classDescription);
		templateDefaultGeneratorServiceImpl.createDaoTemplate(tableName, classDescription);
		templateDefaultGeneratorServiceImpl.createServiceTemplate(tableName, classDescription);
		templateDefaultGeneratorServiceImpl.createServiceImplTemplate(tableName, classDescription);
		templateDefaultGeneratorServiceImpl.createControllerTemplate(tableName, classDescription);
		templateDefaultGeneratorServiceImpl.createMapperTeplate(tableName, classDescription);
		
	}
	
	/**
	 * 使用需要继承类生成代码
	 * @author JohnDeng
	 * @dateTime 2019年6月19日上午11:26:06
	 */
	//@Test
	public void needExtendGeneratorTest(){
		String tableName="tb_sys_user",classDescription="系统用户管理";
		templateNeedExtendGeneratorServiceImpl.createEntityTemplate(tableName, classDescription);
		templateNeedExtendGeneratorServiceImpl.createDaoTemplate(tableName, classDescription);
		templateNeedExtendGeneratorServiceImpl.createServiceTemplate(tableName, classDescription);
		templateNeedExtendGeneratorServiceImpl.createServiceImplTemplate(tableName, classDescription);
		templateNeedExtendGeneratorServiceImpl.createControllerTemplate(tableName, classDescription);
		templateNeedExtendGeneratorServiceImpl.createMapperTeplate(tableName, classDescription);
		
	}
	
}
