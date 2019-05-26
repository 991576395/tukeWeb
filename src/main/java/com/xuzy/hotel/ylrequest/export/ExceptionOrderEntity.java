package com.xuzy.hotel.ylrequest.export;

import org.jeecgframework.poi.excel.annotation.Excel;

public class ExceptionOrderEntity {
	@Excel(name="订单号",orderNum="1")
	private String orderId;
	@Excel(name="姓名",orderNum="2")
	private String name;
	@Excel(name="手机号",orderNum="3")
	private String phone;
	@Excel(name="首次配送时间",orderNum="4")
	private String firtTime;
	
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getFirtTime() {
		return firtTime;
	}
	public void setFirtTime(String firtTime) {
		this.firtTime = firtTime;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ExceptionOrderEntity other = (ExceptionOrderEntity) obj;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		return true;
	}

	
}
