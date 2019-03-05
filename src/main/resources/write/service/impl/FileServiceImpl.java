package com.design.framework.service.impl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.design.framework.base.service.impl.BaseServiceImpl;
import com.design.framework.dao.FileDao;
import com.design.framework.entity.File;
import com.design.framework.service.FileService;
/**
 * 文件管理
 * @author johnDeng
 * @datatime 2019-03-05 03:28:29
 */
@Service
public class FileServiceImpl extends BaseServiceImpl<File,String> implements FileService {
	@Resource
	private FileDao fileDao;
	
	@PostConstruct
	public void initialize(){
		super.setBaseDao(fileDao);
	}
	
}

