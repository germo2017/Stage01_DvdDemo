package com.test.demo;

import com.view.demo.MainView;
import com.view.demo.View;

public class Test {
	/*
	 * ҳ��(View) ���� ҵ��(Biz)
	 * 
	 * ҵ��(Biz) ���� ���ݲ�����(Dao)
	 * 
	 * ���ݲ�����(Dao) ����ʵ���� Bean
	 */
	public static void main(String[] args) {
		
		View mv = new MainView();
		mv.showView();
	}

}
