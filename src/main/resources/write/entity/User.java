package org.john.springbootcodegenerator.entity;

import com.design.framework.base.controller.BaseEntity;
import org.apache.ibatis.type.Alias;
import javax.persistence.Table;

/**
 * ”√ªß
 * @author huangjunwei
 * @datatime 2019-12-20 05:47:40
 */
@Alias(value = "user")
@Table(name="tb_user")
public class User extends BaseEntity<null>{
	
	private static final long serialVersionUID = 1L;
	

	

}

