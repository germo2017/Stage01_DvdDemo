package com.biz.demo;
/**
 * 
 * @ClassName:	 DvdBiz.java
 * @Package:	 com.biz.demo
 * @Description: Dvd的业务接口,声明要执行的方法
 *
 * @author	Administrator
 * @date	2017年11月30日下午7:18:16
 * @version	1.0
 */
public interface DvdBiz {
	//增删改查
	public void addDvd();	
	public void searchDvd();	
	public void deleteDvd();
	public void reviseDvd();//修改Dvd信息
	public void lendDvd();
	public void returnDvd();
	public void showDvd();//显示热度排行
}
