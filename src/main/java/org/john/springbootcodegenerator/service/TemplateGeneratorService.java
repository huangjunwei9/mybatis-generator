package org.john.springbootcodegenerator.service;

public interface TemplateGeneratorService {

	public void createEntityTemplate(String tableName, String classDescription);
	
	public void createDaoTemplate(String tableName, String classDescription);
	
	public void createServiceTemplate(String tableName, String classDescription);
	
	public void createServiceImplTemplate(String tableName, String classDescription) ;
	
	public void createControllerTemplate(String tableName, String classDescription);
	
}
