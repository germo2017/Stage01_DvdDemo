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
		// --问号叫做占位符.
		String sql = "select * from DVD_User where userAccount = ?";
		// --通过连接获取PreparedStatement对象
		mStatement = mConnection.prepareStatement(sql);
		// --通过PreparedStatement对象给占位符做赋值操作
		mStatement.setString(1, userAccount);
		// --通过PreparedStatement调用方法来执行查询语句并获取结果集对象
		// executeQuery 是查询专用
		/*
		 * 如果查的到则结果集中有数据.否则结果集为null
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
			u.setUserPermission(rSet.getInt("权限"));
			//System.out.println(u);
		}
		return u;
	}

	@Override
	public User registUser(String inputAccount, String inputPwd1, String inputPwdTips) throws SQLException {
		//(default, ?, default, ?, ?, default)"
		String sql = "insert into DVD_User values(User_seq.nextval, ?, 'newNickName', ?, ?, default,default)";
		//通过连接获取PreparedStatement对象
		mStatement = mConnection.prepareStatement(sql);
		mStatement.setString(1, inputAccount);
		mStatement.setString(2, inputPwd1);
		mStatement.setString(3, inputPwdTips);
		/*
		 *mStatement.executeUpdate()返回更新的结果集中的数据行数
		 */
		rInt = mStatement.executeUpdate();
		if (rInt > 0) {
			return getUserByUserAccount(inputAccount);
		}
		return null;
	}
	

}
