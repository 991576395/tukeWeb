package com.xuzy.hotel.checkingaccountorder.entity;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

/**
 * 描述：对账订单表
 * @author: www.jeecg.org
 * @since：2018年11月15日 21时28分02秒 星期四 
 * @version:1.0
 */
public class CvcCheckingAccountOrderEntity implements Serializable{
	private static final long serialVersionUID = 1L;
		/**	 *id	 */	private Integer id;	/**	 *对账表头id	 */	private Integer checkingAccountId;	/**	 *订单id	 */	private Integer orderId;	/**	 *快递公司	 */	private String shippingName;	/**	 *是否上传对账明细	 */	private Integer isAddCheckingAccount;	/**	 *上传时间	 */	private Integer addCheckingAccountTime;	/**	 *快递单号	 */	private String invoiceNo;	/**	 *商品编号	 */	private String goodsSn;	/**	 *商品数量	 */	private Integer goodsNumber;	/**	 *收货地址	 */	private String address;	/**	 *收货人	 */	private String consignee;	/**	 *手机号	 */	private String mobile;	/**	 *签收时间	 */	private String signinDate;	public Integer getId() {	    return this.id;	}	public void setId(Integer id) {	    this.id=id;	}	public Integer getCheckingAccountId() {	    return this.checkingAccountId;	}	public void setCheckingAccountId(Integer checkingAccountId) {	    this.checkingAccountId=checkingAccountId;	}	public Integer getOrderId() {	    return this.orderId;	}	public void setOrderId(Integer orderId) {	    this.orderId=orderId;	}	public String getShippingName() {	    return this.shippingName;	}	public void setShippingName(String shippingName) {	    this.shippingName=shippingName;	}	public Integer getIsAddCheckingAccount() {	    return this.isAddCheckingAccount;	}	public void setIsAddCheckingAccount(Integer isAddCheckingAccount) {	    this.isAddCheckingAccount=isAddCheckingAccount;	}	public Integer getAddCheckingAccountTime() {	    return this.addCheckingAccountTime;	}	public void setAddCheckingAccountTime(Integer addCheckingAccountTime) {	    this.addCheckingAccountTime=addCheckingAccountTime;	}	public String getInvoiceNo() {	    return this.invoiceNo;	}	public void setInvoiceNo(String invoiceNo) {	    this.invoiceNo=invoiceNo;	}	public String getGoodsSn() {	    return this.goodsSn;	}	public void setGoodsSn(String goodsSn) {	    this.goodsSn=goodsSn;	}	public Integer getGoodsNumber() {	    return this.goodsNumber;	}	public void setGoodsNumber(Integer goodsNumber) {	    this.goodsNumber=goodsNumber;	}	public String getAddress() {	    return this.address;	}	public void setAddress(String address) {	    this.address=address;	}	public String getConsignee() {	    return this.consignee;	}	public void setConsignee(String consignee) {	    this.consignee=consignee;	}	public String getMobile() {	    return this.mobile;	}	public void setMobile(String mobile) {	    this.mobile=mobile;	}	public String getSigninDate() {	    return this.signinDate;	}	public void setSigninDate(String signinDate) {	    this.signinDate=signinDate;	}
}

