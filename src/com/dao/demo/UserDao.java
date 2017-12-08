package com.dao.demo;

import java.sql.SQLException;

import com.bean.demo.User;

public interface UserDao {
/**
 * 数据库的操作,增删改查的代码写在实现类中
 * (根据用户账户获取User对象)
 * @throws SQLException 
 */
	
	public User getUserByUserAccount(String userAccount) throws SQLException;
	public User registUser(String inputAccount, String inputPwd1, String inputPwdTips) throws SQLException;
	
}
