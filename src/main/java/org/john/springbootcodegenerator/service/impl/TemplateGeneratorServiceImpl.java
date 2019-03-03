package org.john.springbootcodegenerator.service.impl;

import javax.annotation.Resource;

import org.john.springbootcodegenerator.config.CodeGeneratorConfig;
import org.john.springbootcodegenerator.service.TableColumnsService;
import org.john.springbootcodegenerator.service.TemplateGeneratorService;
import org.john.springbootcodegenerator.utils.DateTimeUtils;
import org.john.springbootcodegenerator.utils.FileUtlis;
import org.john.springbootcodegenerator.utils.FormatNameUtlis;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
@Service
public class TemplateGeneratorServiceImpl implements TemplateGeneratorService {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Resource
	private TableColumnsService tableColumnsService;
	@Resource
	private CodeGeneratorConfig codeGeneratorConfig;
	
	@Override
	public void createEntityTemplate(String tableName, String classDescription) {
	
		logger.info(">>>>>开始创建实体<<<<<");
		String templateEntityString = FileUtlis.readFileText(codeGeneratorConfig.getTemplateEntityFileName());
		String entityData = tableColumnsService.getEntityData(tableName);
		templateEntityString = templateEntityString.replace("${classDescription}", classDescription);
		templateEntityString = templateEntityString.replace("${author}", codeGeneratorConfig.getAuthor());
		templateEntityString = templateEntityString.replace("${datatime}", DateTimeUtils.getDatatime());
		templateEntityString = templateEntityString.replace("${alias}", tableColumnsService.getAliasName(tableName));
		templateEntityString = templateEntityString.replace("${table}", tableName);
		templateEntityString = templateEntityString.replace("${className}",tableColumnsService.getClassName(tableName));
		templateEntityString = templateEntityString.replace("${primaryKey}",tableColumnsService.getPrimaryKeyDataType(tableName));
		templateEntityString = templateEntityString.replace("${entityData}", entityData);
		templateEntityString = templateEntityString.replace("${packgePath}", codeGeneratorConfig.getPackgePath());
		templateEntityString = templateEntityString.replace("${extendsBasePath}", codeGeneratorConfig.getExtendsBasePath());
		logger.info("templateEntityString:" + templateEntityString);
		FileUtlis.wirteContent(codeGeneratorConfig.getWriteEntityFilePath(),
				tableColumnsService.getClassName(tableName) + ".java", templateEntityString);
		logger.info(">>>>>结束创建实体<<<<<");
		
	}

	@Override
	public void createDaoTemplate(String tableName, String classDescription) {
		
		logger.info(">>>>>开始创建DAO<<<<<");
		String templateDaoString = FileUtlis.readFileText(codeGeneratorConfig.getTemplateDaoFileName());
		templateDaoString = templateDaoString.replace("${packgePath}", codeGeneratorConfig.getPackgePath());
		templateDaoString = templateDaoString.replace("${className}", tableColumnsService.getClassName(tableName));
		templateDaoString = templateDaoString.replace("${classDescription}", classDescription);
		templateDaoString = templateDaoString.replace("${author}", codeGeneratorConfig.getAuthor());
		templateDaoString = templateDaoString.replace("${datatime}", DateTimeUtils.getDatatime());
		templateDaoString = templateDaoString.replace("${primaryKey}",tableColumnsService.getPrimaryKeyDataType(tableName));
		templateDaoString = templateDaoString.replace("${extendsBasePath}", codeGeneratorConfig.getExtendsBasePath());

		logger.info("templateDaoString:" + templateDaoString);
		FileUtlis.wirteContent(codeGeneratorConfig.getWriteDaoFilePath(),
				tableColumnsService.getClassName(tableName) + "Dao.java", templateDaoString);
		logger.info(">>>>>结束创建DAO<<<<<");
		
	}

