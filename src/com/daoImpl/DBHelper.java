package com.daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.bean.demo.User;

public class DBHelper {
	//--A.提供四个常量
	//1. ODBC6.jar包中 oracle.jdbc包下的.OracleDriver.class文件的完整路径 包名.类名
	public static final String DRIVER ="oracle.jdbc.OracleDriver"; //常量字母全大写
	//2. 以下为固定用法
	/*
	 * jdbc:oracle:thin			协议
	 * localhost/127.0.0.1      host主机地址
	 * 1521						port端口号
	 * xe						实例名(体验版是xe 完整版是orcl)			
	 * 如果是MySQL等其他数据库,那么这里应该写要访问的库名
	 */
	public static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	//3&4. 数据库的登录名和登录密码
	public static final String USER = "TC25";
	public static final String PWD = "1234";
	
	//--B. java.sql.Connection建立连接
	//通过3个类来访问和操作数据库
	private Connection mConnection;	
	/**
	 * 获取数据库连接
	 */
	
	public Connection getConnection() {		
		try {
			//第一步:加载驱动
			Class.forName(DRIVER);
			//判断连接对象是否为null
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
		//第二步:预处理准备连接,负责执行sql语句
		try {
			Connection conn = db.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from DVD_USER");
			ResultSet rs = ps.executeQuery();//查询
			ps.executeUpdate();//增删改
			System.out.println("fsag1");
			while(rs.next()) {
				User u = new User();
				u.setUserAccount(rs.getString("USERACCOUNT"));
				u.setUserId(rs.getInt("USERID"));
				u.setUserNickname(rs.getString("USERNICKNAME"));
				u.setUserPwd(rs.getString("USERPWD"));
				u.setUserPwdTip(rs.getString("USERPWDTIPS"));
				u.setUserStatus((rs.getInt("USERSTATE")>=1)?true:false);
				u.setUserPermission(rs.getInt("权限"));
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
