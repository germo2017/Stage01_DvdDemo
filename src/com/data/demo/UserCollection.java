package com.data.demo;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.bean.demo.User;

public class UserCollection {
	ArrayList<User> aru;	
	
	public UserCollection() {		
		super();
		aru= new ArrayList<>();//�Ѽ��ϵ��½����ڹ��췽������
		aru.add(new User(1, "zybaaaa@qq.com", "germoo", "123456", "����", true));
		aru.add(new User(2, "admin@qq.com", "admin", "admin", "admin", true));
		aru.add(new User(3, "admin2@qq.com", "admin2", "admin2", "admin2", true));
	}
	
	public void viewAllUser() {
		for (User user : aru) {
			System.out.println(user);
		}
	}

	public void addUser() {
		Scanner sc = new Scanner(System.in);
		User newUser = new User();
		System.out.println("�������û���(����)��");
		while(true) {
		String account = sc.next();
		    // ������֤����
		    String regEx = "[a-zA-Z_]{1,}[0-9]{0,}@(([a-zA-z0-9]-*){1,}\\.){1,3}[a-zA-z\\-]{1,}";
		    // ����������ʽ
		    Pattern pattern = Pattern.compile(regEx);
		    // ���Դ�Сд��д��
		    // Pattern pat = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
		    Matcher matcher = pattern.matcher(account);
		    // �ַ����Ƿ���������ʽ��ƥ��
		    boolean rs = matcher.matches();
		    if(rs) {
		    	newUser.setUserAccount(account);
		    	break;
		    }else {
		    	System.out.println("�û���(����)��ʽ����,����������:");
		    	continue;
		    }		    
		}		
		System.out.println("�������ǳƣ�");
		newUser.setUserNickname(sc.next());
		System.out.println("���������룺(��������Ϊ6-16λ,���ô�Сд��ĸ,����,_(�»���),.(��),*(�Ǻ�)��Ϊ�ַ�)");
		String pwd1;
		String pwd2;
		boolean isPwd12Same = true;
		do {
			while(true) {
				pwd1 = sc.next();			   
			    String regEx = "[a-zA-Z0-9_.*]{6,16}";
			    Pattern pattern = Pattern.compile(regEx);
			    Matcher matcher = pattern.matcher(pwd1);
			    // �ַ����Ƿ���������ʽ��ƥ��
			    boolean rs = matcher.matches();
			    if(rs) {
			    	newUser.setUserPwd(pwd1);
			    	break;
			    }else {
			    	System.out.println("�����ʽ����,����������:");
			    	continue;
			    }		    
			}
			System.out.println("���ٴ�������ȷ�����룺");
			pwd2 = sc.next();
			if(pwd1.equals(pwd2)) {
				isPwd12Same = false;
			}else {
				System.out.println("�Բ���,���������õ����벻һ��,�������������룺");
				isPwd12Same = true;
			}
		}while(isPwd12Same);			
		newUser.setUserPwd(pwd1);
		
		System.out.println("������������ʾ��");
		newUser.setUserPwdTip(sc.next());
		newUser.setUserId(aru.size()+1);
		newUser.setUserStatus(true);
		aru.add(newUser);
		System.out.println("���ע���û��ɹ���");
		System.out.println("������������û���");
		System.out.println(aru.get(aru.size()-1));
	}
	
	public void verifyUser(){
		Scanner sc2 = new Scanner(System.in);
		System.out.println("�������û������ǳƣ�");	
		String accountOrNickName = sc2.next();
		System.out.println("���������룺");
		String pw = sc2.next();
		int i = aru.size();
		for (User user : aru) {			
			if((user.getUserAccount().equals(accountOrNickName) || user.getUserNickname().equals(accountOrNickName)) 
			&& user.getUserPwd().equals(pw)) {
				System.out.println("��¼�ɹ���");
				break;
			}else if(i!=1){
				i--;
				continue;
			}else {
				System.out.println("��¼ʧ�ܣ�");		
			}		
		}
	}
	
}
