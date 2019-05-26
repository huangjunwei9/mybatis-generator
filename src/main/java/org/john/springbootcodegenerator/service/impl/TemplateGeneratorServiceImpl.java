package org.john.springbootcodegenerator.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.john.springbootcodegenerator.bean.ExtendsSettings;
import org.john.springbootcodegenerator.bean.GlobalSettings;
import org.john.springbootcodegenerator.common.TemplateCommon;
import org.john.springbootcodegenerator.service.TableColumnsService;
import org.john.springbootcodegenerator.service.TemplateGeneratorService;
import org.john.springbootcodegenerator.utils.DateTimeUtils;
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

	/**
	 * 获取包路径
	 * 
	 * @author JohnDeng
	 * @datatime 2019年5月26日下午10:53:38
	 * @param name
	 * @return
	 */
	private String getPackgePath(String name) {
		if (TemplateCommon.entity.equals(name)) {
			return codeGeneratorConfig.getPackgePath() + "." + TemplateCommon.entity;
		} else if (TemplateCommon.dao.equals(name)) {
			return codeGeneratorConfig.getPackgePath() + "." + TemplateCommon.dao;
		} else if (TemplateCommon.service.equals(name)) {
			return codeGeneratorConfig.getPackgePath() + "." + TemplateCommon.service;
		} else if (TemplateCommon.serviceImpl.equals(name)) {
			return codeGeneratorConfig.getPackgePath() + "." + TemplateCommon.service + "." + TemplateCommon.impl;
		} else if (TemplateCommon.controller.equals(name)) {
			return codeGeneratorConfig.getPackgePath() + "." + TemplateCommon.service;
		}
		return "";
	}

	/**
	 * 获取模板路径和名称
	 * 
	 * @author JohnDeng
	 * @datatime 2019年5月26日下午11:12:02
	 * @param name
	 * @return
	 */
	private String getTemplateFileName(String name) {
		if (TemplateCommon.entity.equals(name)) {
			return codeGeneratorConfig.getTemplateBasePath() + TemplateCommon.entityTemplateFileName;
		} else if (TemplateCommon.dao.equals(name)) {
			return codeGeneratorConfig.getTemplateBasePath() + TemplateCommon.daoTemplateFileName;
		} else if (TemplateCommon.service.equals(name)) {
			return codeGeneratorConfig.getTemplateBasePath() + TemplateCommon.serviceTemplateFileName;
		} else if (TemplateCommon.serviceImpl.equals(name)) {
			return codeGeneratorConfig.getTemplateBasePath() + TemplateCommon.serviceImplTemplateFileName;
		} else if (TemplateCommon.controller.equals(name)) {
			return codeGeneratorConfig.getTemplateBasePath() + TemplateCommon.controllerTemplateFileName;
		}
		return "";
	}

	/**
	 * 获取生成路径
	 * 
	 * @author JohnDeng
	 * @datatime 2019年5月26日下午11:12:19
	 * @param name
	 * @return
	 */
	private String getWriteFilePath(String name) {
		if (TemplateCommon.entity.equals(name)) {
			return codeGeneratorConfig.getWriteFileBasePath() + TemplateCommon.entity;
		} else if (TemplateCommon.dao.equals(name)) {
			return codeGeneratorConfig.getWriteFileBasePath() + TemplateCommon.dao;
		} else if (TemplateCommon.service.equals(name)) {
			return codeGeneratorConfig.getWriteFileBasePath() + TemplateCommon.service;
		} else if (TemplateCommon.serviceImpl.equals(name)) {
			return codeGeneratorConfig.getWriteFileBasePath() + TemplateCommon.service + "\\" + TemplateCommon.impl;
		} else if (TemplateCommon.controller.equals(name)) {
			return codeGeneratorConfig.getWriteFileBasePath() + TemplateCommon.controller;
		}
		return "";
	}

	private String getWriteFileName(String name, String tableName) {
		if (TemplateCommon.entity.equals(name)) {
			return tableColumnsService.getClassName(tableName) + TemplateCommon.javaSuffix;
		} else if (TemplateCommon.dao.equals(name)) {
			return tableColumnsService.getClassName(tableName) + TemplateCommon.javaDaoSuffix;
		} else if (TemplateCommon.service.equals(name)) {
			return tableColumnsService.getClassName(tableName) + TemplateCommon.javaServiceSuffix;
		} else if (TemplateCommon.serviceImpl.equals(name)) {
			return tableColumnsService.getClassName(tableName) + TemplateCommon.javaServiceImplSuffix;
		} else if (TemplateCommon.controller.equals(name)) {
			return tableColumnsService.getClassName(tableName) + TemplateCommon.javaControllerImplSuffix;
		}
		return "";
	}

	/**
	 * 生成文件
	 * @author JohnDeng
	 * @datatime 2019年5月26日下午11:24:40
	 * @param name
	 * @param tableName
	 * @param fileName
	 */
	private void fileWrite(String name,String tableName, String fileName) {
		if (TemplateCommon.entity.equals(name)) {
			FileUtlis.wirteContent(getWriteFilePath(TemplateCommon.entity),getWriteFileName(TemplateCommon.entity, tableName), fileName);
		} else if (TemplateCommon.dao.equals(name)) {
			FileUtlis.wirteContent(getWriteFilePath(TemplateCommon.dao),getWriteFileName(TemplateCommon.dao, tableName), fileName);
		} else if (TemplateCommon.service.equals(name)) {
			FileUtlis.wirteContent(getWriteFilePath(TemplateCommon.service),getWriteFileName(TemplateCommon.service, tableName), fileName);
		} else if (TemplateCommon.serviceImpl.equals(name)) {
			FileUtlis.wirteContent(getWriteFilePath(TemplateCommon.serviceImpl),getWriteFileName(TemplateCommon.serviceImpl, tableName), fileName);
		} else if (TemplateCommon.controller.equals(name)) {
			FileUtlis.wirteContent(getWriteFilePath(TemplateCommon.controller),getWriteFileName(TemplateCommon.controller, tableName), fileName);
		}

	}

	@Override
	public void createEntityTemplate(String tableName, String classDescription) {
		logger.info(">>>>>开始创建实体<<<<<");
		String fileName = FileUtlis.readFileText(getTemplateFileName(TemplateCommon.entity));
		fileName = ReplaceUtlis.replace(fileName, replaceMap(tableName, classDescription))
				.replace("${packgePath}", getPackgePath(TemplateCommon.entity))
				.replace("${alias}", tableColumnsService.getAliasName(tableName)).replace("${table}", tableName)
				.replace("${entityData}", tableColumnsService.getEntityData(tableName));

		if (extendsSettings.isExtendsBaseEntity()) {
			fileName = fileName.replace("${extendsBasePath}", extendsSettings.getExtendsBaseEntityPath());
		}
		logger.info("createEntityTemplate:" + fileName);
		fileWrite(TemplateCommon.entity,tableName,fileName);
		logger.info(">>>>>结束创建实体<<<<<");
	}

	@Override
	public void createDaoTemplate(String tableName, String classDescription) {

		logger.info(">>>>>开始创建DAO<<<<<");
		String fileName = FileUtlis.readFileText(getTemplateFileName(TemplateCommon.dao));
		fileName = ReplaceUtlis.replace(fileName, replaceMap(tableName, classDescription)).replace("${packgePath}",
				getPackgePath(TemplateCommon.dao));

		if (extendsSettings.isExtendsBaseDao()) {
			fileName = fileName.replace("${extendsBasePath}", extendsSettings.getExtendsBaseDaoPath());
		}

		logger.info("createDaoTemplate:" + fileName);
		fileWrite(TemplateCommon.dao,tableName,fileName);
		logger.info(">>>>>结束创建DAO<<<<<");

	}

	@Override
	public void createServiceTemplate(String tableName, String classDescription) {

		logger.info(">>>>>开始创建Service<<<<<");
		String fileName = FileUtlis.readFileText(getTemplateFileName(TemplateCommon.service));
		fileName = ReplaceUtlis.replace(fileName, replaceMap(tableName, classDescription)).replace("${packgePath}",
				getPackgePath(TemplateCommon.service));

		if (extendsSettings.isExtendsBaseService()) {
			fileName = fileName.replace("${extendsBasePath}", extendsSettings.getExtendsBaseServicePath());
		}
		logger.info("createServiceTemplate:" + fileName);
		fileWrite(TemplateCommon.service,tableName,fileName);
		logger.info(">>>>>结束创建Service<<<<<");
	}

	@Override
	public void createServiceImplTemplate(String tableName, String classDescription) {

		logger.info(">>>>>开始创建ServiceImpl<<<<<");
		
		String fileName = FileUtlis.readFileText(getTemplateFileName(TemplateCommon.serviceImpl));
		fileName = ReplaceUtlis.replace(fileName, replaceMap(tableName, classDescription))
				.replace("${lowerClassName}",
						FormatNameUtlis.formatNameLowerCase(tableColumnsService.getClassName(tableName)))
				.replace("${packgePath}", getPackgePath(TemplateCommon.serviceImpl));
		if (extendsSettings.isExtendsBaseServiceImpl()) {
			fileName = fileName.replace("${extendsBasePath}", extendsSettings.getExtendsBaseServiceImplPath());
		}

		logger.info("createServiceImplTemplate:" + fileName);
		fileWrite(TemplateCommon.serviceImpl,tableName,fileName);
		logger.info(">>>>>结束创建ServiceImpl<<<<<");

	}

	@Override
	public void createControllerTemplate(String tableName, String classDescription) {
		logger.info(">>>>>开始创建controller<<<<<");

		String fileName = FileUtlis.readFileText(getTemplateFileName(TemplateCommon.controller));
		fileName = ReplaceUtlis.replace(fileName, replaceMap(tableName, classDescription))
				.replace("${packgePath}", getPackgePath(TemplateCommon.controller)).replace("${lowerClassName}",
						FormatNameUtlis.formatNameLowerCase(tableColumnsService.getClassName(tableName)));

		if (extendsSettings.isExtendsBaseController()) {
			fileName = fileName.replace("${extendsBasePath}", extendsSettings.getExtendsBaseControllerPath());
		}

		logger.info("createControllerTemplate:" + fileName);
		fileWrite(TemplateCommon.controller,tableName,fileName);
		logger.info(">>>>>结束创建controller<<<<<");
	}

}
