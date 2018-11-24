package com.xuzy.hotel.order.module;

import java.io.Serializable;

public class DelivetyJson implements Serializable{
	private String time;
	
	private String ftime;
	
	private String context;

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getFtime() {
		return ftime;
	}

	public void setFtime(String ftime) {
		this.ftime = ftime;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	@Override
	public String toString() {
		return "DelivetyJson [time=" + time + ", ftime=" + ftime + ", context=" + context + "]";
	}
	
	
}
