package com.dao.demo;

import java.sql.SQLException;

import com.bean.demo.User;

public interface UserDao {
/**
 * ���ݿ�Ĳ���,��ɾ�Ĳ�Ĵ���д��ʵ������
 * (�����û��˻���ȡUser����)
 * @throws SQLException 
 */
	
	public User getUserByUserAccount(String userAccount) throws SQLException;
	public User registUser(String inputAccount, String inputPwd1, String inputPwdTips) throws SQLException;
	
}
