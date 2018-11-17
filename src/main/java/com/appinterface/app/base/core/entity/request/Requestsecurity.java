package com.appinterface.app.base.core.entity.request;

/**
 * @ClassName: Reqsecurity 
 * @Description: 签名数据 
 * @author xuzhenyao
 * @date 2015年1月8日 下午4:42:32 
 */
public class Requestsecurity {
	private String data;
	
	private String random;
	
	

	public String getRandom() {
		return random;
	}

	public void setRandom(String random) {
		this.random = random;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
}
