package com.xuzy.hotel.yldeliveryinfo.entity;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

/**
 * 描述：伊利物流表
 * @author: www.jeecg.org
 * @since：2018年11月20日 22时03分58秒 星期二 
 * @version:1.0
 */
public class CvcYlDeliveryInfoEntity implements Serializable{
	private static final long serialVersionUID = 1L;
		/**	 *log_id	 */	private Integer logId;	/**	 *订单号	 */	private Integer orderId;	/**	 *快递单号	 */	private String number;	/**	 *物流信息描述	 */	private String context;	/**	 *处理时间	 */	private String ftime;
	
		public CvcYlDeliveryInfoEntity() {
		super();
	}
	
	public CvcYlDeliveryInfoEntity(Integer orderId, String number, String ftime) {
		super();
		this.orderId = orderId;
		this.number = number;
		this.ftime = ftime;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ftime == null) ? 0 : ftime.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CvcYlDeliveryInfoEntity other = (CvcYlDeliveryInfoEntity) obj;
		if (ftime == null) {
			if (other.ftime != null)
				return false;
		} else if (!ftime.equals(other.ftime))
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		return true;
	}
	public Integer getLogId() {	    return this.logId;	}	public void setLogId(Integer logId) {	    this.logId=logId;	}	public Integer getOrderId() {	    return this.orderId;	}	public void setOrderId(Integer orderId) {	    this.orderId=orderId;	}	public String getNumber() {	    return this.number;	}	public void setNumber(String number) {	    this.number=number;	}	public String getContext() {	    return this.context;	}	public void setContext(String context) {	    this.context=context;	}	public String getFtime() {	    return this.ftime;	}	public void setFtime(String ftime) {	    this.ftime=ftime;	}
}

