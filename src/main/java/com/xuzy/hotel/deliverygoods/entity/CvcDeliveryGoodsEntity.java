package com.xuzy.hotel.deliverygoods.entity;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

/**
 * 描述：发货商品表
 * @author: www.jeecg.org
 * @since：2018年11月25日 17时11分43秒 星期日 
 * @version:1.0
 */
public class CvcDeliveryGoodsEntity implements Serializable{
	private static final long serialVersionUID = 1L;
		/**	 *rec_id	 */	private Integer recId;	/**	 *delivery_id	 */	private Integer deliveryId;	/**	 *goods_id	 */	private String goodsId;	/**	 *product_id	 */	private Integer productId;	/**	 *product_sn	 */	private String productSn;	/**	 *goods_name	 */	private String goodsName;	/**	 *brand_name	 */	private String brandName;	/**	 *goods_sn	 */	private String goodsSn;	/**	 *is_real	 */	private Integer isReal;	/**	 *extension_code	 */	private String extensionCode;	/**	 *parent_id	 */	private Integer parentId;	/**	 *send_number	 */	private Integer sendNumber;	/**	 *goods_attr	 */	private String goodsAttr;	/**	 *商品sku	 */	private String systemSku;	/**	 *goods_price	 */	private BigDecimal goodsPrice;	/**	 *upc_id	 */	private Integer upcId;	public Integer getRecId() {	    return this.recId;	}	public void setRecId(Integer recId) {	    this.recId=recId;	}	public Integer getDeliveryId() {	    return this.deliveryId;	}	public void setDeliveryId(Integer deliveryId) {	    this.deliveryId=deliveryId;	}		public String getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}
	public Integer getProductId() {	    return this.productId;	}	public void setProductId(Integer productId) {	    this.productId=productId;	}	public String getProductSn() {	    return this.productSn;	}	public void setProductSn(String productSn) {	    this.productSn=productSn;	}	public String getGoodsName() {	    return this.goodsName;	}	public void setGoodsName(String goodsName) {	    this.goodsName=goodsName;	}	public String getBrandName() {	    return this.brandName;	}	public void setBrandName(String brandName) {	    this.brandName=brandName;	}	public String getGoodsSn() {	    return this.goodsSn;	}	public void setGoodsSn(String goodsSn) {	    this.goodsSn=goodsSn;	}	public Integer getIsReal() {	    return this.isReal;	}	public void setIsReal(Integer isReal) {	    this.isReal=isReal;	}	public String getExtensionCode() {	    return this.extensionCode;	}	public void setExtensionCode(String extensionCode) {	    this.extensionCode=extensionCode;	}	public Integer getParentId() {	    return this.parentId;	}	public void setParentId(Integer parentId) {	    this.parentId=parentId;	}	public Integer getSendNumber() {	    return this.sendNumber;	}	public void setSendNumber(Integer sendNumber) {	    this.sendNumber=sendNumber;	}	public String getGoodsAttr() {	    return this.goodsAttr;	}	public void setGoodsAttr(String goodsAttr) {	    this.goodsAttr=goodsAttr;	}	public String getSystemSku() {	    return this.systemSku;	}	public void setSystemSku(String systemSku) {	    this.systemSku=systemSku;	}	public BigDecimal getGoodsPrice() {	    return this.goodsPrice;	}	public void setGoodsPrice(BigDecimal goodsPrice) {	    this.goodsPrice=goodsPrice;	}	public Integer getUpcId() {	    return this.upcId;	}	public void setUpcId(Integer upcId) {	    this.upcId=upcId;	}
}

