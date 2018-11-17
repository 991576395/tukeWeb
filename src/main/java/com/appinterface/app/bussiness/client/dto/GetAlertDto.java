package com.appinterface.app.bussiness.client.dto;

import com.appinterface.app.base.core.entity.request.Requestbody;

public class GetAlertDto extends Requestbody{
	/**
	 * yyyyMM 格式
	 */
	private String date;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
}
