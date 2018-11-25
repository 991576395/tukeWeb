package com.xuzy.hotel.order.entity;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

/**
 * 描述：商品表
 * @author: www.jeecg.org
 * @since：2018年11月03日 12时09分00秒 星期六 
 * @version:1.0
 */
public class CvcOrderGoodsEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	
	/**
	 * product_number or goods_number
	 */
	private String storage;
	/**
	 *suppliers_id
	 */
	private Integer suppliersId;
	
	/**
	 *brand_name
	 */
	private String brandName;
	
	/**
	 *product_sn
	 */
	private String productSn;
	/**
	 *尺码名称
	 */
	private String sizeName;
	
	/**
	 *颜色名称
	 */
	private String colorName;
	/**
	 *主图
	 */
	private String masterImg;
	
	/**
	 *数量
	 */
	private Integer number;
	
	/**
	 * 格式化后总金额
	 */
	private BigDecimal formatedSubtotal;
		
	
		return formatedSubtotal;
	}
	public void setFormatedSubtotal(BigDecimal formatedSubtotal) {
		this.formatedSubtotal = formatedSubtotal;
	}
	public String getStorage() {
		return storage;
	}
	public void setStorage(String storage) {
		this.storage = storage;
	}
	public Integer getSuppliersId() {
		return suppliersId;
	}
	public void setSuppliersId(Integer suppliersId) {
		this.suppliersId = suppliersId;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getProductSn() {
		return productSn;
	}
	public void setProductSn(String productSn) {
		this.productSn = productSn;
	}
	public String getSizeName() {
		return sizeName;
	}
	public void setSizeName(String sizeName) {
		this.sizeName = sizeName;
	}
	public String getColorName() {
		return colorName;
	}
	public void setColorName(String colorName) {
		this.colorName = colorName;
	}
	public String getMasterImg() {
		return masterImg;
	}
	public void setMasterImg(String masterImg) {
		this.masterImg = masterImg;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public Integer getRecId() {
}
