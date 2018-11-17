package com.xuzy.hotel.ylrequest.module;

public class RequestDeliveryExchangeOrderJson  extends  BaseBody{
	private int OrderID;//	订单ID(Int)
	private String DeliveryingDate;//	开始配送时间(DateTime)
	private int OppStaff = 1;//	操作人(Int)
	
	public int getOrderID() {
		return OrderID;
	}
	public void setOrderID(int orderID) {
		OrderID = orderID;
	}
	public String getDeliveryingDate() {
		return DeliveryingDate;
	}
	public void setDeliveryingDate(String deliveryingDate) {
		DeliveryingDate = deliveryingDate;
	}
	public int getOppStaff() {
		return OppStaff;
	}
	public void setOppStaff(int oppStaff) {
		OppStaff = oppStaff;
	}
	
}
