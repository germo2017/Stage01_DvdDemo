package com.biz.demo;

public interface UserBiz {
	/**
	 * �����û�Ҫִ�е�������Ϊ
	 * �����˻�����������¼
	 * @param userAccount
	 * @param userPwd
	 * @return ��¼�ɹ�����true,���򷵻�false
	 * 
	 */
	public boolean userlogin(String userAccount, String userPwd);
	public boolean check(String inputAccount, String inputPwd, String inputPwdTips);
	
}
