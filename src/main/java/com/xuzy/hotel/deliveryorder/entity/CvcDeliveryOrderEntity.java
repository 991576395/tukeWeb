package com.xuzy.hotel.deliveryorder.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import com.xuzy.hotel.deliverygoods.entity.CvcDeliveryGoodsEntity;

/**
 * 描述：商品表
 * @author: www.jeecg.org
 * @since：2018年11月03日 13时07分49秒 星期六 
 * @version:1.0
 */
public class CvcDeliveryOrderEntity extends CvcDeliveryGoodsEntity implements Serializable{
	private static final long serialVersionUID = 1L;
		/**	 *delivery_id	 */	private Integer deliveryId;	/**	 *delivery_sn	 */	private String deliverySn;	/**	 *order_sn	 */	private String orderSn;	/**	 *order_id	 */	private Integer orderId;	/**	 *invoice_no	 */	private String invoiceNo;	/**	 *add_time	 */	private Integer addTime;
	/**
	 * 发货时间格式化
	 */
	private String addTimeString;	/**	 *shipping_id	 */	private Integer shippingId;	/**	 *shipping_name	 */	private String shippingName;	/**	 *user_id	 */	private Integer userId;	/**	 *action_user	 */	private String actionUser;	/**	 *consignee	 */	private String consignee;	/**	 *address	 */	private String address;	/**	 *country	 */	private Integer country;	/**	 *province	 */	private Integer province;	/**	 *city	 */	private Integer city;	/**	 *district	 */	private Integer district;	/**	 *sign_building	 */	private String signBuilding;	/**	 *email	 */	private String email;	/**	 *zipcode	 */	private String zipcode;	/**	 *tel	 */	private String tel;	/**	 *mobile	 */	private String mobile;	/**	 *best_time	 */	private String bestTime;	/**	 *postscript	 */	private String postscript;	/**	 *how_oos	 */	private String howOos;	/**	 *insure_fee	 */	private BigDecimal insureFee;	/**	 *shipping_fee	 */	private BigDecimal shippingFee;	/**	 *update_time	 */	private Long updateTime;	/**	 *suppliers_id	 */	private Integer suppliersId;	/**	 *status	 */	private Integer status=0;	/**	 *tk物流状态	 */	private Integer tkStatus = 0;	/**	 *agency_id	 */	private Integer agencyId;	/**	 *预计送到时间	 */	private String preArrivalDate;	/**	 *签收时间	 */	private String signinDate="";
	
	/**
	 *尺码名称
	 */
	private String sizeName;
	/**
	 *颜色名称
	 */
	private String colorName;
	
	
		public String getAddTimeString() {
		return addTimeString;
	}
	public void setAddTimeString(String addTimeString) {
		this.addTimeString = addTimeString;
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
	public Integer getDeliveryId() {	    return this.deliveryId;	}	public void setDeliveryId(Integer deliveryId) {	    this.deliveryId=deliveryId;	}	public String getDeliverySn() {	    return this.deliverySn;	}	public void setDeliverySn(String deliverySn) {	    this.deliverySn=deliverySn;	}	public String getOrderSn() {	    return this.orderSn;	}	public void setOrderSn(String orderSn) {	    this.orderSn=orderSn;	}	public Integer getOrderId() {	    return this.orderId;	}	public void setOrderId(Integer orderId) {	    this.orderId=orderId;	}	public String getInvoiceNo() {	    return this.invoiceNo;	}	public void setInvoiceNo(String invoiceNo) {	    this.invoiceNo=invoiceNo.trim();	}	public Integer getAddTime() {	    return this.addTime;	}	public void setAddTime(Integer addTime) {	    this.addTime=addTime;	}	public Integer getShippingId() {	    return this.shippingId;	}	public void setShippingId(Integer shippingId) {	    this.shippingId=shippingId;	}	public String getShippingName() {	    return this.shippingName;	}	public void setShippingName(String shippingName) {	    this.shippingName=shippingName;	}	public Integer getUserId() {	    return this.userId;	}	public void setUserId(Integer userId) {	    this.userId=userId;	}	public String getActionUser() {	    return this.actionUser;	}	public void setActionUser(String actionUser) {	    this.actionUser=actionUser;	}	public String getConsignee() {	    return this.consignee;	}	public void setConsignee(String consignee) {	    this.consignee=consignee;	}	public String getAddress() {	    return this.address;	}	public void setAddress(String address) {	    this.address=address;	}	public Integer getCountry() {	    return this.country;	}	public void setCountry(Integer country) {	    this.country=country;	}	public Integer getProvince() {	    return this.province;	}	public void setProvince(Integer province) {	    this.province=province;	}	public Integer getCity() {	    return this.city;	}	public void setCity(Integer city) {	    this.city=city;	}	public Integer getDistrict() {	    return this.district;	}	public void setDistrict(Integer district) {	    this.district=district;	}	public String getSignBuilding() {	    return this.signBuilding;	}	public void setSignBuilding(String signBuilding) {	    this.signBuilding=signBuilding;	}	public String getEmail() {	    return this.email;	}	public void setEmail(String email) {	    this.email=email;	}	public String getZipcode() {	    return this.zipcode;	}	public void setZipcode(String zipcode) {	    this.zipcode=zipcode;	}	public String getTel() {	    return this.tel;	}	public void setTel(String tel) {	    this.tel=tel;	}	public String getMobile() {	    return this.mobile;	}	public void setMobile(String mobile) {	    this.mobile=mobile;	}	public String getBestTime() {	    return this.bestTime;	}	public void setBestTime(String bestTime) {	    this.bestTime=bestTime;	}	public String getPostscript() {	    return this.postscript;	}	public void setPostscript(String postscript) {	    this.postscript=postscript;	}	public String getHowOos() {	    return this.howOos;	}	public void setHowOos(String howOos) {	    this.howOos=howOos;	}	public BigDecimal getInsureFee() {	    return this.insureFee;	}	public void setInsureFee(BigDecimal insureFee) {	    this.insureFee=insureFee;	}	public BigDecimal getShippingFee() {	    return this.shippingFee;	}	public void setShippingFee(BigDecimal shippingFee) {	    this.shippingFee=shippingFee;	}	public Long getUpdateTime() {	    return this.updateTime;	}	public void setUpdateTime(Long updateTime) {	    this.updateTime=updateTime;	}	public Integer getSuppliersId() {	    return this.suppliersId;	}	public void setSuppliersId(Integer suppliersId) {	    this.suppliersId=suppliersId;	}	public Integer getStatus() {	    return this.status;	}	public void setStatus(Integer status) {	    this.status=status;	}	public Integer getTkStatus() {	    return this.tkStatus;	}	public void setTkStatus(Integer tkStatus) {	    this.tkStatus=tkStatus;	}	public Integer getAgencyId() {	    return this.agencyId;	}	public void setAgencyId(Integer agencyId) {	    this.agencyId=agencyId;	}	public String getPreArrivalDate() {	    return this.preArrivalDate;	}	public void setPreArrivalDate(String preArrivalDate) {	    this.preArrivalDate=preArrivalDate;	}	public String getSigninDate() {	    return this.signinDate;	}	public void setSigninDate(String signinDate) {	    this.signinDate=signinDate;	}
}

