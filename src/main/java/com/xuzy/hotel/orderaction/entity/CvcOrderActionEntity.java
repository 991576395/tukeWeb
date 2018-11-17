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
		/**	 *action_id	 */	private Integer actionId;	/**	 *order_id	 */	private Integer orderId;	/**	 *action_user	 */	private String actionUser;	/**	 *order_status	 */	private Integer orderStatus;
	/**
	 * 转义后orderStatus
	 */
	private String orderStatusString;	/**	 *shipping_status	 */	private Integer shippingStatus;
	
	private String shippingStatusString;	/**	 *pay_status	 */	private Integer payStatus;
	/**
	 * 转移payStatus
	 */
	private String payStatusString;
		/**	 *action_place	 */	private Integer actionPlace;	/**	 *action_note	 */	private String actionNote;	/**	 *log_time	 */	private Integer logTime;
	
	/**
	 * 操作时间格式化后
	 */
	private String actionTime;
	
	
		public String getShippingStatusString() {
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
	public Integer getActionId() {	    return this.actionId;	}	public void setActionId(Integer actionId) {	    this.actionId=actionId;	}	public Integer getOrderId() {	    return this.orderId;	}	public void setOrderId(Integer orderId) {	    this.orderId=orderId;	}	public String getActionUser() {	    return this.actionUser;	}	public void setActionUser(String actionUser) {	    this.actionUser=actionUser;	}	public Integer getOrderStatus() {	    return this.orderStatus;	}	public void setOrderStatus(Integer orderStatus) {	    this.orderStatus=orderStatus;	}	public Integer getShippingStatus() {	    return this.shippingStatus;	}	public void setShippingStatus(Integer shippingStatus) {	    this.shippingStatus=shippingStatus;	}	public Integer getPayStatus() {	    return this.payStatus;	}	public void setPayStatus(Integer payStatus) {	    this.payStatus=payStatus;	}	public Integer getActionPlace() {	    return this.actionPlace;	}	public void setActionPlace(Integer actionPlace) {	    this.actionPlace=actionPlace;	}	public String getActionNote() {	    return this.actionNote;	}	public void setActionNote(String actionNote) {	    this.actionNote=actionNote;	}	public Integer getLogTime() {	    return this.logTime;	}	public void setLogTime(Integer logTime) {	    this.logTime=logTime;	}
}

