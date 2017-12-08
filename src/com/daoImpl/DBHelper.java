package com.daoImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBHelper {
	private String driver = null;
	private String url = null;
	private String user = null;
	private String pwd = null;
	Connection mConnection;
	
	public Connection getConnection() {
		
		try {
			//1. ����Properties����
			Properties p = new Properties();
			//2. �ṩFile����ָ�������ļ�		
			File file = new File("config//config.properties");
			//3. �����ļ��ṩ������
			InputStream is = new FileInputStream(file);
			//4. ����������
			p.load(is);
			//5. ���ļ��л�ȡ����
			driver = p.getProperty("DRIVER");
			url = p.getProperty("URL");
			user = p.getProperty("USER");
			pwd = p.getProperty("PWD");
			/*
			System.out.println("Driver:\t" + driver);
			System.out.println("URL:\t" + url);
			System.out.println("USER:\t" + user);
			System.out.println("PWD:\t" + pwd);
			 */
		} catch (FileNotFoundException e) {			
			e.printStackTrace();
		} catch (IOException e) {			
			e.printStackTrace();
		}
		
		if(mConnection == null) {
			try {
				Class.forName(driver);
				mConnection = DriverManager.getConnection(url, user, pwd);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		return mConnection;
	}
	
	
}
