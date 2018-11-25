package com.xuzy.hotel.shippingbatchorder.entity;

public class ResponseTotelEntity {
	/**
	 * 总数
	 */
	private int totelSize;
	/**
	 * 成功数
	 */
	private int sucSize;
	/**
	 * 失败数量
	 */
	private int faildSize;

	public int getTotelSize() {
		return totelSize;
	}

	public void setTotelSize(int totelSize) {
		this.totelSize = totelSize;
	}

	public int getSucSize() {
		return sucSize;
	}

	public void setSucSize(int sucSize) {
		this.sucSize = sucSize;
	}

	public int getFaildSize() {
		return faildSize;
	}

	public void setFaildSize(int faildSize) {
		this.faildSize = faildSize;
	}

	
}
