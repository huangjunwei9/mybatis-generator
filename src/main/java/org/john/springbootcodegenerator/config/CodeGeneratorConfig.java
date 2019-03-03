package org.john.springbootcodegenerator.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 代码生成器配置
 * @author JohnDeng
 * @datatime 2019年3月3日下午3:54:46
 */
@Component
public class CodeGeneratorConfig {

	/**
	 * 作者
	 */
	@Value("${my.author}")
	public String author;

	/**
	 * 包路径
	 */
	@Value("${my.packgePath}")
	private String packgePath;

	/**
	 * 读取模板总路径
	 */
	@Value("${my.templateBasePath}")
	private String templateBasePath;
	/**
	 * 生成文件总路径
	 */
	@Value("${my.writeFileBasePath}")
	private String writeFileBasePath;
	/**
	 * 生成继承文件总路径
	 */
	@Value("${my.extendsBasePath}")
	private String extendsBasePath;

	/**
	 * 表名
	 */
	@Value("${spring.datasource.url}")
	public String url;

	/**
	 * 数据库表名前缀
	 */
	@Value("${my.tablePrefix}")
	private String tablePrefix;

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPackgePath() {
		return packgePath;
	}

	public void setPackgePath(String packgePath) {
		this.packgePath = packgePath;
	}

	public String getExtendsBasePath() {
		return extendsBasePath;
	}

	public void setExtendsBasePath(String extendsBasePath) {
		this.extendsBasePath = extendsBasePath;
	}

	public String getWriteFileBasePath() {
		return writeFileBasePath;
	}

	public void setWriteFileBasePath(String writeFileBasePath) {
		this.writeFileBasePath = writeFileBasePath;
	}

	public String getTemplateBasePath() {

		return templateBasePath;
	}

	public void setTemplateBasePath(String templateBasePath) {

		this.templateBasePath = templateBasePath;
	}

	/**
	 * 获取模板实体文件名和路径
	 * 
	 * @author JohnDeng
	 * @datatime 2019年1月17日下午5:24:41
	 * @return
	 */
	public String getTemplateEntityFileName() {

		return this.templateBasePath + "entityTemplate.txt";
	}

	/**
	 * 获取模板DAO文件名和路径
	 * 
	 * @author JohnDeng
	 * @datatime 2019年1月17日下午5:24:41
	 * @return
	 */
	public String getTemplateDaoFileName() {

		return this.templateBasePath + "daoTemplate.txt";
	}

	/**
	 * 获取模板Service文件名和路径
	 * 
	 * @author JohnDeng
	 * @datatime 2019年1月17日下午5:24:41
	 * @return
	 */
	public String getTemplateServiceFileName() {

		return this.templateBasePath + "serviceTemplate.txt";
	}

	/**
	 * 获取模板ServiceImpl文件名和路径
	 * 
	 * @author JohnDeng
	 * @datatime 2019年1月17日下午5:24:41
	 * @return
	 */
	public String getTemplateServiceImplFileName() {
		return this.templateBasePath + "serviceImplTemplate.txt";
	}

	/**
	 * 获取模板Controller文件名和路径
	 * 
	 * @author JohnDeng
	 * @datatime 2019年1月17日下午5:24:41
	 * @return
	 */
	public String getTemplateControllerFileName() {
		return this.templateBasePath + "controllerTemplate.txt";
	}

	/**
	 * 获取写出实体文件路径
	 * 
	 * @author JohnDeng
	 * @datatime 2019年1月17日下午5:31:06
	 * @return
	 */
	public String getWriteEntityFilePath() {

		return this.writeFileBasePath + "entity";
	}

	/**
	 * 获取写出DAO文件路径
	 * 
	 * @author JohnDeng
	 * @datatime 2019年1月17日下午5:31:06
	 * @return
	 */
	public String getWriteDaoFilePath() {

		return this.writeFileBasePath + "dao";
	}

	/**
	 * 获取写出Service文件路径
	 * 
	 * @author JohnDeng
	 * @datatime 2019年1月17日下午5:31:06
	 * @return
	 */
	public String getWriteServiceFilePath() {

		return this.writeFileBasePath + "service";
	}

	/**
	 * 获取写出ServiceImpl文件路径
	 * 
	 * @author JohnDeng
	 * @datatime 2019年1月17日下午5:31:06
	 * @return
	 */
	public String getWriteServiceImplFilePath() {

		return this.writeFileBasePath + "service\\impl";
	}

	/**
	 * 获取写出controller文件路径
	 * 
	 * @author JohnDeng
	 * @datatime 2019年1月17日下午5:31:06
	 * @return
	 */
	public String getWriteControllerFilePath() {

		return this.writeFileBasePath + "controller";
	}

	public String getTablePrefix() {
		return tablePrefix;
	}

	public void setTablePrefix(String tablePrefix) {
		this.tablePrefix = tablePrefix;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDatabaseName() {
		int i = this.url.lastIndexOf("/");
		int j = this.url.indexOf("?");
		return this.url.substring(i + 1, j);
	}

}
