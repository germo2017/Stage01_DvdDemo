package com.tool.demo;

import java.util.ArrayList;
import java.util.Scanner;
import com.bean.demo.User;

public class UserToolTest {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		ArrayList<User> userList = new ArrayList<>();			
		User u1 = new User(1, 201, "Andy", "psw2017", 1, 1);
		User u2 = new User(2, 145, "Beta", "psw2017", 0, 1);
		User u3 = new User(3, 39, "Catty", "psw2017", 0, 1);
		userList.add(u1);
		userList.add(u2);
		userList.add(u3);
		
		UserTool ut = new UserTool();
		System.out.println("-----已有用户-----");
		ut.showAllUser(userList);

		System.out.println("-----准备添加用户-----");
		while (true) {			
			try {				
				userList.add(ut.addUser(userList, ut.creatUserAccount(userList)));
				System.out.println("成功添加用户!");

				System.out.println("是否继续添加新用户:Y/N?");
				String isGo = sc.next();
				if ("n".equalsIgnoreCase(isGo)) {
					System.out.println("更新后的所有用户：");
					ut.showAllUser(userList);
					break;
				} else {
					continue;
				}
			} catch (Exception e) {
				System.out.println("-----添加用户失败!-------");
				System.out.println(e.getMessage());
			}//try结束
		}//while结束	
		
		System.out.println("------------------");
		for (User u : userList) {
			System.out.println(u.toString());
		} 
		
		System.out.println("-----准备修改用户信息-----");
		System.out.println("请输入您要修改的用户ID或账号");		
		userList = ut.reviseUser(userList, sc.nextInt());
		
		System.out.println("-----准备删除用户-----");
		System.out.println("请输入您要删除的用户ID或账号");				
		userList.remove(ut.delectUser(userList, sc.nextInt()));
		
		
		
		sc.close();

	}

}
