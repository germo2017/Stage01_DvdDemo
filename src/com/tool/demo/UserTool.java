package com.tool.demo;
import com.bean.demo.User;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * 
 * @ClassName:	 User.java
 * @Package:	 com.bean.demo
 * @Description: User的各种方法的类
 *
 * @author	Administrator
 * @date	2017年11月17日下午7:17:03
 * @version	1.0
 */
public class UserTool {
	
	/**
	 * 
	 * @Description: User查看所有用户的方法
	 */
	public void showAllUser(ArrayList<User> userList) {
		for (User u : userList) {
			System.out.println(u.toString());
		}
	}
	
	/**
	 * 
	 * @Description: 增加新用户的方法
	 */
	public User addUser(ArrayList<User> userList, int account) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请设置昵称：");
		String nickname = sc.next();
		System.out.println("请设置密码");
		String pwd = sc.next();
		System.out.println("请设置性别：1男, 0 女 ");
		int gendar = sc.nextInt();

		Iterator<User> it = userList.iterator();
		User ui = null;
		while (it.hasNext()) {
			ui = (User) it.next();
		}
		User ux = new User();
		ux.setId(ui.getId() + 1);// id需要自动生成
		// ux.setAccount((int)(Math.random()*100+1));//账户号是自动生成的，且不重复
		ux.setAccount(account);
		ux.setNickname(nickname);
		ux.setPwd(pwd);
		ux.setGendar(gendar);
		ux.setVipLevel(1);

		return ux;
	}
	
	/**
	 * 
	 * @Description: 自动生成不重复的账户号的方法
	 */
	public int creatUserAccount(ArrayList<User> userList) {
		int autoAccount = 0;
		while (true) {
			boolean isContinue = true;
			int temp = (int) (Math.random() * 1000 + 1);
			for (int i = 0; i < userList.size(); i++) {
				// 判断是否重复
				if (userList.get(i).getAccount() != temp) {
					continue;
				} else {
					isContinue = false;
				}
			}

			if (!isContinue) {
				continue;
			} else {
				autoAccount = temp;
				break;
			}
		}
		return autoAccount;
	}

	/**
	 * 
	 * @return 
	 * @Description: 删除用户的方法
	 */
	public int delectUser(ArrayList<User> userList, int idOrAccount) {
		int i = 0;
		try {
			for (i=0; i < userList.size(); i++) {
				User ui = userList.get(i);
				if (ui.getId() == idOrAccount || ui.getAccount() == idOrAccount) {
					userList.remove(ui);
				}
			}
			System.out.println("删除成功!");
			System.out.println("更新后的所有用户：");
			for (User u : userList) {
				System.out.println(u.toString());
			} 
		} catch (Exception e) {
			System.out.println("对不起，无此用户，请重新输入：");
		}
		return i;
		
	}

	public ArrayList<User> reviseUser(ArrayList<User> userList, int idOrAccount2) {
		Scanner sc3 = new Scanner(System.in);
		try {
			for (int i = 0; i < userList.size(); i++) {
				User ui = userList.get(i);
				if (ui.getId() == idOrAccount2 || ui.getAccount() == idOrAccount2) {
					System.out.println("您将要修改以下用户信息：");
					System.out.println(ui.toString());
					System.out.println("请重新设置昵称：");
					ui.setNickname((sc3.next()));
					System.out.println("请重新设置密码：");
					ui.setPwd(sc3.next());
					System.out.println("请重新设置性别：");
					ui.setGendar(sc3.nextInt());
				}
			}
			System.out.println("修改用户信息成功!");
			System.out.println("更新后的所有用户：");
			for (User u : userList) {
				System.out.println(u.toString());
			} 
		} catch (Exception e) {
			System.out.println("对不起，无此用户，请重新输入：");
		}
		return userList;
		
	}
	
}