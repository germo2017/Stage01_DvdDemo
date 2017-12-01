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
		System.out.println("-----�����û�-----");
		ut.showAllUser(userList);

		System.out.println("-----׼������û�-----");
		while (true) {			
			try {				
				userList.add(ut.addUser(userList, ut.creatUserAccount(userList)));
				System.out.println("�ɹ�����û�!");

				System.out.println("�Ƿ����������û�:Y/N?");
				String isGo = sc.next();
				if ("n".equalsIgnoreCase(isGo)) {
					System.out.println("���º�������û���");
					ut.showAllUser(userList);
					break;
				} else {
					continue;
				}
			} catch (Exception e) {
				System.out.println("-----����û�ʧ��!-------");
				System.out.println(e.getMessage());
			}//try����
		}//while����	
		
		System.out.println("------------------");
		for (User u : userList) {
			System.out.println(u.toString());
		} 
		
		System.out.println("-----׼���޸��û���Ϣ-----");
		System.out.println("��������Ҫ�޸ĵ��û�ID���˺�");		
		userList = ut.reviseUser(userList, sc.nextInt());
		
		System.out.println("-----׼��ɾ���û�-----");
		System.out.println("��������Ҫɾ�����û�ID���˺�");				
		userList.remove(ut.delectUser(userList, sc.nextInt()));
		
		
		
		sc.close();

	}

}
