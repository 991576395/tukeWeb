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
		/**	 *rec_id	 */	private Integer recId;	/**	 *order_id	 */	private Integer orderId;	/**	 *goods_id	 */	private Integer goodsId;	/**	 *goods_name	 */	private String goodsName;	/**	 *goods_sn	 */	private String goodsSn;	/**	 *product_id	 */	private Integer productId;	/**	 *goods_number	 */	private Integer goodsNumber;	/**	 *market_price	 */	private BigDecimal marketPrice;	/**	 *goods_price	 */	private BigDecimal goodsPrice;	/**	 *goods_attr	 */	private String goodsAttr;	/**	 *send_number	 */	private Integer sendNumber;	/**	 *is_real	 */	private Integer isReal;	/**	 *extension_code	 */	private String extensionCode;	/**	 *parent_id	 */	private Integer parentId;	/**	 *is_gift	 */	private Integer isGift;	/**	 *goods_attr_id	 */	private String goodsAttrId;	/**	 *upc_id	 */	private Integer upcId;	/**	 *所属分销商用户id	 */	private Integer superiorId;	/**	 *佣金	 */	private BigDecimal commission;	/**	 *上级用户提点率	 */	private Integer superiorSome;	/**	 *卖家id(此商品来自哪个店铺)	 */	private Integer sellerId;	/**	 *商品sku	 */	private String systemSku;	/**	 *fav_goods_name	 */	private String favGoodsName;	/**	 *所属项目组	 */	private String project;	/**	 *团号	 */	private Integer groupNo;	/**	 *进销存商品id	 */	private Integer centerId;
	
	
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
		
		public BigDecimal getFormatedSubtotal() {
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
	public Integer getRecId() {	    return this.recId;	}	public void setRecId(Integer recId) {	    this.recId=recId;	}	public Integer getOrderId() {	    return this.orderId;	}	public void setOrderId(Integer orderId) {	    this.orderId=orderId;	}	public Integer getGoodsId() {	    return this.goodsId;	}	public void setGoodsId(Integer goodsId) {	    this.goodsId=goodsId;	}	public String getGoodsName() {	    return this.goodsName;	}	public void setGoodsName(String goodsName) {	    this.goodsName=goodsName;	}	public String getGoodsSn() {	    return this.goodsSn;	}	public void setGoodsSn(String goodsSn) {	    this.goodsSn=goodsSn;	}	public Integer getProductId() {	    return this.productId;	}	public void setProductId(Integer productId) {	    this.productId=productId;	}	public Integer getGoodsNumber() {	    return this.goodsNumber;	}	public void setGoodsNumber(Integer goodsNumber) {	    this.goodsNumber=goodsNumber;	}	public BigDecimal getMarketPrice() {	    return this.marketPrice;	}	public void setMarketPrice(BigDecimal marketPrice) {	    this.marketPrice=marketPrice;	}	public BigDecimal getGoodsPrice() {	    return this.goodsPrice;	}	public void setGoodsPrice(BigDecimal goodsPrice) {	    this.goodsPrice=goodsPrice;	}	public String getGoodsAttr() {	    return this.goodsAttr;	}	public void setGoodsAttr(String goodsAttr) {	    this.goodsAttr=goodsAttr;	}	public Integer getSendNumber() {	    return this.sendNumber;	}	public void setSendNumber(Integer sendNumber) {	    this.sendNumber=sendNumber;	}	public Integer getIsReal() {	    return this.isReal;	}	public void setIsReal(Integer isReal) {	    this.isReal=isReal;	}	public String getExtensionCode() {	    return this.extensionCode;	}	public void setExtensionCode(String extensionCode) {	    this.extensionCode=extensionCode;	}	public Integer getParentId() {	    return this.parentId;	}	public void setParentId(Integer parentId) {	    this.parentId=parentId;	}	public Integer getIsGift() {	    return this.isGift;	}	public void setIsGift(Integer isGift) {	    this.isGift=isGift;	}	public String getGoodsAttrId() {	    return this.goodsAttrId;	}	public void setGoodsAttrId(String goodsAttrId) {	    this.goodsAttrId=goodsAttrId;	}	public Integer getUpcId() {	    return this.upcId;	}	public void setUpcId(Integer upcId) {	    this.upcId=upcId;	}	public Integer getSuperiorId() {	    return this.superiorId;	}	public void setSuperiorId(Integer superiorId) {	    this.superiorId=superiorId;	}	public BigDecimal getCommission() {	    return this.commission;	}	public void setCommission(BigDecimal commission) {	    this.commission=commission;	}	public Integer getSuperiorSome() {	    return this.superiorSome;	}	public void setSuperiorSome(Integer superiorSome) {	    this.superiorSome=superiorSome;	}	public Integer getSellerId() {	    return this.sellerId;	}	public void setSellerId(Integer sellerId) {	    this.sellerId=sellerId;	}	public String getSystemSku() {	    return this.systemSku;	}	public void setSystemSku(String systemSku) {	    this.systemSku=systemSku;	}	public String getFavGoodsName() {	    return this.favGoodsName;	}	public void setFavGoodsName(String favGoodsName) {	    this.favGoodsName=favGoodsName;	}	public String getProject() {	    return this.project;	}	public void setProject(String project) {	    this.project=project;	}	public Integer getGroupNo() {	    return this.groupNo;	}	public void setGroupNo(Integer groupNo) {	    this.groupNo=groupNo;	}	public Integer getCenterId() {	    return this.centerId;	}	public void setCenterId(Integer centerId) {	    this.centerId=centerId;	}
}

