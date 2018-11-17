package com.appinterface.app.base.core.entity.request;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @ClassName: UnipayBaseRequest
 * @Description: 接口基本参数列表
 * @author xuzhenyao
 * @date 2015年1月8日 下午4:33:07
 */
public class UnipayBaseRequest<BODY> {
	/**
	 * 报文头
	 */
	private Requesthead requesthead;
	
	private String requestJson;
	
	/**
	 * 通用泛型
	 */
	private BODY requestbody;
	
	

	public BODY getRequestbody() {
		return requestbody;
	}

	public void setRequestbody(BODY requestbody) {
		this.requestbody = requestbody;
	}

	public String getRequestJson() {
		return requestJson;
	}

	public void setRequestJson(String requestJson) {
		this.requestJson = requestJson;
	}

	public Requesthead getRequesthead() {
		return requesthead;
	}

	public void setRequesthead(Requesthead requesthead) {
		this.requesthead = requesthead;
	}

	/**
	 * @param <T>
	 * @Title: getInstent
	 * @Description: 解析request内容
	 * @param @param request 请求
	 * @param @param body 请求体
	 * @param @return
	 * @return UnipayBaseRequest
	 * @throws
	 */
	public static <T> T getInstent(HttpServletRequest request, Class T) {
		Gson gson = new GsonBuilder().disableHtmlEscaping().create();
//		UnipayBaseRequest base = new UnipayBaseRequest();
		String value = (String) request.getAttribute("value");
		// base.setRequesthead(gson.fromJson(value, Requesthead.class));
		// base.setRequestsecurity(gson.fromJson(value, Requestsecurity.class));
//		T t = (T) gson.fromJson(value, T);
		return (T) JSON.parseObject(value, T);
	}
	
	/**
	 * @param <T>
	 * @Title: getInstent
	 * @Description: 解析request内容
	 * @param @param request 请求
	 * @param @param body 请求体
	 * @param @return
	 * @return UnipayBaseRequest
	 * @throws
	 */
	public static <T> T getInstent(String json, Class T) {
		Gson gson = new GsonBuilder().disableHtmlEscaping().create();
		T t = (T) gson.fromJson(json, T);
		return t;
	}
}
