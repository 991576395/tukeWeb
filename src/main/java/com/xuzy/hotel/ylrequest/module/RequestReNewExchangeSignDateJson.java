package com.xuzy.hotel.ylrequest.module;

public class RequestReNewExchangeSignDateJson  extends  BaseBody{
	private int 	OrderID;//	订单ID(Int)
	private String 	 SignDate;//	签收日期(DateTime)
	private int 	OppStaff = 1;//	操作人(Int)
	
	public int getOrderID() {
		return OrderID;
	}
	public void setOrderID(int orderID) {
		OrderID = orderID;
	}
	public String getSignDate() {
		return SignDate;
	}
	public void setSignDate(String signDate) {
		SignDate = signDate;
	}
	public int getOppStaff() {
		return OppStaff;
	}
	public void setOppStaff(int oppStaff) {
		OppStaff = oppStaff;
	}
}
