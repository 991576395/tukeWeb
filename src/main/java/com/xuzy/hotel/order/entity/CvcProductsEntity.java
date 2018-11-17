package com.xuzy.hotel.order.entity;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

/**
 * 描述：产品表
 * @author: www.jeecg.org
 * @since：2018年11月03日 12时11分26秒 星期六 
 * @version:1.0
 */
public class CvcProductsEntity implements Serializable{
	private static final long serialVersionUID = 1L;
		/**	 *product_id	 */	private Integer productId;	/**	 *goods_id	 */	private Integer goodsId;	/**	 *goods_attr	 */	private String goodsAttr;	/**	 *product_sn	 */	private String productSn;	/**	 *product_number	 */	private Integer productNumber;	public Integer getProductId() {	    return this.productId;	}	public void setProductId(Integer productId) {	    this.productId=productId;	}	public Integer getGoodsId() {	    return this.goodsId;	}	public void setGoodsId(Integer goodsId) {	    this.goodsId=goodsId;	}	public String getGoodsAttr() {	    return this.goodsAttr;	}	public void setGoodsAttr(String goodsAttr) {	    this.goodsAttr=goodsAttr;	}	public String getProductSn() {	    return this.productSn;	}	public void setProductSn(String productSn) {	    this.productSn=productSn;	}	public Integer getProductNumber() {	    return this.productNumber;	}	public void setProductNumber(Integer productNumber) {	    this.productNumber=productNumber;	}
}

