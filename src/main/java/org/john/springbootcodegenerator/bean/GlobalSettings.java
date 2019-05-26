package org.john.springbootcodegenerator.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 全局配置
 * 
 * @author JohnDeng
 * @datatime 2019年3月3日下午3:54:46
 */
@Component
@ConfigurationProperties(prefix = "my。global-settings")
public class GlobalSettings {

	/**
	 * 作者
	 */
	public String author;
	/**
	 * 包路径
	 */
	private String packgePath;
	/**
	 * 读取模板总路径
	 */
	private String templateBasePath;

	/**
	 * 数据库表名前缀
	 */
	private String tablePrefix;
	
	
	private String writeFileBasePath;
	
	public String getWriteFileBasePath() {
		return writeFileBasePath;
	}

	public void setWriteFileBasePath(String writeFileBasePath) {
		this.writeFileBasePath = writeFileBasePath;
	}

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

	public String getTemplateBasePath() {
		return templateBasePath;
	}

	public void setTemplateBasePath(String templateBasePath) {
		this.templateBasePath = templateBasePath;
	}


	public String getTablePrefix() {
		return tablePrefix;
	}

	public void setTablePrefix(String tablePrefix) {
		this.tablePrefix = tablePrefix;
	}

}
