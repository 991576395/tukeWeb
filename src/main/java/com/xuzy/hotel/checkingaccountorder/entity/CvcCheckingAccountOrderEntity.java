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
		/**	 *id	 */	private Integer id;	/**	 *对账表头id	 */	private int checkingAccountId;	/**	 *订单id	 */	private Integer orderId;	/**	 *快递公司	 */	private String shippingName;	/**	 *是否上传对账明细	 */	private int isAddCheckingAccount;	/**	 *上传时间	 */	private int addCheckingAccountTime;	/**	 *快递单号	 */	private String invoiceNo;	/**	 *商品编号	 */	private String goodsSn;	/**	 *商品数量	 */	private int goodsNumber;	/**	 *收货地址	 */	private String address;	/**	 *收货人	 */	private String consignee;	/**	 *手机号	 */	private String mobile;	/**	 *签收时间	 */	private String signinDate;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getCheckingAccountId() {
		return checkingAccountId;
	}
	public void setCheckingAccountId(int checkingAccountId) {
		this.checkingAccountId = checkingAccountId;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public String getShippingName() {
		return shippingName;
	}
	public void setShippingName(String shippingName) {
		this.shippingName = shippingName;
	}
	public int getIsAddCheckingAccount() {
		return isAddCheckingAccount;
	}
	public void setIsAddCheckingAccount(int isAddCheckingAccount) {
		this.isAddCheckingAccount = isAddCheckingAccount;
	}
	public int getAddCheckingAccountTime() {
		return addCheckingAccountTime;
	}
	public void setAddCheckingAccountTime(int addCheckingAccountTime) {
		this.addCheckingAccountTime = addCheckingAccountTime;
	}
	public String getInvoiceNo() {
		return invoiceNo;
	}
	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}
	public String getGoodsSn() {
		return goodsSn;
	}
	public void setGoodsSn(String goodsSn) {
		this.goodsSn = goodsSn;
	}
	public int getGoodsNumber() {
		return goodsNumber;
	}
	public void setGoodsNumber(int goodsNumber) {
		this.goodsNumber = goodsNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getConsignee() {
		return consignee;
	}
	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getSigninDate() {
		return signinDate;
	}
	public void setSigninDate(String signinDate) {
		this.signinDate = signinDate;
	}	
}

