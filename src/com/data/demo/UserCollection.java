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
		aru= new ArrayList<>();//把集合的新建放在构造方法里面
		aru.add(new User(1, "zybaaaa@qq.com", "germoo", "123456", "数字", true));
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
		System.out.println("请设置用户名(邮箱)：");
		while(true) {
		String account = sc.next();
		    // 邮箱验证规则
		    String regEx = "[a-zA-Z_]{1,}[0-9]{0,}@(([a-zA-z0-9]-*){1,}\\.){1,3}[a-zA-z\\-]{1,}";
		    // 编译正则表达式
		    Pattern pattern = Pattern.compile(regEx);
		    // 忽略大小写的写法
		    // Pattern pat = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
		    Matcher matcher = pattern.matcher(account);
		    // 字符串是否与正则表达式相匹配
		    boolean rs = matcher.matches();
		    if(rs) {
		    	newUser.setUserAccount(account);
		    	break;
		    }else {
		    	System.out.println("用户名(邮箱)格式错误,请重新设置:");
		    	continue;
		    }		    
		}		
		System.out.println("请设置昵称：");
		newUser.setUserNickname(sc.next());
		System.out.println("请设置密码：(长度限制为6-16位,可用大小写字母,数字,_(下划线),.(点),*(星号)作为字符)");
		String pwd1;
		String pwd2;
		boolean isPwd12Same = true;
		do {
			while(true) {
				pwd1 = sc.next();			   
			    String regEx = "[a-zA-Z0-9_.*]{6,16}";
			    Pattern pattern = Pattern.compile(regEx);
			    Matcher matcher = pattern.matcher(pwd1);
			    // 字符串是否与正则表达式相匹配
			    boolean rs = matcher.matches();
			    if(rs) {
			    	newUser.setUserPwd(pwd1);
			    	break;
			    }else {
			    	System.out.println("密码格式错误,请重新设置:");
			    	continue;
			    }		    
			}
			System.out.println("请再次输入以确认密码：");
			pwd2 = sc.next();
			if(pwd1.equals(pwd2)) {
				isPwd12Same = false;
			}else {
				System.out.println("对不起,您两次设置的密码不一致,请重新设置密码：");
				isPwd12Same = true;
			}
		}while(isPwd12Same);			
		newUser.setUserPwd(pwd1);
		
		System.out.println("请设置密码提示：");
		newUser.setUserPwdTip(sc.next());
		newUser.setUserId(aru.size()+1);
		newUser.setUserStatus(true);
		aru.add(newUser);
		System.out.println("添加注册用户成功！");
		System.out.println("您已添加以下用户：");
		System.out.println(aru.get(aru.size()-1));
	}
	
	public void verifyUser(){
		Scanner sc2 = new Scanner(System.in);
		System.out.println("请输入用户名或昵称：");	
		String accountOrNickName = sc2.next();
		System.out.println("请输入密码：");
		String pw = sc2.next();
		int i = aru.size();
		for (User user : aru) {			
			if((user.getUserAccount().equals(accountOrNickName) || user.getUserNickname().equals(accountOrNickName)) 
			&& user.getUserPwd().equals(pw)) {
				System.out.println("登录成功！");
				break;
			}else if(i!=1){
				i--;
				continue;
			}else {
				System.out.println("登录失败！");		
			}		
		}
	}
	
}
