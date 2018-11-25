package com.xuzy.hotel.checkingaccountorder.entity;

import java.io.Serializable;
import java.util.Date;

import org.jeecgframework.poi.excel.annotation.Excel;

import java.math.BigDecimal;

/**
 * 描述：对账订单表
 * @author: www.jeecg.org
 * @since：2018年11月15日 21时28分02秒 星期四 
 * @version:1.0
 */
public class CvcCheckingAccountOrderEntity implements Serializable{
	private static final long serialVersionUID = 1L;
		/**	 *id	 */	private Integer id;	/**	 *对账表头id	 */
	@Excel(name="对账表头ID",width=10)	private int checkingAccountId;	/**	 *订单id	 */
	@Excel(name="订单号",width=8)	private Integer orderId;	/**	 *快递公司	 */
	@Excel(name="快递公司",width=120)	private String shippingName;
	
	/**
	 *快递单号
	 */
	@Excel(name="快递单号",width=50)
	private String invoiceNo;
	
	/**
	 *收货地址
	 */
	@Excel(name="收货地址",width=255)
	private String address;
	
	/**
	 *收货人
	 */
	@Excel(name="收货人",width=20)
	private String consignee;
	/**
	 *手机号
	 */
	@Excel(name="联系电话",width=20)
	private String mobile;
	/**
	 *商品编号
	 */
	@Excel(name="礼品编号",width=30)
	private String goodsSn;
	/**
	 *商品数量
	 */
	@Excel(name="商品数量",width=8)
	private int goodsNumber;
	
	/**
	 *签收时间
	 */
	@Excel(name="签收时间",width=20)
	private String signinDate;

	/**
	 * 展示状态
	 */
	@Excel(name="上传状态",width=5)
	private String statueName;
	/**	 *是否上传对账明细	 */	private Integer isAddCheckingAccount;	/**	 *上传时间	 */	private long addCheckingAccountTime;
	
	/**
	 * 格式化时间
	 */
	@Excel(name="上传时间",width=20)
	private String addCheckingAccountTimeFormat;
	
	
	
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

