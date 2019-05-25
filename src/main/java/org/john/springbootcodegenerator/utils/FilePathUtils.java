package org.john.springbootcodegenerator.utils;

import javax.annotation.Resource;

import org.john.springbootcodegenerator.bean.GlobalSettings;
import org.john.springbootcodegenerator.common.TemplateCommon;
import org.springframework.stereotype.Component;
@Component
public class FilePathUtils {

	@Resource
	private  GlobalSettings codeGeneratorConfig;

	/**
	 * 获取模板实体文件名和路径
	 * 
	 * @author JohnDeng
	 * @datatime 2019年1月17日下午5:24:41
	 * @return
	 */
	public  String getTemplateEntityFileName() {

		return codeGeneratorConfig.getTemplateBasePath() + TemplateCommon.entityTemplateFileName;
	}

	/**
	 * 获取模板DAO文件名和路径
	 * 
	 * @author JohnDeng
	 * @datatime 2019年1月17日下午5:24:41
	 * @return
	 */
	public String getTemplateDaoFileName() {

		return codeGeneratorConfig.getTemplateBasePath() + TemplateCommon.daoTemplateFileName;
	}

	/**
	 * 获取模板Service文件名和路径
	 * 
	 * @author JohnDeng
	 * @datatime 2019年1月17日下午5:24:41
	 * @return
	 */
	public String getTemplateServiceFileName() {

		return codeGeneratorConfig.getTemplateBasePath() + TemplateCommon.serviceTemplateFileName;
	}

	/**
	 * 获取模板ServiceImpl文件名和路径
	 * 
	 * @author JohnDeng
	 * @datatime 2019年1月17日下午5:24:41
	 * @return
	 */
	public String getTemplateServiceImplFileName() {
		return codeGeneratorConfig.getTemplateBasePath() + TemplateCommon.serviceImplTemplateFileName;
	}

	/**
	 * 获取模板Controller文件名和路径
	 * 
	 * @author JohnDeng
	 * @datatime 2019年1月17日下午5:24:41
	 * @return
	 */
	public String getTemplateControllerFileName() {
		return codeGeneratorConfig.getTemplateBasePath() + TemplateCommon.controllerTemplateFileName;
	}
	
	

	/**
	 * 获取写出实体文件路径
	 * 
	 * @author JohnDeng
	 * @datatime 2019年1月17日下午5:31:06
	 * @return
	 */
	public String getWriteEntityFilePath() {

		return codeGeneratorConfig.getWriteFileBasePath() + TemplateCommon.entity;
	}

	/**
	 * 获取写出DAO文件路径
	 * 
	 * @author JohnDeng
	 * @datatime 2019年1月17日下午5:31:06
	 * @return
	 */
	public String getWriteDaoFilePath() {

		return codeGeneratorConfig.getWriteFileBasePath() + TemplateCommon.dao;

	}

	/**
	 * 获取写出Service文件路径
	 * 
	 * @author JohnDeng
	 * @datatime 2019年1月17日下午5:31:06
	 * @return
	 */
	public String getWriteServiceFilePath() {

		return codeGeneratorConfig.getWriteFileBasePath() +TemplateCommon.service;
	}

	/**
	 * 获取写出ServiceImpl文件路径
	 * 
	 * @author JohnDeng
	 * @datatime 2019年1月17日下午5:31:06
	 * @return
	 */
	public String getWriteServiceImplFilePath() {

		return codeGeneratorConfig.getWriteFileBasePath() +TemplateCommon.serviceImpl;
	}

	/**
	 * 获取写出controller文件路径
	 * 
	 * @author JohnDeng
	 * @datatime 2019年1月17日下午5:31:06
	 * @return
	 */
	public String getWriteControllerFilePath() {

		return codeGeneratorConfig.getWriteFileBasePath() + TemplateCommon.controller;
	}

	
	

}
