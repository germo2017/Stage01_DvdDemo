package com.view.demo;
import java.util.Scanner;

import com.biz.demo.UserBiz;
import com.bizImpl.demo.UserBizImpl;

public class LoginView extends View {

	@Override
	public View showView(){
		
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入用户名:");
		String userAccount = scan.next();
		System.out.println("请输入密码:");
		String userPwd = scan.next();
		
		UserBiz ub = new UserBizImpl();
		
		if(ub.userlogin(userAccount, userPwd)) {
			System.out.println("登录成功!");
			new DvdView().showView();
		}else {
			System.out.println("登录失败!");
		}		
		scan.close();
		return null;
	}
	
}
