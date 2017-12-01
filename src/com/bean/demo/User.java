package com.bean.demo;
/**
 * 
 * @ClassName:	 User.java
 * @Package:	 com.bean.demo
 * @Description: User父类
 *
 * @author	Administrator
 * @date	2017年11月16日下午7:37:03
 * @version	1.0
 */
public class User {
	private int userId;	
	private String userAccount;	
	private String userNickname;
	private String userPwd;
	private String userPwdTip;
	private int userPermission;//用户权限
	private boolean userStatus;
	
	
	public int getUserPermission() {
		return userPermission;
	}
	public void setUserPermission(int userPermission) {
		this.userPermission = userPermission;
	}	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}
	public String getUserNickname() {
		return userNickname;
	}
	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getUserPwdTip() {
		return userPwdTip;
	}
	public void setUserPwdTip(String userPwdTip) {
		this.userPwdTip = userPwdTip;
	}
	public boolean isUserStatus() {
		return userStatus;
	}
	public void setUserStatus(boolean userStatus) {
		this.userStatus = userStatus;
	}
	
	public User(int userId, String userAccount, String userNickname, String userPwd, String userPwdTip,int userPermission,
			boolean userStatus) {
		super();
		this.userId = userId;
		this.userAccount = userAccount;
		this.userNickname = userNickname;
		this.userPwd = userPwd;
		this.userPwdTip = userPwdTip;
		this.userPermission =userPermission;
		this.userStatus = userStatus;
	}
	
	public User(String userAccount, String userNickname, String userPwd, String userPwdTip,int userPermission, boolean userStatus) {
		super();
		this.userAccount = userAccount;
		this.userNickname = userNickname;
		this.userPwd = userPwd;
		this.userPwdTip = userPwdTip;
		this.userPermission =userPermission;
		this.userStatus = userStatus;
	}
	public User() {
		super();
	}
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userAccount=" + userAccount + ", userNickname=" + userNickname
				+ ", userPwd=" + userPwd + ", userPwdTip=" + userPwdTip + ", userPermission=" + userPermission
				+ ", userStatus=" + userStatus + "]";
	}
	
	
	
	
	
	
	
}