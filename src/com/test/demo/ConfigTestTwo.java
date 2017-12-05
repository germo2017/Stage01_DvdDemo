package com.test.demo;

import java.io.IOException;
import java.util.Properties;

public class ConfigTestTwo {

	public static void main(String[] args) {
		Properties p = new Properties();
		try {
			p.load(ConfigTestTwo.class.getClassLoader().getResourceAsStream("cd..//config//config.properties"));
			System.out.println(p.getProperty("DRIVER"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		

	}

}
