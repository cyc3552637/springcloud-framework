package com.digital.entity;

public class UserEntity {
	public String userid;
	public String user;
	public String password;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "userTest [userid=" + userid + ", user=" + user + ", password=" + password + "]";
	}
	
	
}
