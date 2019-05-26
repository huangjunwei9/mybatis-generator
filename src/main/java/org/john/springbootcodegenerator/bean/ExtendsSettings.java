package org.john.springbootcodegenerator.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 继承配置
 * <p>
 * 配置信息详情，看application。yml
 * </p>
 * 
 * @author JohnDeng
 * @datatime 2019年5月26日下午7:25:40
 */
@Component
@ConfigurationProperties(prefix = "my.extends-settings")
public class ExtendsSettings {
	
	/**
	 * 是否需要继承Entity父类
	 */
	private boolean extendsBaseEntity;
	/**
	 * 是否需要继承Dao父类
	 */
	private boolean extendsBaseDao;
	/**
	 * 是否需要继承Service父类
	 */
	private boolean extendsBaseService;
	/**
	 * 是否需要继承ServiceImpl父类
	 */
	private boolean extendsBaseServiceImpl;
	/**
	 * 是否需要继承Controller父类
	 */
	private boolean extendsBaseController;

	/**
	 * 继承Entity父类路径
	 */
	private String extendsBaseEntityPath;
	/**
	 * 继承Dao父类路径
	 */
	private String extendsBaseDaoPath;
	/**
	 * 继承Service父类路径
	 */
	private String extendsBaseServicePath;
	/**
	 * 继承ServiceImpl父类路径
	 */
	private String extendsBaseServiceImplPath;
	/**
	 * 继承Controller父类路径
	 */
	private String extendsBaseControllerPath;

	public boolean isExtendsBaseEntity() {
		return extendsBaseEntity;
	}

	public void setExtendsBaseEntity(boolean extendsBaseEntity) {
		this.extendsBaseEntity = extendsBaseEntity;
	}

	public boolean isExtendsBaseDao() {
		return extendsBaseDao;
	}

	public void setExtendsBaseDao(boolean extendsBaseDao) {
		this.extendsBaseDao = extendsBaseDao;
	}

	public boolean isExtendsBaseService() {
		return extendsBaseService;
	}

	public void setExtendsBaseService(boolean extendsBaseService) {
		this.extendsBaseService = extendsBaseService;
	}

	public boolean isExtendsBaseServiceImpl() {
		return extendsBaseServiceImpl;
	}

	public void setExtendsBaseServiceImpl(boolean extendsBaseServiceImpl) {
		this.extendsBaseServiceImpl = extendsBaseServiceImpl;
	}

	public boolean isExtendsBaseController() {
		return extendsBaseController;
	}

	public void setExtendsBaseController(boolean extendsBaseController) {
		this.extendsBaseController = extendsBaseController;
	}

	public String getExtendsBaseEntityPath() {
		return extendsBaseEntityPath;
	}

	public void setExtendsBaseEntityPath(String extendsBaseEntityPath) {
		this.extendsBaseEntityPath = extendsBaseEntityPath;
	}

	public String getExtendsBaseDaoPath() {
		return extendsBaseDaoPath;
	}

	public void setExtendsBaseDaoPath(String extendsBaseDaoPath) {
		this.extendsBaseDaoPath = extendsBaseDaoPath;
	}

	public String getExtendsBaseServicePath() {
		return extendsBaseServicePath;
	}

	public void setExtendsBaseServicePath(String extendsBaseServicePath) {
		this.extendsBaseServicePath = extendsBaseServicePath;
	}

	public String getExtendsBaseServiceImplPath() {
		return extendsBaseServiceImplPath;
	}

	public void setExtendsBaseServiceImplPath(String extendsBaseServiceImplPath) {
		this.extendsBaseServiceImplPath = extendsBaseServiceImplPath;
	}

	public String getExtendsBaseControllerPath() {
		return extendsBaseControllerPath;
	}

	public void setExtendsBaseControllerPath(String extendsBaseControllerPath) {
		this.extendsBaseControllerPath = extendsBaseControllerPath;
	}

}
