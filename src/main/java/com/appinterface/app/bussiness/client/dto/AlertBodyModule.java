package com.appinterface.app.bussiness.client.dto;

public class AlertBodyModule {
	/**
	 * yyyyMMdd
	 */
	private String date;
	
	/**
	 * 事件类型
	 * 1.为客户生日
	 * 2.续单周期日期
	 */
	private String type;
		
	/**
	 * 内容
	 * *** 客户名 + 生日
	 *  ---客户需单周期日期
	 */
	private String content;
	
	
	
	public AlertBodyModule() {
		super();
	}

	public AlertBodyModule(String date, String content) {
		super();
		this.date = date;
		this.content = content;
	}
	
	

	public AlertBodyModule(String date, String type, String content) {
		super();
		this.date = date;
		this.type = type;
		this.content = content;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
