package com.virtusa.denorm.entity;

public class LoginDetail {
	private String userName;
	private String password;

	@Override
	public String toString() {
		return "LoginDetails [username=" + userName + ", password=" + password + "]";
	}

	public LoginDetail(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	public LoginDetail() {
		super();

	}

	public String getUserName() {
		return userName;
	}

	public void setUsername(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
