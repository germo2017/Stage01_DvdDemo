package com.view.demo;
import java.util.Scanner;

import com.biz.demo.UserBiz;
import com.bizImpl.demo.UserBizImpl;

public class LoginView extends View {

	@Override
	public View showView(){
		
		Scanner scan = new Scanner(System.in);
		System.out.println("�������û���:");
		String userAccount = scan.next();
		System.out.println("����������:");
		String userPwd = scan.next();
		
		UserBiz ub = new UserBizImpl();
		
		if(ub.userlogin(userAccount, userPwd)) {
			System.out.println("��¼�ɹ�!");
			new DvdView().showView();
		}else {
			System.out.println("��¼ʧ��!");
		}		
		scan.close();
		return null;
	}
	
}
