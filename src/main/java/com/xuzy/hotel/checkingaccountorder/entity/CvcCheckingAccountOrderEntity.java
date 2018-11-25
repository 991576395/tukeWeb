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
	
	
	/**
	 * 格式化时间
	 */
	private String addCheckingAccountTimeFormat;
	
	
	/**
	 * 展示状态
	 */
	private String statueName;
	
	public String getAddCheckingAccountTimeFormat() {
		return addCheckingAccountTimeFormat;
	}
	public void setAddCheckingAccountTimeFormat(String addCheckingAccountTimeFormat) {
		this.addCheckingAccountTimeFormat = addCheckingAccountTimeFormat;
	}
	public String getStatueName() {
		return statueName;
	}
	public void setStatueName(String statueName) {
		this.statueName = statueName;
	}
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

	public Integer getIsAddCheckingAccount() {
		return isAddCheckingAccount;
	}
	public void setIsAddCheckingAccount(Integer isAddCheckingAccount) {
		this.isAddCheckingAccount = isAddCheckingAccount;
	}
	
	public long getAddCheckingAccountTime() {
		return addCheckingAccountTime;
	}
	public void setAddCheckingAccountTime(long addCheckingAccountTime) {
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
