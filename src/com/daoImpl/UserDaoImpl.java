package com.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bean.demo.User;
import com.dao.demo.UserDao;

public class UserDaoImpl implements UserDao {

	private Connection mConnection;
	private PreparedStatement mStatement;
	private ResultSet rSet;
	private DBHelper mDB;
	private int rInt;

	public UserDaoImpl() {
		mDB = new DBHelper();
		mConnection = mDB.getConnection();
		rSet = null;
	}

	@Override
	public User getUserByUserAccount(String userAccount) throws SQLException {
		// --�ʺŽ���ռλ��.
		String sql = "select * from DVD_User where userAccount = ?";
		// --ͨ�����ӻ�ȡPreparedStatement����
		mStatement = mConnection.prepareStatement(sql);
		// --ͨ��PreparedStatement�����ռλ������ֵ����
		mStatement.setString(1, userAccount);
		// --ͨ��PreparedStatement���÷�����ִ�в�ѯ��䲢��ȡ���������
		// executeQuery �ǲ�ѯר��
		/*
		 * �����ĵ���������������.��������Ϊnull
		 */
		rSet = mStatement.executeQuery();
		if (rSet == null) {
			return null;
		}
		User u = null;
		while (rSet.next()) {
			u = new User();
			u.setUserId(rSet.getInt("USERID"));
			u.setUserAccount(rSet.getString("USERACCOUNT"));
			u.setUserNickName(rSet.getString("USERNICKNAME"));
			u.setUserPwd(rSet.getString("USERPWD"));
			u.setUserPwdTips(rSet.getString("USERPWDTIPS"));
			u.setUserStatus((rSet.getInt("USERSTATE"))==1?true:false);
			u.setUserPermission(rSet.getInt("Ȩ��"));
			//System.out.println(u);
		}
		return u;
	}

	@Override
	public User registUser(String inputAccount, String inputPwd1, String inputPwdTips) throws SQLException {
		//(default, ?, default, ?, ?, default)"
		String sql = "insert into DVD_User values(User_seq.nextval, ?, 'newNickName', ?, ?, default,default)";
		//ͨ�����ӻ�ȡPreparedStatement����
		mStatement = mConnection.prepareStatement(sql);
		mStatement.setString(1, inputAccount);
		mStatement.setString(2, inputPwd1);
		mStatement.setString(3, inputPwdTips);
		/*
		 *mStatement.executeUpdate()���ظ��µĽ�����е���������
		 */
		rInt = mStatement.executeUpdate();
		if (rInt > 0) {
			return getUserByUserAccount(inputAccount);
		}
		return null;
	}
	

}
