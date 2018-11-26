package com.xuzy.hotel.ylrequest.module;

public class RequestReNewExchangeEMSJson  extends  BaseBody{
	private int 	OrderID;//	订单ID(Int)
	private String 	 EMSCompany;//	快递公司(例：EMS）
	private String EMSOdd; //快递单号
	private int 	OppStaff = 1;//	操作人(Int)
	
	
	public int getOrderID() {
		return OrderID;
	}
	public void setOrderID(int orderID) {
		OrderID = orderID;
	}
	public String getEMSCompany() {
		return EMSCompany;
	}
	public void setEMSCompany(String eMSCompany) {
		EMSCompany = eMSCompany;
	}
	public String getEMSOdd() {
		return EMSOdd;
	}
	public void setEMSOdd(String eMSOdd) {
		EMSOdd = eMSOdd;
	}
	public int getOppStaff() {
		return OppStaff;
	}
	public void setOppStaff(int oppStaff) {
		OppStaff = oppStaff;
	}
	
	
	
}
