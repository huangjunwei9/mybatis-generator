package org.john.springbootcodegenerator.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.john.springbootcodegenerator.bean.ExtendsSettings;
import org.john.springbootcodegenerator.bean.GlobalSettings;
import org.john.springbootcodegenerator.common.FileSuffixCommon;
import org.john.springbootcodegenerator.service.TableColumnsService;
import org.john.springbootcodegenerator.service.TemplateGeneratorService;
import org.john.springbootcodegenerator.utils.DateTimeUtils;
import org.john.springbootcodegenerator.utils.FilePathUtils;
import org.john.springbootcodegenerator.utils.FileUtlis;
import org.john.springbootcodegenerator.utils.FormatNameUtlis;
import org.john.springbootcodegenerator.utils.ReplaceUtlis;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TemplateGeneratorServiceImpl implements TemplateGeneratorService {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Resource
	private TableColumnsService tableColumnsService;
	@Resource
	private GlobalSettings codeGeneratorConfig;
	@Resource
	private FilePathUtils filePathUtils;
	@Resource
	private ExtendsSettings extendsSettings;

	/**
	 * 通用的替换
	 * 
	 * @author JohnDeng
	 * @datatime 2019年5月26日下午9:39:17
	 * @param tableName
	 * @param classDescription
	 * @return
	 */
	private Map<String, Object> replaceMap(String tableName, String classDescription) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("classDescription", classDescription);
		map.put("author", codeGeneratorConfig.getAuthor());
		map.put("datatime", DateTimeUtils.getDatatime());
		map.put("className", tableColumnsService.getClassName(tableName));
		map.put("primaryKey", tableColumnsService.getPrimaryKeyDataType(tableName));
		return map;
	}

	private String getPackgePath(String name) {
		String path = "";
		switch (name) {
		case "entity":
			path = ".entity";
			break;
		case "dao":
			path = ".dao";
			break;
		case "service":
			path = ".service";
			break;
		case "serviceImpl":
			path = ".service.impl";
			break;
		case "controller":
			path = ".controller";
			break;
		}
		return codeGeneratorConfig.getPackgePath() + path;
	}

	@Override
	public void createEntityTemplate(String tableName, String classDescription) {
		logger.info(">>>>>开始创建实体<<<<<");
		String fileName = FileUtlis.readFileText(filePathUtils.getTemplateEntityFileName());
		fileName = ReplaceUtlis.replace(fileName, replaceMap(tableName, classDescription))
							   .replace("${packgePath}", getPackgePath("entity"))
							   .replace("${alias}", tableColumnsService.getAliasName(tableName))
							   .replace("${table}", tableName).replace("${entityData}", tableColumnsService.getEntityData(tableName));
	
		if (extendsSettings.isExtendsBaseEntity()) {
			fileName = fileName.replace("${extendsBasePath}", extendsSettings.getExtendsBaseEntityPath());
		}
		logger.info("createEntityTemplate:" + fileName);
		FileUtlis.wirteContent(filePathUtils.getWriteEntityFilePath(),
				tableColumnsService.getClassName(tableName) + FileSuffixCommon.javaSuffix, fileName);
		logger.info(">>>>>结束创建实体<<<<<");
	}

	@Override
	public void createDaoTemplate(String tableName, String classDescription) {

		logger.info(">>>>>开始创建DAO<<<<<");
		String fileName = FileUtlis.readFileText(filePathUtils.getTemplateDaoFileName());
		fileName = ReplaceUtlis.replace(fileName, replaceMap(tableName, classDescription))
							   .replace("${packgePath}", getPackgePath("dao"));
		
		if (extendsSettings.isExtendsBaseDao()) {
			fileName = fileName.replace("${extendsBasePath}", extendsSettings.getExtendsBaseDaoPath());
		}
		
		logger.info("createDaoTemplate:" + fileName);
		
		FileUtlis.wirteContent(filePathUtils.getWriteDaoFilePath(),
				tableColumnsService.getClassName(tableName) + FileSuffixCommon.javaDaoSuffix, fileName);
		logger.info(">>>>>结束创建DAO<<<<<");

	}

	@Override
	public void createServiceTemplate(String tableName, String classDescription) {

		logger.info(">>>>>开始创建Service<<<<<");
		String fileName = FileUtlis.readFileText(filePathUtils.getTemplateServiceFileName());
		fileName = ReplaceUtlis.replace(fileName, replaceMap(tableName, classDescription))
							   .replace("${packgePath}", getPackgePath("service"));
		
		if (extendsSettings.isExtendsBaseService()) {
			fileName = fileName.replace("${extendsBasePath}", extendsSettings.getExtendsBaseServicePath());
		}
		logger.info("createServiceTemplate:" + fileName);
		FileUtlis.wirteContent(filePathUtils.getWriteServiceFilePath(),
				tableColumnsService.getClassName(tableName) + FileSuffixCommon.javaServiceSuffix, fileName);
		logger.info(">>>>>结束创建Service<<<<<");
	}

	@Override
	public void createServiceImplTemplate(String tableName, String classDescription) {

		logger.info(">>>>>开始创建ServiceImpl<<<<<");
		String fileName = FileUtlis.readFileText(filePathUtils.getTemplateServiceImplFileName());
		fileName = ReplaceUtlis.replace(fileName, replaceMap(tableName, classDescription))
							   .replace("${lowerClassName}",FormatNameUtlis.formatNameLowerCase(tableColumnsService.getClassName(tableName)))
							   .replace("${packgePath}", getPackgePath("serviceImpl"));
		if (extendsSettings.isExtendsBaseServiceImpl()) {
			fileName = fileName.replace("${extendsBasePath}", extendsSettings.getExtendsBaseServiceImplPath());
		}
		
		logger.info("createServiceImplTemplate:" + fileName);
		FileUtlis.wirteContent(filePathUtils.getWriteServiceImplFilePath(),
				tableColumnsService.getClassName(tableName) + FileSuffixCommon.javaServiceImplSuffix, fileName);
		logger.info(">>>>>结束创建ServiceImpl<<<<<");

	}

	@Override
	public void createControllerTemplate(String tableName, String classDescription) {
		logger.info(">>>>>开始创建controller<<<<<");

		String fileName = FileUtlis.readFileText(filePathUtils.getTemplateControllerFileName());
		fileName = ReplaceUtlis.replace(fileName, replaceMap(tableName, classDescription))
							   .replace("${packgePath}", getPackgePath("controller"))
							   .replace("${lowerClassName}",FormatNameUtlis.formatNameLowerCase(tableColumnsService.getClassName(tableName)));

		if (extendsSettings.isExtendsBaseController()) {
			fileName = fileName.replace("${extendsBasePath}", extendsSettings.getExtendsBaseControllerPath());
		}

		logger.info("createControllerTemplate:" + fileName);
		FileUtlis.wirteContent(filePathUtils.getWriteControllerFilePath(),
				tableColumnsService.getClassName(tableName) + FileSuffixCommon.javaControllerImplSuffix, fileName);

		logger.info(">>>>>结束创建controller<<<<<");
	}

}
