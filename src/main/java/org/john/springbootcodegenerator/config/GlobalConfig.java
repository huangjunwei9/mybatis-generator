package org.john.springbootcodegenerator.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 全局配置
 *
 * @datatime 2019年3月3日下午3:54:46
 */
@Component
@ConfigurationProperties(prefix = "codegenerator.global")
public class GlobalConfig {

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
	 * 输出文件总路径
	 */
	private String writeFileBasePath;

	/**
	 * 数据库表名前缀
	 */
	private String tablePrefix;
	
	/**
	 * mybatis生成的路径
	 */
	
	private String  mapperPath;
	

	public String getMapperPath() {
		return mapperPath;
	}

	public void setMapperPath(String mapperPath) {
		this.mapperPath = mapperPath;
	}

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
