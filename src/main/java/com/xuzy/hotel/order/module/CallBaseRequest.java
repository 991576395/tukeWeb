package com.xuzy.hotel.order.module;

public class CallBaseRequest {
	private String status;

	private String billstatus;

	private String message;
		
	/**
	 * 
	 * “” 表示表示快递100 推送
	 * "1" 表示手动获取快递100
	 * “2  表示申通
	 */
	private String type = "";

	private LastResult lastResult;

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return this.status;
	}

	public void setBillstatus(String billstatus) {
		this.billstatus = billstatus;
	}

	public String getBillstatus() {
		return this.billstatus;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return this.message;
	}

	public void setLastResult(LastResult lastResult) {
		this.lastResult = lastResult;
	}

	public LastResult getLastResult() {
		return this.lastResult;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
