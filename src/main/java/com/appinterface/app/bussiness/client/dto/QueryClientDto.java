package com.appinterface.app.bussiness.client.dto;

import com.appinterface.app.base.core.entity.request.Requestbody;

public class QueryClientDto extends Requestbody{
	private int curPage =1;
	private int pageSize = 10;
	/**
	 * 创建时间排序
	 */
	private String orderTime;

	/**
	 * 销售量排序
	 */
	private String orderSize;
	
	
	
	public String getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}
	public String getOrderSize() {
		return orderSize;
	}
	public void setOrderSize(String orderSize) {
		this.orderSize = orderSize;
	}
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
}
