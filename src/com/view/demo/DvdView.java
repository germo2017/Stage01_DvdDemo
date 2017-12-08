package com.view.demo;

import java.text.ParseException;
import java.util.Scanner;
import com.bizImpl.demo.DvdBizImpl;

public class DvdView extends View {

	@Override
	public View showView() {
		System.out.println("=====================");
		System.out.println("   欢迎您进入本系统");
		System.out.println("=====================");
		System.out.println("1.显示可借DVD和已借出DVD:");
		System.out.println("2.搜索DVD:");
		System.out.println("3.借阅DVD:");
		System.out.println("4.归还DVD:");
		System.out.println("5.显示DVD热度:");
		System.out.println("0.退出!");
		System.out.println("请输入选项:");
		Scanner scan2 = new Scanner(System.in);
		boolean isContinue = true;
		int choose = 0;
		while (isContinue) {
			
			choose= scan2.nextInt();//int choose = scan2.nextInt()
			switch (choose) {
			case 0:
				System.out.println("谢谢使用,再见!");
				break;
			case 1:
				try {
					DvdBizImpl.newInstance().showDvd();

				} catch (ParseException e) {
					e.printStackTrace();
				}
				break;
			case 2:
				try {
					DvdBizImpl.newInstance().searchDvd();
				} catch (ParseException e) {
					e.printStackTrace();
				}
				break;
			case 3:
				try {
					DvdBizImpl.newInstance().lendDvd();
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				break;
			case 4:
				try {
					DvdBizImpl.newInstance().returnDvd();
				} catch (ParseException e) {
					e.printStackTrace();
				}
				break;
			case 5:
				try {
					DvdBizImpl.newInstance().showHotDvd();
				} catch (ParseException e) {
					e.printStackTrace();
				}
				break;
			default:
				break;
			}
			System.out.println("是否继续，Y/N ?");
			String yOrn = scan2.next();//Exception in thread "main" 是否继续，Y/N ?---java.util.NoSuchElementException		
			if ("Y".equalsIgnoreCase(yOrn)) {
				continue;
			} else {
				isContinue = false;
				scan2.close();
			}
		//	scan2.close();	Exception in thread "main" java.util.NoSuchElementException//at java.util.Scanner.throwFor(Unknown Source)		
		}
			
		return null;
	}

}
