package com.appinterface.app.base.core.entity.response;

import com.appinterface.app.base.core.entity.base.UnipayBaseDto;

/**
 * 返回内容
 * @author uatyuanzy
 *
 */
public class Response {
	private Responsehead responsehead;
	private UnipayBaseDto responsebody;
	public Responsehead getResponsehead() {
		return responsehead;
	}
	public void setResponsehead(Responsehead responsehead) {
		this.responsehead = responsehead;
	}
	public UnipayBaseDto getResponsebody() {
		return responsebody;
	}
	public void setResponsebody(UnipayBaseDto responsebody) {
		this.responsebody = responsebody;
	}
	
}
