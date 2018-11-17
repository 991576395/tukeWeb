package com.appinterface.app.base.core.entity.response;

/**
 * @ClassName: Responsesecurity 
 * @Description: 所有签名数据
 * @author xuzhenyao
 * @date 2015年1月8日 下午6:28:34 
 *
 */
public class Responsesecurity {
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
