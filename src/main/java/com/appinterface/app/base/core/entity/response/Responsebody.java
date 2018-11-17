package com.appinterface.app.base.core.entity.response;

import com.appinterface.app.base.core.entity.base.UnipayBaseDto;

/**
 * @ClassName: Responsebody 
 * @Description:所有响应体的基类
 * @author xuzhenyao
 * @date 2015年1月8日 下午6:27:55 
 *
 */
public class Responsebody extends UnipayBaseDto{
	private Long sid;
	
	
	public Responsebody() {
		super();
	}
	
	public Long getSid() {
		return sid;
	}

	public void setSid(Long sid) {
		this.sid = sid;
	}

	public Responsebody(String result) {
		super();
//		this.result = result;
	}

//	/**
//	 * 响应码
//	 */
//	protected String result;
//	
//	public String getResult() {
//		return result;
//	}


//	public void setResult(String result) {
//		this.result = result;
//	}
	
	
}
