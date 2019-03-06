package com.xuzy.hotel.ylrequest.module;

public class RequestBackingExchangeOrderJson {
	private int OrderID;
		
	/**
	 * 返货原因
	 */
	private String BackingReason;
	
	private int OppStaff = 1;

	public int getOrderID() {
		return OrderID;
	}

	public void setOrderID(int orderID) {
		OrderID = orderID;
	}

	public int getOppStaff() {
		return OppStaff;
	}

	public void setOppStaff(int oppStaff) {
		OppStaff = oppStaff;
	}

	public String getBackingReason() {
		return BackingReason;
	}

	public void setBackingReason(String backingReason) {
		BackingReason = backingReason;
	}
	
}
