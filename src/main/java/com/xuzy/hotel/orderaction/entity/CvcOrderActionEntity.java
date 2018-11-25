package com.xuzy.hotel.orderaction.entity;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

/**
 * 描述：操作表
 * @author: www.jeecg.org
 * @since：2018年11月03日 22时39分29秒 星期六 
 * @version:1.0
 */
public class CvcOrderActionEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/**
	 * 转义后orderStatus
	 */
	private String orderStatusString;
	
	private String shippingStatusString;
	/**
	 * 转移payStatus
	 */
	private String payStatusString;
	
	
	/**
	 * 操作时间格式化后
	 */
	private String actionTime;
	
	
	
		return shippingStatusString;
	}
	public void setShippingStatusString(String shippingStatusString) {
		this.shippingStatusString = shippingStatusString;
	}
	public String getPayStatusString() {
		return payStatusString;
	}
	public void setPayStatusString(String payStatusString) {
		this.payStatusString = payStatusString;
	}
	public String getOrderStatusString() {
		return orderStatusString;
	}
	public void setOrderStatusString(String orderStatusString) {
		this.orderStatusString = orderStatusString;
	}
	public String getActionTime() {
		return actionTime;
	}
	public void setActionTime(String actionTime) {
		this.actionTime = actionTime;
	}
	public Integer getActionId() {
}
