package com.xuzy.hotel.order.module;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Date;

import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import freemarker.template.utility.DateUtil;



public class Data implements Serializable{
	private String time;
	
	private String ftime;
	
	private String context;
	
	private String shentongStatus;
	

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

	public String getShentongStatus() {
		return shentongStatus;
	}

	public void setShentongStatus(String shentongStatus) {
		this.shentongStatus = shentongStatus;
	}

	@Override
	public String toString() {
		return "DelivetyJson [time=" + time + ", ftime=" + ftime + ", context=" + context + "]";
	}
	
	
	public static class DataSortByDate implements Comparator<Data>{

		@Override
		public int compare(Data o1, Data o2) {
			try {
				if(o1!= null && o2 != null) {
					Date date1 = DateUtils.parseDate(o1.getFtime(), new String[] {"yyyy-MM-dd HH:mm:ss"});
					Date date2 = DateUtils.parseDate(o2.getFtime(), new String[] {"yyyy-MM-dd HH:mm:ss"});
					if(date1.before(date2)) {
						return 1;
					}else {
						return -1;
					}
				}
			} catch (Exception e) {
			}
			return 0;
		}
		
	}
}

