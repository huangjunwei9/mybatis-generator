package org.john.springbootcodegenerator.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 数据库配置信息
 * @author JohnDeng
 * @datatime 2019年5月26日下午7:28:27
 */
@Component
@ConfigurationProperties(prefix = "codegenerator.datasource")
public class DatasourceConfig {

	private String url;
	
	private String username;
	
	private String password;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
