package com.xuzy.hotel.ylrequest.module;

public class RequestReturnedExchangeOrderJson {
	private int OrderID;
		
	/**
	 * 退货原因
	 */
	private String ReturningReason;
	
	/**
	 * 退货完成原因
	 */
	private String ReturnedReason;
	
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

	public String getReturningReason() {
		return ReturningReason;
	}

	public void setReturningReason(String returningReason) {
		ReturningReason = returningReason;
	}

	public String getReturnedReason() {
		return ReturnedReason;
	}

	public void setReturnedReason(String returnedReason) {
		ReturnedReason = returnedReason;
	}
	
}
