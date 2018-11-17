package com.xuzy.hotel.ylrequest.module;

public class RequestCheckingAcccountInfoAddJson  extends  BaseBody{
	private String 	Topic;//	对账明细主题(String)
	private String 	BeginDate;//	对账明细开始时间(DateTime)
	private String 	EndDate;//	对账明细截止时间(DateTime)
	private int 	Deliver;//	配送商(Int)
	private int 	AccountType;//	积分账号(Int)
	private int 	OppStaff = 1;//	操作人(Int)
	
	public String getTopic() {
		return Topic;
	}
	public void setTopic(String topic) {
		Topic = topic;
	}
	public String getBeginDate() {
		return BeginDate;
	}
	public void setBeginDate(String beginDate) {
		BeginDate = beginDate;
	}
	public String getEndDate() {
		return EndDate;
	}
	public void setEndDate(String endDate) {
		EndDate = endDate;
	}
	public int getDeliver() {
		return Deliver;
	}
	public void setDeliver(int deliver) {
		Deliver = deliver;
	}
	public int getAccountType() {
		return AccountType;
	}
	public void setAccountType(int accountType) {
		AccountType = accountType;
	}
	public int getOppStaff() {
		return OppStaff;
	}
	public void setOppStaff(int oppStaff) {
		OppStaff = oppStaff;
	}
	
}
