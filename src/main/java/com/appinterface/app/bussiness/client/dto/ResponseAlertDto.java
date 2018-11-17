package com.appinterface.app.bussiness.client.dto;

import java.util.List;

import com.appinterface.app.base.core.entity.response.Responsebody;

public class ResponseAlertDto extends Responsebody{
	private List<AlertBodyModule> alterBodys;

	public List<AlertBodyModule> getAlterBodys() {
		return alterBodys;
	}

	public void setAlterBodys(List<AlertBodyModule> alterBodys) {
		this.alterBodys = alterBodys;
	}
}
