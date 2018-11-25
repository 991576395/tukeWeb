package com.xuzy.hotel.shippingbatch.entity;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

/**
 * 描述：批量发货表
 * @author: www.jeecg.org
 * @since：2018年11月20日 20时41分17秒 星期二 
 * @version:1.0
 */
public class CvcShippingBatchEntity implements Serializable{
	private static final long serialVersionUID = 1L;
		/**	 *id	 */	private Integer id;	/**	 *上传批次号	 */	private String batchNo;	/**	 *发货总量	 */	private Integer shippingCount;	/**	 *发货成功数	 */	private Integer shippingCountOk;	/**	 *上传时间	 */	private Integer addTime;
	/**
	 * 上传时间格式化
	 */
	private String addTimeFormat;	/**	 *订单批次号（抓单批次号）	 */	private String orderBatchNo;	/**	 *是否存在非本订单批次号的订单（0:否；1:是）	 */	private Integer msgStatus;
	
	/**
	 * 展示字符
	 */
	private String msgStatusStr;
	/**
	 * 上传失败数量
	 */
	private int shippingCountNot;
	
	
	
	public String getMsgStatusStr() {
		return msgStatusStr;
	}
	public void setMsgStatusStr(String msgStatusStr) {
		this.msgStatusStr = msgStatusStr;
	}
	public int getShippingCountNot() {
		return shippingCountNot;
	}
	public void setShippingCountNot(int shippingCountNot) {
		this.shippingCountNot = shippingCountNot;
	}
	public String getAddTimeFormat() {
		return addTimeFormat;
	}
	public void setAddTimeFormat(String addTimeFormat) {
		this.addTimeFormat = addTimeFormat;
	}
	public Integer getId() {	    return this.id;	}	public void setId(Integer id) {	    this.id=id;	}	public String getBatchNo() {	    return this.batchNo;	}	public void setBatchNo(String batchNo) {	    this.batchNo=batchNo;	}	public Integer getShippingCount() {	    return this.shippingCount;	}	public void setShippingCount(Integer shippingCount) {	    this.shippingCount=shippingCount;	}	public Integer getShippingCountOk() {	    return this.shippingCountOk;	}	public void setShippingCountOk(Integer shippingCountOk) {	    this.shippingCountOk=shippingCountOk;	}	public Integer getAddTime() {	    return this.addTime;	}	public void setAddTime(Integer addTime) {	    this.addTime=addTime;	}	public String getOrderBatchNo() {	    return this.orderBatchNo;	}	public void setOrderBatchNo(String orderBatchNo) {	    this.orderBatchNo=orderBatchNo;	}	public Integer getMsgStatus() {	    return this.msgStatus;	}	public void setMsgStatus(Integer msgStatus) {	    this.msgStatus=msgStatus;	}
}

