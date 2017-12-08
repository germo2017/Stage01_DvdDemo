package com.daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.demo.User;

public class DBHelper2 {

	
	//--ODBC6.jar包中  orclae.jdbc 包下的.OracleDriver.class文件的完整路径. 包名.类名
	public static final String DRIVER = "oracle.jdbc.OracleDriver";
	//--这个是固定写法
	/*
	 * jdbc:oracle:thin  协议
	 * 127.0.0.1         host 主机地址
	 * 1521              port 端口号
	 * xe                实例名(体验版是xe 完整orcl) 如果是MySQL等其它数据库那这里该写的要访问的库名
	 */
	public static final String URL = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	//--数据库的登录名
	public static final String USER = "TC25";
	//-- 上面登录名所对应的登录密码
	public static final String PWD = "1234";
	
	//--java.sql.Connection.
	private Connection mConnection;
	
	
	/**
	 * 获取数据库连接.
	 * @return
	 */
	public Connection getConnection() {
		try {
			//-- 加载驱动			
			Class.forName(DRIVER);
			//-- 判断连接对象是否为null
			if (mConnection == null) {
				//-- 实例化连接对象
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
			pStment.executeUpdate();//--增删改.
			
			while (rSet.next()) {
				User u = new User();
				u.setUserAccount(rSet.getString("USERACCOUNT"));
				u.setUserId(rSet.getInt("USERID"));
				u.setUserNickName(rSet.getString("USERNICKNAME"));
				u.setUserPwd(rSet.getString("USERPWD"));
				u.setUserPwdTips(rSet.getString("USERPWDTIPS"));
				u.setUserStatus((rSet.getInt("USERSTATE")>=1)?true:false);
				u.setUserPermission(rSet.getInt("权限"));
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