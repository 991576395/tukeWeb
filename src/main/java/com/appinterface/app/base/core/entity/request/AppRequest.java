package com.appinterface.app.base.core.entity.request;

public class AppRequest {
	/**
	 * 请求具体内容
	 */
	private UnipayBaseRequest request;
	
	/**
	 * 请求签名
	 */
	private Requestsecurity requestsecurity;

	public UnipayBaseRequest getRequest() {
		return request;
	}

	public void setRequest(UnipayBaseRequest request) {
		this.request = request;
	}

	public Requestsecurity getRequestsecurity() {
		return requestsecurity;
	}

	public void setRequestsecurity(Requestsecurity requestsecurity) {
		this.requestsecurity = requestsecurity;
	}
	
	
}
