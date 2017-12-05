package com.wangwang.springmvcfirst.domain;

public class Tb_User {
	private Integer userId;
	private String userName;
	private String password;
	private String email;
	private String description;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Tb_User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", email=" + email
				+ ", description=" + description + "]";
	}

}
