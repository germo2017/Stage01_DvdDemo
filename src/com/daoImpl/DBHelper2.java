package com.daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.demo.User;

public class DBHelper2 {

	
	//--ODBC6.jar����  orclae.jdbc ���µ�.OracleDriver.class�ļ�������·��. ����.����
	public static final String DRIVER = "oracle.jdbc.OracleDriver";
	//--����ǹ̶�д��
	/*
	 * jdbc:oracle:thin  Э��
	 * 127.0.0.1         host ������ַ
	 * 1521              port �˿ں�
	 * xe                ʵ����(�������xe ����orcl) �����MySQL���������ݿ��������д��Ҫ���ʵĿ���
	 */
	public static final String URL = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	//--���ݿ�ĵ�¼��
	public static final String USER = "TC25";
	//-- �����¼������Ӧ�ĵ�¼����
	public static final String PWD = "1234";
	
	//--java.sql.Connection.
	private Connection mConnection;
	
	
	/**
	 * ��ȡ���ݿ�����.
	 * @return
	 */
	public Connection getConnection() {
		try {
			//-- ��������			
			Class.forName(DRIVER);
			//-- �ж����Ӷ����Ƿ�Ϊnull
			if (mConnection == null) {
				//-- ʵ�������Ӷ���
				mConnection = DriverManager.getConnection(URL, USER, PWD);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return mConnection;
	}
	
	public static void main(String[] args) {
		
		DBHelper2 db = new DBHelper2();
		ArrayList<User> list = new ArrayList<>();
		try {
			Connection conn = db.getConnection();
			PreparedStatement pStment = conn.prepareStatement("select * from DVD_USER");
			ResultSet rSet = pStment.executeQuery();
			pStment.executeUpdate();//--��ɾ��.
			
			while (rSet.next()) {
				User u = new User();
				u.setUserAccount(rSet.getString("USERACCOUNT"));
				u.setUserId(rSet.getInt("USERID"));
				u.setUserNickName(rSet.getString("USERNICKNAME"));
				u.setUserPwd(rSet.getString("USERPWD"));
				u.setUserPwdTips(rSet.getString("USERPWDTIPS"));
				u.setUserStatus((rSet.getInt("USERSTATE")>=1)?true:false);
				u.setUserPermission(rSet.getInt("Ȩ��"));
				list.add(u);
			}	
		} catch (SQLException e) {		
			e.printStackTrace();
		}
		
		for (User user : list) {
			System.out.println(user);
		}
		
		
		
		
		
	}
		
		
		
		
		
		
	}