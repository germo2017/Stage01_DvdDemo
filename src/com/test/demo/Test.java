package com.test.demo;

import com.view.demo.MainView;
import com.view.demo.View;

public class Test {
	/*
	 * 页面(View) 调用 业务(Biz)
	 * 
	 * 业务(Biz) 调用 数据操作类(Dao)
	 * 
	 * 数据操作类(Dao) 调用实体类 Bean
	 */
	public static void main(String[] args) {
		
		View mv = new MainView();
		mv.showView();
	}

}
