package com.xuzy.hotel.shipping.entity;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

/**
 * 描述：物流表
 * @author: www.jeecg.org
 * @since：2018年10月28日 14时36分19秒 星期日 
 * @version:1.0
 */
public class CvcShippingEntity implements Serializable{
	private static final long serialVersionUID = 1L;
		/**	 *shipping_id	 */	private Integer shippingId;	/**	 *shipping_code	 */	private String shippingCode;	/**	 *shipping_name	 */	private String shippingName;	/**	 *shipping_desc	 */	private String shippingDesc;	/**	 *insure	 */	private String insure;	/**	 *support_cod	 */	private Integer supportCod;	/**	 *enabled	 */	private Integer enabled;	/**	 *shipping_print	 */	private String shippingPrint;	/**	 *print_bg	 */	private String printBg;	/**	 *config_lable	 */	private String configLable;	/**	 *print_model	 */	private Integer printModel;	/**	 *shipping_order	 */	private Integer shippingOrder;	/**	 *供货商suppliers_id	 */	private Integer suppliersId;	/**	 *是否为默认物流 0、否 1、是	 */	private Integer isDefault;	public Integer getShippingId() {	    return this.shippingId;	}	public void setShippingId(Integer shippingId) {	    this.shippingId=shippingId;	}	public String getShippingCode() {	    return this.shippingCode;	}	public void setShippingCode(String shippingCode) {	    this.shippingCode=shippingCode;	}	public String getShippingName() {	    return this.shippingName;	}	public void setShippingName(String shippingName) {	    this.shippingName=shippingName;	}	public String getShippingDesc() {	    return this.shippingDesc;	}	public void setShippingDesc(String shippingDesc) {	    this.shippingDesc=shippingDesc;	}	public String getInsure() {	    return this.insure;	}	public void setInsure(String insure) {	    this.insure=insure;	}	public Integer getSupportCod() {	    return this.supportCod;	}	public void setSupportCod(Integer supportCod) {	    this.supportCod=supportCod;	}	public Integer getEnabled() {	    return this.enabled;	}	public void setEnabled(Integer enabled) {	    this.enabled=enabled;	}	public String getShippingPrint() {	    return this.shippingPrint;	}	public void setShippingPrint(String shippingPrint) {	    this.shippingPrint=shippingPrint;	}	public String getPrintBg() {	    return this.printBg;	}	public void setPrintBg(String printBg) {	    this.printBg=printBg;	}	public String getConfigLable() {	    return this.configLable;	}	public void setConfigLable(String configLable) {	    this.configLable=configLable;	}	public Integer getPrintModel() {	    return this.printModel;	}	public void setPrintModel(Integer printModel) {	    this.printModel=printModel;	}	public Integer getShippingOrder() {	    return this.shippingOrder;	}	public void setShippingOrder(Integer shippingOrder) {	    this.shippingOrder=shippingOrder;	}	public Integer getSuppliersId() {	    return this.suppliersId;	}	public void setSuppliersId(Integer suppliersId) {	    this.suppliersId=suppliersId;	}	public Integer getIsDefault() {	    return this.isDefault;	}	public void setIsDefault(Integer isDefault) {	    this.isDefault=isDefault;	}
}

