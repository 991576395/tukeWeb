package com.xuzy.hotel.ylrequest.module;

public class RequestOFFHarbourExchangeOrderJson extends BaseBody{
	private int OrderID;
	
	private String EMSCompany;
	
	
	private String EMSOdd;
	
	private String PreArrivalDate;
	
	private int OppStaff = 1;

	

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

	public String getPreArrivalDate() {
		return PreArrivalDate;
	}

	public void setPreArrivalDate(String preArrivalDate) {
		PreArrivalDate = preArrivalDate;
	}

	public int getOppStaff() {
		return OppStaff;
	}

	public void setOppStaff(int oppStaff) {
		OppStaff = oppStaff;
	}
	
}
