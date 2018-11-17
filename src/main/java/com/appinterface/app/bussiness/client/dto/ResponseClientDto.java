package com.appinterface.app.bussiness.client.dto;

import java.util.List;

import com.appinterface.app.base.core.entity.response.Responsebody;
import com.xuzy.hotel.client.entity.TSClientTableEntity;

public class ResponseClientDto extends Responsebody{
	List<TSClientTableEntity> results;
	
	private int curPageNO;
	
	private int count;

	public List<TSClientTableEntity> getResults() {
		return results;
	}

	public void setResults(List<TSClientTableEntity> results) {
		this.results = results;
	}

	public int getCurPageNO() {
		return curPageNO;
	}

	public void setCurPageNO(int curPageNO) {
		this.curPageNO = curPageNO;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	
	
}
