package com.design.framework.controller;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.design.framework.entity.File;
import com.design.framework.service.FileService;
import com.design.framework.base.controller.BaseController;

/**
 * 文件管理
 * @author johnDeng
 * @datatime 2019-03-05 03:28:30
 */
@Controller
@RequestMapping("/pc/file")
public class FileController extends BaseController<File,String>{
	
	@Resource
	private FileService fileService;
	
	@PostConstruct
	public void initialize() {
		super.setBaseService(fileService);
	}
	
}

