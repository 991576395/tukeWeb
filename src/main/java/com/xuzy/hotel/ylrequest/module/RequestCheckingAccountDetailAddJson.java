package com.xuzy.hotel.ylrequest.module;

/**
 * 物流请求监听
 * @author Administrator
 *
 */
public class RequestCheckingAccountDetailAddJson extends BaseBody{
	private int CheckAccountInfoID;//	对账表头ID
	private int OrderID;//	订单ID
	private String ProductCode;//	礼品编码
	private int Quantity;//	数量
	private String EMSCompany;//	快递公司
	private int Deliver; //	配送商(Int)
	private int OppStaff;//	操作人(Int)
	private int AccountType; 
	
	
	
	
	
	public int getAccountType() {
		return AccountType;
	}
	public void setAccountType(int accountType) {
		AccountType = accountType;
	}
	public int getCheckAccountInfoID() {
		return CheckAccountInfoID;
	}
	public void setCheckAccountInfoID(int checkAccountInfoID) {
		CheckAccountInfoID = checkAccountInfoID;
	}
	public int getOrderID() {
		return OrderID;
	}
	public void setOrderID(int orderID) {
		OrderID = orderID;
	}
	public String getProductCode() {
		return ProductCode;
	}
	public void setProductCode(String productCode) {
		ProductCode = productCode;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	public String getEMSCompany() {
		return EMSCompany;
	}
	public void setEMSCompany(String eMSCompany) {
		EMSCompany = eMSCompany;
	}
	public int getDeliver() {
		return Deliver;
	}
	public void setDeliver(int deliver) {
		Deliver = deliver;
	}
	public int getOppStaff() {
		return OppStaff;
	}
	public void setOppStaff(int oppStaff) {
		OppStaff = oppStaff;
	}
	
	
}
