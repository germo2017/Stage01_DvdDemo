package com.view.demo;

import java.util.Scanner;

public class MainView extends View{

	@Override
	public View showView() {
		System.out.println("=====================");
		System.out.println("   ��ӭʹ��DVD����ϵͳ");
		System.out.println("=====================");
		System.out.println("1.�û���¼");
		System.out.println("2.�û�ע��");
		System.out.println("3.����Ա��¼");
		System.out.println("0.�˳�");
		System.out.println("������ѡ��:");
		Scanner scan = new Scanner(System.in);
		int choose = scan.nextInt();
		switch (choose) {
		case 0:
			System.out.println("��л��ʹ�ñ�ϵͳ,�ټ�!");
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
