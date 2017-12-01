package com.daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.bean.demo.User;

public class DBHelper {
	//--A.�ṩ�ĸ�����
	//1. ODBC6.jar���� oracle.jdbc���µ�.OracleDriver.class�ļ�������·�� ����.����
	public static final String DRIVER ="oracle.jdbc.OracleDriver"; //������ĸȫ��д
	//2. ����Ϊ�̶��÷�
	/*
	 * jdbc:oracle:thin			Э��
	 * localhost/127.0.0.1      host������ַ
	 * 1521						port�˿ں�
	 * xe						ʵ����(�������xe ��������orcl)			
	 * �����MySQL���������ݿ�,��ô����Ӧ��дҪ���ʵĿ���
	 */
	public static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	//3&4. ���ݿ�ĵ�¼���͵�¼����
	public static final String USER = "TC25";
	public static final String PWD = "1234";
	
	//--B. java.sql.Connection��������
	//ͨ��3���������ʺͲ������ݿ�
	private Connection mConnection;	
	/**
	 * ��ȡ���ݿ�����
	 */
	
	public Connection getConnection() {		
		try {
			//��һ��:��������
			Class.forName(DRIVER);
			//�ж����Ӷ����Ƿ�Ϊnull
			if(mConnection == null) {
				mConnection = DriverManager.getConnection(URL, USER, PWD);
			}			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		//	System.out.println("fsag0");
		}		
		return mConnection;
		
	}
	public static void main(String[] args) {
		DBHelper db = new DBHelper();
		ArrayList<User> array = new ArrayList<>();
		//�ڶ���:Ԥ����׼������,����ִ��sql���
		try {
			Connection conn = db.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from DVD_USER");
			ResultSet rs = ps.executeQuery();//��ѯ
			ps.executeUpdate();//��ɾ��
			System.out.println("fsag1");
			while(rs.next()) {
				User u = new User();
				u.setUserAccount(rs.getString("USERACCOUNT"));
				u.setUserId(rs.getInt("USERID"));
				u.setUserNickname(rs.getString("USERNICKNAME"));
				u.setUserPwd(rs.getString("USERPWD"));
				u.setUserPwdTip(rs.getString("USERPWDTIPS"));
				u.setUserStatus((rs.getInt("USERSTATE")>=1)?true:false);
				u.setUserPermission(rs.getInt("Ȩ��"));
				array.add(u);
				System.out.println(u.toString());
				System.out.println("fsag2");
			}
		
		} catch (SQLException e) {
		//	System.out.println("fsag3");
			e.printStackTrace();			
		}
		for (User user : array) {
			System.out.println(user);
		}
		
	}

}
