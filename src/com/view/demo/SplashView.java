package com.view.demo;

/**
 * 
 * @ClassName: SplashView.java
 * @Package: com.view.demo
 * @Description: TODO
 *
 * @author Administrator
 * @date 2017��11��16������8:39:07
 * @version 1.0
 */
public class SplashView extends View {

	public void showWelcome() {
		for (int i = 0; i < 100; i++) {
			System.out.print("*");
			if (i == 49) {
				System.out.println("\n");
				System.out.println("\t\t��ӭ����DVD����ϵͳ");
				System.out.println("\n");
			}
		}
	}

	@Override
	public View showView() {
		showWelcome();
		System.out.println();
//		showSplashMenu();
		return null;
	}

}
