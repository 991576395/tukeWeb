package com.xuzy.hotel.order.module;

import java.util.List;

public class DeliveryInfoPojo {
	/**
	 * 快递单号
	 */
	private String invoiceNo;
	
	/**
	 * 物流记录
	 */
	List<Data> deliveryInfos;

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public List<Data> getDeliveryInfos() {
		return deliveryInfos;
	}

	public void setDeliveryInfos(List<Data> deliveryInfos) {
		this.deliveryInfos = deliveryInfos;
	}
	
}
