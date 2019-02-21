package com.xuzy.hotel.ylrequest.module.order;

import java.util.ArrayList;
import java.util.List;

public class ExchangeOrder {

	/// <summary>
	/// 新增积分订单时，设为0
	/// </summary>
	public int ID = 0;

	/// <summary>
	/// 顾客CRM系统ID号
	/// </summary>
	public int ClientID = 0;

	/// <summary>
	/// 状态
	/// </summary>
	public int State = 1;

	/// <summary>
	/// 状态名称
	/// </summary>
	public String StateName = "";

	/// <summary>
	/// 订单受理时备注说明
	/// </summary>
	public String AcceptRemark = "";

	/// <summary>
	/// 联系电话
	/// </summary>
	public String TeleNum = "";

	/// <summary>
	/// 受理时间
	/// </summary>
	public String AcceptDate;

	/// <summary>
	/// 审核时间
	/// </summary>
	public String ConfirmDate;

	/// <summary>
	/// 预计送达时间
	/// </summary>
	public String PreArrivalDate ;

	/// <summary>
	/// 离港时间
	/// </summary>
	public String OFFHardbourDate;

	/// <summary>
	/// 开始配送时间
	/// </summary>
	public String BeginDeliveryDate;

	/// <summary>
	/// 签收时间
	/// </summary>
	public String SignInDate;

	/// <summary>
	/// 签收人
	/// </summary>
	public String SignInMan = "";

	/// <summary>
	/// 订单备注说明
	/// </summary>
	public String Remark = "";

	/// <summary>
	/// 快递公司
	/// </summary>
	public String DeliveryCompany = "";

	/// <summary>
	/// 快递单号
	/// </summary>
	public String DeliverySheetCode = "";

	/// <summary>
	/// 送货行政城市
	/// </summary>
	public int DeliveryOfficialCity = 0;

	/// <summary>
	/// 送货行政城市行政编码
	/// </summary>
	public String DeliveryOfficialCityCode = "";

	/// <summary>
	/// 行政城市名称
	/// </summary>
	public String DeliveryOfficialCityName = "";

	/// <summary>
	/// 送货地址
	/// </summary>
	public String DeliveryAddre = "";

	/// <summary>
	/// 收货人姓名
	/// </summary>
	public String Consignee = "";

	/// <summary>
	/// 配送商
	/// </summary>
	public int Deliverer = 0;

	/// <summary>
	/// 积分账户
	/// </summary>
	public String AccountType = "金领冠";
	
	/**
	 * 订单来源字段
	 */
	public String OrderSourceName = "";
	
	/// <summary>
	/// 订单明细
	/// </summary>
	public List<ExchangeOrderDetail> Items = new ArrayList<ExchangeOrderDetail>();
	
	public String getOrderSourceName() {
		return OrderSourceName;
	}
	public void setOrderSourceName(String orderSourceName) {
		OrderSourceName = orderSourceName;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getClientID() {
		return ClientID;
	}
	public void setClientID(int clientID) {
		ClientID = clientID;
	}
	public int getState() {
		return State;
	}
	public void setState(int state) {
		State = state;
	}
	public String getStateName() {
		return StateName;
	}
	public void setStateName(String stateName) {
		StateName = stateName;
	}
	public String getAcceptRemark() {
		return AcceptRemark;
	}
	public void setAcceptRemark(String acceptRemark) {
		AcceptRemark = acceptRemark;
	}
	public String getTeleNum() {
		return TeleNum;
	}
	public void setTeleNum(String teleNum) {
		TeleNum = teleNum;
	}
	public String getAcceptDate() {
		return AcceptDate;
	}
	public void setAcceptDate(String acceptDate) {
		AcceptDate = acceptDate;
	}
	public String getConfirmDate() {
		return ConfirmDate;
	}
	public void setConfirmDate(String confirmDate) {
		ConfirmDate = confirmDate;
	}
	public String getPreArrivalDate() {
		return PreArrivalDate;
	}
	public void setPreArrivalDate(String preArrivalDate) {
		PreArrivalDate = preArrivalDate;
	}
	public String getOFFHardbourDate() {
		return OFFHardbourDate;
	}
	public void setOFFHardbourDate(String oFFHardbourDate) {
		OFFHardbourDate = oFFHardbourDate;
	}
	public String getBeginDeliveryDate() {
		return BeginDeliveryDate;
	}
	public void setBeginDeliveryDate(String beginDeliveryDate) {
		BeginDeliveryDate = beginDeliveryDate;
	}
	public String getSignInDate() {
		return SignInDate;
	}
	public void setSignInDate(String signInDate) {
		SignInDate = signInDate;
	}
	public String getSignInMan() {
		return SignInMan;
	}
	public void setSignInMan(String signInMan) {
		SignInMan = signInMan;
	}
	public String getRemark() {
		return Remark;
	}
	public void setRemark(String remark) {
		Remark = remark;
	}
	public String getDeliveryCompany() {
		return DeliveryCompany;
	}
	public void setDeliveryCompany(String deliveryCompany) {
		DeliveryCompany = deliveryCompany;
	}
	public String getDeliverySheetCode() {
		return DeliverySheetCode;
	}
	public void setDeliverySheetCode(String deliverySheetCode) {
		DeliverySheetCode = deliverySheetCode;
	}
	public int getDeliveryOfficialCity() {
		return DeliveryOfficialCity;
	}
	public void setDeliveryOfficialCity(int deliveryOfficialCity) {
		DeliveryOfficialCity = deliveryOfficialCity;
	}
	public String getDeliveryOfficialCityCode() {
		return DeliveryOfficialCityCode;
	}
	public void setDeliveryOfficialCityCode(String deliveryOfficialCityCode) {
		DeliveryOfficialCityCode = deliveryOfficialCityCode;
	}
	public String getDeliveryOfficialCityName() {
		return DeliveryOfficialCityName;
	}
	public void setDeliveryOfficialCityName(String deliveryOfficialCityName) {
		DeliveryOfficialCityName = deliveryOfficialCityName;
	}
	public String getDeliveryAddre() {
		return DeliveryAddre;
	}
	public void setDeliveryAddre(String deliveryAddre) {
		DeliveryAddre = deliveryAddre;
	}
	public String getConsignee() {
		return Consignee;
	}
	public void setConsignee(String consignee) {
		Consignee = consignee;
	}
	public int getDeliverer() {
		return Deliverer;
	}
	public void setDeliverer(int deliverer) {
		Deliverer = deliverer;
	}
	public String getAccountType() {
		return AccountType;
	}
	public void setAccountType(String accountType) {
		AccountType = accountType;
	}
	public List<ExchangeOrderDetail> getItems() {
		return Items;
	}
	public void setItems(List<ExchangeOrderDetail> items) {
		Items = items;
	}
	
}
