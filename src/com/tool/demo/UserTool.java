package com.tool.demo;
import com.bean.demo.User;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * 
 * @ClassName:	 User.java
 * @Package:	 com.bean.demo
 * @Description: User�ĸ��ַ�������
 *
 * @author	Administrator
 * @date	2017��11��17������7:17:03
 * @version	1.0
 */
public class UserTool {
	
	/**
	 * 
	 * @Description: User�鿴�����û��ķ���
	 */
	public void showAllUser(ArrayList<User> userList) {
		for (User u : userList) {
			System.out.println(u.toString());
		}
	}
	
	/**
	 * 
	 * @Description: �������û��ķ���
	 */
	public User addUser(ArrayList<User> userList, int account) {
		Scanner sc = new Scanner(System.in);
		System.out.println("�������ǳƣ�");
		String nickname = sc.next();
		System.out.println("����������");
		String pwd = sc.next();
		System.out.println("�������Ա�1��, 0 Ů ");
		int gendar = sc.nextInt();

		Iterator<User> it = userList.iterator();
		User ui = null;
		while (it.hasNext()) {
			ui = (User) it.next();
		}
		User ux = new User();
		ux.setId(ui.getId() + 1);// id��Ҫ�Զ�����
		// ux.setAccount((int)(Math.random()*100+1));//�˻������Զ����ɵģ��Ҳ��ظ�
		ux.setAccount(account);
		ux.setNickname(nickname);
		ux.setPwd(pwd);
		ux.setGendar(gendar);
		ux.setVipLevel(1);

		return ux;
	}
	
	/**
	 * 
	 * @Description: �Զ����ɲ��ظ����˻��ŵķ���
	 */
	public int creatUserAccount(ArrayList<User> userList) {
		int autoAccount = 0;
		while (true) {
			boolean isContinue = true;
			int temp = (int) (Math.random() * 1000 + 1);
			for (int i = 0; i < userList.size(); i++) {
				// �ж��Ƿ��ظ�
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
	 * @Description: ɾ���û��ķ���
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
			System.out.println("ɾ���ɹ�!");
			System.out.println("���º�������û���");
			for (User u : userList) {
				System.out.println(u.toString());
			} 
		} catch (Exception e) {
			System.out.println("�Բ����޴��û������������룺");
		}
		return i;
		
	}

	public ArrayList<User> reviseUser(ArrayList<User> userList, int idOrAccount2) {
		Scanner sc3 = new Scanner(System.in);
		try {
			for (int i = 0; i < userList.size(); i++) {
				User ui = userList.get(i);
				if (ui.getId() == idOrAccount2 || ui.getAccount() == idOrAccount2) {
					System.out.println("����Ҫ�޸������û���Ϣ��");
					System.out.println(ui.toString());
					System.out.println("�����������ǳƣ�");
					ui.setNickname((sc3.next()));
					System.out.println("�������������룺");
					ui.setPwd(sc3.next());
					System.out.println("�����������Ա�");
					ui.setGendar(sc3.nextInt());
				}
			}
			System.out.println("�޸��û���Ϣ�ɹ�!");
			System.out.println("���º�������û���");
			for (User u : userList) {
				System.out.println(u.toString());
			} 
		} catch (Exception e) {
			System.out.println("�Բ����޴��û������������룺");
		}
		return userList;
		
	}
	
}