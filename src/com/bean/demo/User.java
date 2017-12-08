package com.bean.demo;

import java.io.Serializable;

/**
 * 
 * @ClassName: User.java
 * @Package: com.bean.demo
 * @Description: User父类
 *
 * @author Administrator
 * @date 2017年11月16日下午7:37:03
 * @version 1.0
 */
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1904979311752865745L;
	private int userId;
	private String userAccount;
	private String userNickName;
	private String userPwd;
	private String userPwdTips;
	private int userPermission;// 用户权限
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

	public String getUserNickName() {
		return userNickName;
	}

	public void setUserNickName(String userNickname) {
		this.userNickName = userNickname;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserPwdTips() {
		return userPwdTips;
	}

	public void setUserPwdTips(String userPwdTips) {
		this.userPwdTips = userPwdTips;
	}

	public boolean isUserStatus() {
		return userStatus;
	}

	public void setUserStatus(boolean userStatus) {
		this.userStatus = userStatus;
	}

	public User(int userId, String userAccount, String userNickname, String userPwd, String userPwdTips,
			int userPermission, boolean userStatus) {
		super();
		this.userId = userId;
		this.userAccount = userAccount;
		this.userNickName = userNickname;
		this.userPwd = userPwd;
		this.userPwdTips = userPwdTips;
		this.userPermission = userPermission;
		this.userStatus = userStatus;
	}

	public User(String userAccount, String userNickname, String userPwd, String userPwdTip, int userPermission,
			boolean userStatus) {
		super();
		this.userAccount = userAccount;
		this.userNickName = userNickname;
		this.userPwd = userPwd;
		this.userPwdTips = userPwdTip;
		this.userPermission = userPermission;
		this.userStatus = userStatus;
	}

	public User() {
		super();
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userAccount=" + userAccount + ", userNickname=" + userNickName
				+ ", userPwd=" + userPwd + ", userPwdTip=" + userPwdTips + ", userPermission=" + userPermission
				+ ", userStatus=" + userStatus + "]";
	}

}