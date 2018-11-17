package com.appinterface.app.bussiness.user.dto;

import com.appinterface.app.base.core.entity.request.Requestbody;

public class UserBody extends Requestbody{
	private String userName;// 用户名
	private String password;//用户密码
	
	/**
	 * 公司id
	 */
	private String companyId;
	
	
	private String realName;// 真实姓名

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
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

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

}
