package com.bizImpl.demo;

import java.sql.SQLException;

import com.bean.demo.User;
import com.biz.demo.UserBiz;
import com.dao.demo.UserDao;
import com.daoImpl.UserDaoImpl;

public class UserBizImpl implements UserBiz{
	UserDao ud;
	User u;
	
	
	public UserBizImpl() {
		ud = new UserDaoImpl();
		u = null;
	}

	@Override
	public boolean userlogin(String userAccount, String userPwd) {
		if(userAccount == null || userPwd == null ||userAccount.length() == 0 || userPwd.length() == 0) {
			return false;
		}
		try {
			u = ud.getUserByUserAccount(userAccount);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		//userAccount验证失败,直接返回false
		if(u == null) {
			return false;
		}
		//开始验证密码
	//	System.out.println(u);		
		//return userPwd===u.getUserPwd()--字符串比较需要用.equals
		return userPwd.equals(u.getUserPwd());
	}

	@Override
	public boolean check(String inputAccount, String inputPwd, String inputPwdTips) {
		if (inputAccount == null || inputPwd == null || inputPwdTips == null || inputAccount.length() == 0 || inputPwd.length() == 0 || inputPwdTips.length() == 0) {
			return false;
		}
		try {
			u = ud.registUser(inputAccount, inputPwd, inputPwdTips);
			return true;
		} catch (Exception e) {
			System.out.println("输入的信息有误,请查看用户名及密码格式!");
		}
		
		return false;
	}
	
	
	

}
