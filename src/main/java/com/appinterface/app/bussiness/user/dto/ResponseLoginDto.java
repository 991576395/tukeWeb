package com.appinterface.app.bussiness.user.dto;

import com.appinterface.app.base.core.entity.response.Responsebody;

public class ResponseLoginDto extends Responsebody{
	/**
	 * 公司名称
	 */
	private String companyName;
	/**
	 * 正式姓名
	 */
	private String realName;
	/**
	 * 用户名
	 */
	private String userName;
	
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
}
