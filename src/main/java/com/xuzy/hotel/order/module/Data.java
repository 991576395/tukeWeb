package com.xuzy.hotel.order.module;

import java.io.Serializable;

public class Data implements Serializable{
	private String time;

	private String ftime;

	private String context;
	

	public void setTime(String time) {
		this.time = time;
	}

	public String getTime() {
		return this.time;
	}

	public void setFtime(String ftime) {
		this.ftime = ftime;
	}

	public String getFtime() {
		return this.ftime;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public String getContext() {
		return this.context;
	}
}

