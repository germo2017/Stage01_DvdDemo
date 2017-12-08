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
		//userAccount��֤ʧ��,ֱ�ӷ���false
		if(u == null) {
			return false;
		}
		//��ʼ��֤����
	//	System.out.println(u);		
		//return userPwd===u.getUserPwd()--�ַ����Ƚ���Ҫ��.equals
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
			System.out.println("�������Ϣ����,��鿴�û����������ʽ!");
		}
		
		return false;
	}
	
	
	

}
