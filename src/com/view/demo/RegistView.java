package com.view.demo;

import java.util.Scanner;

import com.biz.demo.UserBiz;
import com.bizImpl.demo.UserBizImpl;

public class RegistView extends View {

	
	@Override
	public View showView() {
		Scanner sc = new Scanner(System.in);
		System.out.println("�������û��˺�:");
		String inputuserAccount = sc.next();
		System.out.println("�������û�����:");
		String inputuserPwd = sc.next();
		System.out.println("��ȷ���û�����:");
		String inputuserPwd2 = sc.next();
		System.out.println("�������û�������ʾ��Ϣ:");
		String inputuserPwdTips = sc.next();
		
		if(!inputuserPwd.equals(inputuserPwd2)) {
			System.out.println("�Բ���,���������õ����벻һ��!");
			return null;
		}
		UserBiz ub = new UserBizImpl();
		if(ub.check(inputuserAccount, inputuserPwd, inputuserPwdTips)) {
			System.out.println("ע��ɹ�!");
			new MainView().showView();
		}else {
			System.out.println("ע��ʧ��,������ע��!");
		}	
		sc.close();
		return null;
	}

}
