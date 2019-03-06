package com.xuzy.hotel.deliveryinfo.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;

import java.math.BigDecimal;

/**
 * 描述：物流表
 * @author: www.jeecg.org
 * @since：2018年11月20日 20时42分45秒 星期二 
 * @version:1.0
 */
public class CvcDeliveryInfoEntity implements Serializable{
	private static final long serialVersionUID = 1L;
		/**	 *id	 */	private Integer id;	/**	 *快递单号	 */	private String number;	/**	 *快递信息	 */	private String message;	/**	 *快递详情	 */	private String data;	/**	 *快递状态（0：在途；1：揽件；2：疑难；3：签收；4：退签；5：派件；6：退回）	 */	private Integer state;
	
	/**创建日期*/
	private String createDate;
	
		public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public Integer getId() {	    return this.id;	}	public void setId(Integer id) {	    this.id=id;	}	public String getNumber() {	    return this.number;	}	public void setNumber(String number) {	    this.number=number;	}	public String getMessage() {	    return this.message;	}	public void setMessage(String message) {	    this.message=message;	}	public String getData() {	    return this.data;	}	public void setData(String data) {	    this.data=data;	}	public Integer getState() {	    return this.state;	}	public void setState(Integer state) {	    this.state=state;	}
}