	@Override
	public void createServiceTemplate(String tableName, String classDescription) {
		
		logger.info(">>>>>开始创建Service<<<<<");
		String templateServiceString = FileUtlis.readFileText(codeGeneratorConfig.getTemplateServiceFileName());
		templateServiceString = templateServiceString.replace("${packgePath}", codeGeneratorConfig.getPackgePath());
		templateServiceString = templateServiceString.replace("${className}", tableColumnsService.getClassName(tableName));
		templateServiceString = templateServiceString.replace("${classDescription}", classDescription);
		templateServiceString = templateServiceString.replace("${author}", codeGeneratorConfig.getAuthor());
		templateServiceString = templateServiceString.replace("${datatime}", DateTimeUtils.getDatatime());
		templateServiceString = templateServiceString.replace("${primaryKey}",tableColumnsService.getPrimaryKeyDataType(tableName));
		templateServiceString = templateServiceString.replace("${extendsBasePath}", codeGeneratorConfig.getExtendsBasePath());

		logger.info("templateServiceString:" + templateServiceString);
		FileUtlis.wirteContent(codeGeneratorConfig.getWriteServiceFilePath(),
				tableColumnsService.getClassName(tableName) + "Service.java", templateServiceString);
		logger.info(">>>>>结束创建Service<<<<<");
	}

	@Override
	public void createServiceImplTemplate(String tableName, String classDescription) {
		
		logger.info(">>>>>开始创建ServiceImpl<<<<<");
		String templateServiceImplString = FileUtlis.readFileText(codeGeneratorConfig.getTemplateServiceImplFileName());
		templateServiceImplString = templateServiceImplString.replace("${packgePath}", codeGeneratorConfig.getPackgePath());
		templateServiceImplString = templateServiceImplString.replace("${className}", tableColumnsService.getClassName(tableName));
		templateServiceImplString = templateServiceImplString.replace("${className1}", FormatNameUtlis.formatNameLowerCase(tableColumnsService.getClassName(tableName)));
		templateServiceImplString = templateServiceImplString.replace("${classDescription}", classDescription);
		templateServiceImplString = templateServiceImplString.replace("${author}", codeGeneratorConfig.getAuthor());
		templateServiceImplString = templateServiceImplString.replace("${datatime}", DateTimeUtils.getDatatime());
		templateServiceImplString = templateServiceImplString.replace("${primaryKey}",tableColumnsService.getPrimaryKeyDataType(tableName));
		templateServiceImplString = templateServiceImplString.replace("${extendsBasePath}", codeGeneratorConfig.getExtendsBasePath());

		logger.info("templateServiceImplString:" + templateServiceImplString);
		FileUtlis.wirteContent(codeGeneratorConfig.getWriteServiceImplFilePath(),tableColumnsService.getClassName(tableName) + "ServiceImpl.java", templateServiceImplString);
		logger.info(">>>>>结束创建ServiceImpl<<<<<");
		
	}

	@Override
	public void createControllerTemplate(String tableName, String classDescription) {
		
		logger.info(">>>>>开始创建controller<<<<<");
		String templateControllerString = FileUtlis.readFileText(codeGeneratorConfig.getTemplateControllerFileName());
		templateControllerString = templateControllerString.replace("${packgePath}", codeGeneratorConfig.getPackgePath());
		templateControllerString = templateControllerString.replace("${className}", tableColumnsService.getClassName(tableName));
		templateControllerString = templateControllerString.replace("${className1}", FormatNameUtlis.formatNameLowerCase(tableColumnsService.getClassName(tableName)));
		templateControllerString = templateControllerString.replace("${classDescription}", classDescription);
		templateControllerString = templateControllerString.replace("${author}", codeGeneratorConfig.getAuthor());
		templateControllerString = templateControllerString.replace("${datatime}", DateTimeUtils.getDatatime());
		templateControllerString = templateControllerString.replace("${primaryKey}",tableColumnsService.getPrimaryKeyDataType(tableName));
		templateControllerString = templateControllerString.replace("${extendsBasePath}", codeGeneratorConfig.getExtendsBasePath());

		logger.info("templateControllerString:" + templateControllerString);
		FileUtlis.wirteContent(codeGeneratorConfig.getWriteControllerFilePath(),tableColumnsService.getClassName(tableName) + "Controller.java", templateControllerString);
		logger.info(">>>>>结束创建controller<<<<<");
		
	}

}
