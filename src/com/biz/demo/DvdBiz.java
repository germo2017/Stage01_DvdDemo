package com.biz.demo;
/**
 * 
 * @ClassName:	 DvdBiz.java
 * @Package:	 com.biz.demo
 * @Description: Dvd��ҵ��ӿ�,����Ҫִ�еķ���
 *
 * @author	Administrator
 * @date	2017��11��30������7:18:16
 * @version	1.0
 */
public interface DvdBiz {
	//��ɾ�Ĳ�
	public void showDvd();//��ʾ�ɽ�DVD���ѽ��DVD
	public void addDvd();	//----����ԱȨ��
	public void searchDvd();	
	public void deleteDvd();//----����ԱȨ��
	public void reviseDvd();//---����ԱȨ��,�޸�Dvd��Ϣ
	public void lendDvd();
	public void returnDvd();
	public void showHotDvd();//��ʾ�ȶ�����
}
