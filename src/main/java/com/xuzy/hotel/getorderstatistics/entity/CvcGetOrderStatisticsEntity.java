package com.xuzy.hotel.getorderstatistics.entity;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

/**
 * 描述：抓单表
 * @author: www.jeecg.org
 * @since：2018年11月10日 17时34分59秒 星期六 
 * @version:1.0
 */
public class CvcGetOrderStatisticsEntity implements Serializable{
	private static final long serialVersionUID = 1L;
		/**	 *id	 */	private Integer id;	/**	 *抓单统一批次号	 */	private String unifiedBatchNo;	/**	 *抓单批次号	 */	private String batchNo;	/**	 *抓单时间	 */	private Integer addTime;
	/**
	 * 格式化时间
	 */
	private String addTimeFormat;	/**	 *订单数量	 */	private Integer waitDeliveryCount;	/**	 *订单数量	 */	private Integer deliveryCount;	/**	 *订单数量	 */	private Integer offharbourCount;	/**	 *订单数量	 */	private Integer sendCount;	/**	 *订单数量	 */	private Integer signinCount;	/**	 *异常订单数量	 */	private Integer exceptionCount;
		
	/**
	 * 处理过订单数量
	 */
	private Integer exceptionDoCount;	/**	 *订单数量	 */	private Integer signinFailCount;	/**	 *订单数量	 */	private Integer backCount;	/**	 *订单数量	 */	private Integer orderCount;
	
	
		public Integer getExceptionDoCount() {
		return exceptionDoCount;
	}
	public void setExceptionDoCount(Integer exceptionDoCount) {
		this.exceptionDoCount = exceptionDoCount;
	}
	public String getAddTimeFormat() {
		return addTimeFormat;
	}
	public void setAddTimeFormat(String addTimeFormat) {
		this.addTimeFormat = addTimeFormat;
	}
	public Integer getId() {	    return this.id;	}	public void setId(Integer id) {	    this.id=id;	}	public String getUnifiedBatchNo() {	    return this.unifiedBatchNo;	}	public void setUnifiedBatchNo(String unifiedBatchNo) {	    this.unifiedBatchNo=unifiedBatchNo;	}	public String getBatchNo() {	    return this.batchNo;	}	public void setBatchNo(String batchNo) {	    this.batchNo=batchNo;	}	public Integer getAddTime() {	    return this.addTime;	}	public void setAddTime(Integer addTime) {	    this.addTime=addTime;	}	public Integer getWaitDeliveryCount() {	    return this.waitDeliveryCount;	}	public void setWaitDeliveryCount(Integer waitDeliveryCount) {	    this.waitDeliveryCount=waitDeliveryCount;	}	public Integer getDeliveryCount() {	    return this.deliveryCount;	}	public void setDeliveryCount(Integer deliveryCount) {	    this.deliveryCount=deliveryCount;	}	public Integer getOffharbourCount() {	    return this.offharbourCount;	}	public void setOffharbourCount(Integer offharbourCount) {	    this.offharbourCount=offharbourCount;	}	public Integer getSendCount() {	    return this.sendCount;	}	public void setSendCount(Integer sendCount) {	    this.sendCount=sendCount;	}	public Integer getSigninCount() {	    return this.signinCount;	}	public void setSigninCount(Integer signinCount) {	    this.signinCount=signinCount;	}	public Integer getExceptionCount() {	    return this.exceptionCount;	}	public void setExceptionCount(Integer exceptionCount) {	    this.exceptionCount=exceptionCount;	}	public Integer getSigninFailCount() {	    return this.signinFailCount;	}	public void setSigninFailCount(Integer signinFailCount) {	    this.signinFailCount=signinFailCount;	}	public Integer getBackCount() {	    return this.backCount;	}	public void setBackCount(Integer backCount) {	    this.backCount=backCount;	}	public Integer getOrderCount() {	    return this.orderCount;	}	public void setOrderCount(Integer orderCount) {	    this.orderCount=orderCount;	}
}

