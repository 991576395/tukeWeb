package com.xuzy.hotel.ylrequest.module;

public class RequestSignInExchangeOrderJson  extends  BaseBody{
	private int OrderID;
	
	private String SignInMan;
	
	private String SignInDate;
	
	private int OppStaff = 1;

	public int getOrderID() {
		return OrderID;
	}

	public void setOrderID(int orderID) {
		OrderID = orderID;
	}

	public String getSignInMan() {
		return SignInMan;
	}

	public void setSignInMan(String signInMan) {
		SignInMan = signInMan;
	}

	public String getSignInDate() {
		return SignInDate;
	}

	public void setSignInDate(String signInDate) {
		SignInDate = signInDate;
	}

	public int getOppStaff() {
		return OppStaff;
	}

	public void setOppStaff(int oppStaff) {
		OppStaff = oppStaff;
	}
	
}
