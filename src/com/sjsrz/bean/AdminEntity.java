package com.sjsrz.bean;
/*
 * 存储管理员相关信息
 */
public class AdminEntity {
	int admin_id;
	String admin_name;
	String admin_login_pwd;
	String admin_email;
	public int getAmdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(int amdmin_id) {
		this.admin_id = amdmin_id;
	}
	public String getAdmin_name() {
		return admin_name;
	}
	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}
	public String getAdmin_login_pwd() {
		return admin_login_pwd;
	}
	public void setAdmin_login_pwd(String admin_login_pwd) {
		this.admin_login_pwd = admin_login_pwd;
	}
	public String getAdmin_email() {
		return admin_email;
	}
	public void setAdmin_email(String admin_email) {
		this.admin_email = admin_email;
	}
}
