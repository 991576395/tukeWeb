package com.xuzy.hotel.checkingaccount.entity;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

/**
 * 描述：对账表
 * @author: www.jeecg.org
 * @since：2018年11月14日 19时44分59秒 星期三 
 * @version:1.0
 */
public class CvcCheckingAccountEntity implements Serializable{
	private static final long serialVersionUID = 1L;
		/**	 *id	 */	private Integer id;	/**	 *对账表头id	 */	private Integer checkingAccountId;	/**	 *对账明细主题	 */	private String topic;	/**	 *积分账号（1.金领冠账户；2.托菲尔账户）	 */	private Integer accountType;	/**	 *配货商id	 */	private Integer deliver;	/**	 *操作人id	 */	private Integer oppstaff;	/**	 *对账开始时间	 */	private String startTime;	/**	 *对账结束时间	 */	private String endTime;	/**	 *对账生成时间	 */	private Integer addTime;
	/**
	 * 对账生成时间格式化
	 */
	private String addTimeFormat;
		/**	 *是否已结算（0:否；1:是）	 */	private Integer isBalance;
	
		public String getAddTimeFormat() {
		return addTimeFormat;
	}
	public void setAddTimeFormat(String addTimeFormat) {
		this.addTimeFormat = addTimeFormat;
	}
	public Integer getId() {	    return this.id;	}	public void setId(Integer id) {	    this.id=id;	}	public Integer getCheckingAccountId() {	    return this.checkingAccountId;	}	public void setCheckingAccountId(Integer checkingAccountId) {	    this.checkingAccountId=checkingAccountId;	}	public String getTopic() {	    return this.topic;	}	public void setTopic(String topic) {	    this.topic=topic;	}	public Integer getAccountType() {	    return this.accountType;	}	public void setAccountType(Integer accountType) {	    this.accountType=accountType;	}	public Integer getDeliver() {	    return this.deliver;	}	public void setDeliver(Integer deliver) {	    this.deliver=deliver;	}	public Integer getOppstaff() {	    return this.oppstaff;	}	public void setOppstaff(Integer oppstaff) {	    this.oppstaff=oppstaff;	}	public String getStartTime() {	    return this.startTime;	}	public void setStartTime(String startTime) {	    this.startTime=startTime;	}	public String getEndTime() {	    return this.endTime;	}	public void setEndTime(String endTime) {	    this.endTime=endTime;	}	public Integer getAddTime() {	    return this.addTime;	}	public void setAddTime(Integer addTime) {	    this.addTime=addTime;	}	public Integer getIsBalance() {	    return this.isBalance;	}	public void setIsBalance(Integer isBalance) {	    this.isBalance=isBalance;	}
}

