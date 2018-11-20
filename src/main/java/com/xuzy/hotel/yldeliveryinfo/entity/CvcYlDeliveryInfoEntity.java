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
		/**	 *log_id	 */	private Integer logId;	/**	 *订单号	 */	private Integer orderId;	/**	 *快递单号	 */	private String number;	/**	 *物流信息描述	 */	private String context;	/**	 *处理时间	 */	private String ftime;	public Integer getLogId() {	    return this.logId;	}	public void setLogId(Integer logId) {	    this.logId=logId;	}	public Integer getOrderId() {	    return this.orderId;	}	public void setOrderId(Integer orderId) {	    this.orderId=orderId;	}	public String getNumber() {	    return this.number;	}	public void setNumber(String number) {	    this.number=number;	}	public String getContext() {	    return this.context;	}	public void setContext(String context) {	    this.context=context;	}	public String getFtime() {	    return this.ftime;	}	public void setFtime(String ftime) {	    this.ftime=ftime;	}
}

