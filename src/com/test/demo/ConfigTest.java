package com.test.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigTest {

	public static void main(String[] args) {
		
		try {
			//1. 构建Properties对象
			Properties p = new Properties();
			//2. 提供File对象指向配置文件		
			File file = new File("config//config.properties");
			//3. 根据文件提供流对象
			InputStream is = new FileInputStream(file);
			//4. 加载流对象
			p.load(is);
			//5. 从文件中获取内容
			String driver = p.getProperty("DRIVER");
			String url = p.getProperty("URL");
			String user = p.getProperty("USER");
			String pwd = p.getProperty("PWD");
			
			System.out.println("Driver:\t" + driver);
			System.out.println("URL:\t" + url);
			System.out.println("USER:\t" + user);
			System.out.println("PWD:\t" + pwd);
		
		} catch (FileNotFoundException e) {			
			e.printStackTrace();
		} catch (IOException e) {			
			e.printStackTrace();
		}
		
		
		
		
	}

}
