package com.xuzy.hotel.order.entity;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

/**
 * 描述：商品表
 * @author: www.jeecg.org
 * @since：2018年11月03日 12时12分27秒 星期六 
 * @version:1.0
 */
public class CvcBrandEntity implements Serializable{
	private static final long serialVersionUID = 1L;
		/**	 *brand_id	 */	private Integer brandId;	/**	 *brand_name	 */	private String brandName;	/**	 *brand_logo	 */	private String brandLogo;	/**	 *brand_desc	 */	private String brandDesc;	/**	 *site_url	 */	private String siteUrl;	/**	 *sort_order	 */	private Integer sortOrder;	/**	 *is_show	 */	private Integer isShow;	/**	 *brand_english	 */	private String brandEnglish;	/**	 *country	 */	private String country;	/**	 *is_enable	 */	private Integer isEnable;	/**	 *进销存品牌id	 */	private Integer centerId;	public Integer getBrandId() {	    return this.brandId;	}	public void setBrandId(Integer brandId) {	    this.brandId=brandId;	}	public String getBrandName() {	    return this.brandName;	}	public void setBrandName(String brandName) {	    this.brandName=brandName;	}	public String getBrandLogo() {	    return this.brandLogo;	}	public void setBrandLogo(String brandLogo) {	    this.brandLogo=brandLogo;	}	public String getBrandDesc() {	    return this.brandDesc;	}	public void setBrandDesc(String brandDesc) {	    this.brandDesc=brandDesc;	}	public String getSiteUrl() {	    return this.siteUrl;	}	public void setSiteUrl(String siteUrl) {	    this.siteUrl=siteUrl;	}	public Integer getSortOrder() {	    return this.sortOrder;	}	public void setSortOrder(Integer sortOrder) {	    this.sortOrder=sortOrder;	}	public Integer getIsShow() {	    return this.isShow;	}	public void setIsShow(Integer isShow) {	    this.isShow=isShow;	}	public String getBrandEnglish() {	    return this.brandEnglish;	}	public void setBrandEnglish(String brandEnglish) {	    this.brandEnglish=brandEnglish;	}	public String getCountry() {	    return this.country;	}	public void setCountry(String country) {	    this.country=country;	}	public Integer getIsEnable() {	    return this.isEnable;	}	public void setIsEnable(Integer isEnable) {	    this.isEnable=isEnable;	}	public Integer getCenterId() {	    return this.centerId;	}	public void setCenterId(Integer centerId) {	    this.centerId=centerId;	}
}

