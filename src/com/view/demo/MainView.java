package com.view.demo;

import java.util.Scanner;

public class MainView extends View{

	@Override
	public View showView() {
		System.out.println("=====================");
		System.out.println("   欢迎使用DVD管理系统");
		System.out.println("=====================");
		System.out.println("1.用户登录");
		System.out.println("2.用户注册");
		System.out.println("3.管理员登录");
		System.out.println("0.退出");
		System.out.println("请输入选项:");
		Scanner scan = new Scanner(System.in);
		int choose = scan.nextInt();
		switch (choose) {
		case 0:
			System.out.println("感谢您使用本系统,再见!");
			break;
		case 1:
			View lv = new LoginView();
			lv.showView();
			break;
		case 2:
			View rv = new RegistView();
			rv.showView();
			break;
		}
		scan.close();
		return null;
	}
}
