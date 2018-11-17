package com.xuzy.hotel.ylrequest.module;

public class RequestSetOrdersReadJson  extends  BaseBody{
	private String OrderIDs;
	
	private int OppStaff = 1;


	public String getOrderIDs() {
		return OrderIDs;
	}


	public void setOrderIDs(String orderIDs) {
		OrderIDs = orderIDs;
	}


	public int getOppStaff() {
		return OppStaff;
	}


	public void setOppStaff(int oppStaff) {
		OppStaff = oppStaff;
	}
	
}
