package org.john.springbootcodegenerator.controller;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.john.springbootcodegenerator.entity.User;
import org.john.springbootcodegenerator.service.UserService;
import com.design.framework.base.controller.BaseController;

/**
 * ”√ªß
 * @author huangjunwei
 * @datatime 2019-12-20 05:48:00
 */
@RestController
@RequestMapping("/pc/user")
public class UserController extends BaseController<User,null>{
	
	@Resource
	private UserService userService;
	
	@PostConstruct
	public void initialize() {
		super.setBaseService(userService);
	}
	
}

