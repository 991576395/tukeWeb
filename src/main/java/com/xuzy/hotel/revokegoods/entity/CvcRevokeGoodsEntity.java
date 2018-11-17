package com.xuzy.hotel.revokegoods.entity;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

/**
 * 描述：撤销商品表
 * @author: www.jeecg.org
 * @since：2018年11月03日 22时15分53秒 星期六 
 * @version:1.0
 */
public class CvcRevokeGoodsEntity implements Serializable{
	private static final long serialVersionUID = 1L;
		/**	 *主键	 */	private Integer rId;	/**	 *revk_id	 */	private Integer revkId;	/**	 *revk_sn	 */	private String revkSn;	/**	 *订单id	 */	private Integer orderId;	/**	 *订单编号	 */	private String orderSn;	/**	 *goods_name	 */	private String goodsName;	/**	 *goods_sn	 */	private String goodsSn;	/**	 *system_sku	 */	private String systemSku;	/**	 *color_id	 */	private Integer colorId;	/**	 *color_name	 */	private String colorName;	/**	 *size_id	 */	private Integer sizeId;	/**	 *size_name	 */	private String sizeName;	/**	 *market_price	 */	private BigDecimal marketPrice;	/**	 *goods_price	 */	private BigDecimal goodsPrice;	/**	 *number	 */	private Integer number;	/**	 *upc_id	 */	private Integer upcId;	/**	 *img_path	 */	private String imgPath;
	/**
	 * 总金额
	 */
	private BigDecimal total;
	
		public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	public Integer getRId() {	    return this.rId;	}	public void setRId(Integer rId) {	    this.rId=rId;	}	public Integer getRevkId() {	    return this.revkId;	}	public void setRevkId(Integer revkId) {	    this.revkId=revkId;	}	public String getRevkSn() {	    return this.revkSn;	}	public void setRevkSn(String revkSn) {	    this.revkSn=revkSn;	}	public Integer getOrderId() {	    return this.orderId;	}	public void setOrderId(Integer orderId) {	    this.orderId=orderId;	}	public String getOrderSn() {	    return this.orderSn;	}	public void setOrderSn(String orderSn) {	    this.orderSn=orderSn;	}	public String getGoodsName() {	    return this.goodsName;	}	public void setGoodsName(String goodsName) {	    this.goodsName=goodsName;	}	public String getGoodsSn() {	    return this.goodsSn;	}	public void setGoodsSn(String goodsSn) {	    this.goodsSn=goodsSn;	}	public String getSystemSku() {	    return this.systemSku;	}	public void setSystemSku(String systemSku) {	    this.systemSku=systemSku;	}	public Integer getColorId() {	    return this.colorId;	}	public void setColorId(Integer colorId) {	    this.colorId=colorId;	}	public String getColorName() {	    return this.colorName;	}	public void setColorName(String colorName) {	    this.colorName=colorName;	}	public Integer getSizeId() {	    return this.sizeId;	}	public void setSizeId(Integer sizeId) {	    this.sizeId=sizeId;	}	public String getSizeName() {	    return this.sizeName;	}	public void setSizeName(String sizeName) {	    this.sizeName=sizeName;	}	public BigDecimal getMarketPrice() {	    return this.marketPrice;	}	public void setMarketPrice(BigDecimal marketPrice) {	    this.marketPrice=marketPrice;	}	public BigDecimal getGoodsPrice() {	    return this.goodsPrice;	}	public void setGoodsPrice(BigDecimal goodsPrice) {	    this.goodsPrice=goodsPrice;	}	public Integer getNumber() {	    return this.number;	}	public void setNumber(Integer number) {	    this.number=number;	}	public Integer getUpcId() {	    return this.upcId;	}	public void setUpcId(Integer upcId) {	    this.upcId=upcId;	}	public String getImgPath() {	    return this.imgPath;	}	public void setImgPath(String imgPath) {	    this.imgPath=imgPath;	}
}

