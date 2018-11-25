package com.xuzy.hotel.ylrequest.module;

public class RequestExchangeProcessHistoryAddJson  extends  BaseBody{
	private int OrderID;//	订单ID(Int)
	private String SwitNumber;//	流水号(String)
	private String Description;//	描述
	private String ProcessTime;//	处理时间点(DateTime)
	private int 	OppStaff = 1;//	操作人(Int)
	
	public int getOrderID() {
		return OrderID;
	}
	public void setOrderID(int orderID) {
		OrderID = orderID;
	}
	public String getSwitNumber() {
		return SwitNumber;
	}
	public void setSwitNumber(String switNumber) {
		SwitNumber = switNumber;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getProcessTime() {
		return ProcessTime;
	}
	public void setProcessTime(String processTime) {
		ProcessTime = processTime;
	}
	public int getOppStaff() {
		return OppStaff;
	}
	public void setOppStaff(int oppStaff) {
		OppStaff = oppStaff;
	}
}
