package com.xuzy.hotel.order.module;

import java.util.List;

public class LastResult {
	private String message;

	private String nu;

	private String ischeck;

	private String condition;

	private String com;

	private String status;

	private int state;
	
	
	private String comNew;
	

	private List<Data> data;

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return this.message;
	}

	public void setNu(String nu) {
		this.nu = nu;
	}

	public String getNu() {
		return this.nu;
	}

	public void setIscheck(String ischeck) {
		this.ischeck = ischeck;
	}

	public String getIscheck() {
		return this.ischeck;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getCondition() {
		return this.condition;
	}

	public void setCom(String com) {
		this.com = com;
	}

	public String getCom() {
		return this.com;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return this.status;
	}

	

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public void setData(List<Data> data) {
		this.data = data;
	}

	public List<Data> getData() {
		return this.data;
	}

	public String getComNew() {
		return comNew;
	}

	public void setComNew(String comNew) {
		this.comNew = comNew;
	}
	
	
}
