package com.view.demo;

import java.text.ParseException;
import java.util.Scanner;
import com.bizImpl.demo.DvdBizImpl;

public class DvdView extends View {

	@Override
	public View showView() {
		System.out.println("=====================");
		System.out.println("   ��ӭ�����뱾ϵͳ");
		System.out.println("=====================");
		System.out.println("1.��ʾ�ɽ�DVD���ѽ��DVD:");
		System.out.println("2.����DVD:");
		System.out.println("3.����DVD:");
		System.out.println("4.�黹DVD:");
		System.out.println("5.��ʾDVD�ȶ�:");
		System.out.println("0.�˳�!");
		System.out.println("������ѡ��:");
		Scanner scan2 = new Scanner(System.in);
		boolean isContinue = true;
		int choose = 0;
		while (isContinue) {
			
			choose= scan2.nextInt();//int choose = scan2.nextInt()
			switch (choose) {
			case 0:
				System.out.println("ллʹ��,�ټ�!");
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
			System.out.println("�Ƿ������Y/N ?");
			String yOrn = scan2.next();//Exception in thread "main" �Ƿ������Y/N ?---java.util.NoSuchElementException		
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
