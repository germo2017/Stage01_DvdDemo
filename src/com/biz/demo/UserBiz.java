package com.biz.demo;

public interface UserBiz {
	/**
	 * 声明用户要执行的所有行为
	 * 根据账户和密码进项登录
	 * @param userAccount
	 * @param userPwd
	 * @return 登录成功返回true,否则返回false
	 * 
	 */
	public boolean userlogin(String userAccount, String userPwd);
	public boolean check(String inputAccount, String inputPwd, String inputPwdTips);
	
}
