package com.view.demo;

import java.util.Scanner;

import com.biz.demo.UserBiz;
import com.bizImpl.demo.UserBizImpl;

public class RegistView extends View {

	
	@Override
	public View showView() {
		Scanner sc = new Scanner(System.in);
		System.out.println("请设置用户账号:");
		String inputuserAccount = sc.next();
		System.out.println("请设置用户密码:");
		String inputuserPwd = sc.next();
		System.out.println("请确认用户密码:");
		String inputuserPwd2 = sc.next();
		System.out.println("请设置用户密码提示信息:");
		String inputuserPwdTips = sc.next();
		
		if(!inputuserPwd.equals(inputuserPwd2)) {
			System.out.println("对不起,您两次设置的密码不一致!");
			return null;
		}
		UserBiz ub = new UserBizImpl();
		if(ub.check(inputuserAccount, inputuserPwd, inputuserPwdTips)) {
			System.out.println("注册成功!");
			new MainView().showView();
		}else {
			System.out.println("注册失败,请重新注册!");
		}	
		sc.close();
		return null;
	}

}
