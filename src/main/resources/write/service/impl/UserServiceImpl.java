package org.john.springbootcodegenerator.service.impl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import null;
import org.john.springbootcodegenerator.dao.UserDao;
import org.john.springbootcodegenerator.entity.User;
import org.john.springbootcodegenerator.service.UserService;
/**
 * ”√ªß
 * @author huangjunwei
 * @datatime 2019-12-20 05:48:00
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<User,null> implements UserService {
	@Resource
	private UserDao userDao;
	
	@PostConstruct
	public void initialize(){
		super.setBaseDao(userDao);
	}
	
}

