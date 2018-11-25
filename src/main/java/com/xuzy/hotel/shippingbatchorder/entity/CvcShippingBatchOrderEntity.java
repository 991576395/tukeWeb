package com.xuzy.hotel.shippingbatchorder.entity;

import java.io.Serializable;
import java.util.Date;

import org.jeecgframework.poi.excel.annotation.Excel;

import java.math.BigDecimal;

/**
 * 描述：批量发货订单表
 * @author: www.jeecg.org
 * @since：2018年11月21日 20时52分03秒 星期三 
 * @version:1.0
 */
public class CvcShippingBatchOrderEntity implements Serializable{
	private static final long serialVersionUID = 1L;
		/**	 *id	 */	private Integer id;	/**	 *导入批次号	 */	private String batchNo;	/**	 *订单号	 */
	@Excel(name="订单号")	private String orderId;	/**	 *快递名称	 */
	@Excel(name="快递名称")	private String shippingName;	/**	 *快递单号	 */
	@Excel(name="快递单号")	private String invoiceNo;	/**	 *预计送到时间	 */
	@Excel(name="预计达到时间")	private String preArrivalDate;	/**	 *导入时间	 */	private String addTime;	/**	 *发货时间	 */	private Integer shippingTime;	/**	 *是否离港（0：未离港；1：已离港）	 */	private Integer isOffharbour;	/**	 *是否已物流订阅（0：未订阅；1：已订阅）	 */	private Integer isPostorder;	/**	 *是否已发货（0：未发货；1：已发货）	 */	private Integer status ;	/**	 *是否为本批次订单(0:否；1:是)	 */	private Integer isOrderBatchNoOk;
	
	private String  isOrderBatchNoOkStr;	/**	 *抓单批次号	 */	private String orderBatchNo;
	/**
	 * 展示状态
	 */
	private String showString;
	
		public String getIsOrderBatchNoOkStr() {
		return isOrderBatchNoOkStr;
	}
	public void setIsOrderBatchNoOkStr(String isOrderBatchNoOkStr) {
		this.isOrderBatchNoOkStr = isOrderBatchNoOkStr;
	}
	public String getShowString() {
		return showString;
	}
	public void setShowString(String showString) {
		this.showString = showString;
	}
	public Integer getId() {	    return this.id;	}	public void setId(Integer id) {	    this.id=id;	}	public String getBatchNo() {	    return this.batchNo;	}	public void setBatchNo(String batchNo) {	    this.batchNo=batchNo;	}		public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getShippingName() {	    return this.shippingName;	}	public void setShippingName(String shippingName) {	    this.shippingName=shippingName;	}	public String getInvoiceNo() {	    return this.invoiceNo;	}	public void setInvoiceNo(String invoiceNo) {	    this.invoiceNo=invoiceNo;	}	public String getPreArrivalDate() {	    return this.preArrivalDate;	}	public void setPreArrivalDate(String preArrivalDate) {	    this.preArrivalDate=preArrivalDate;	}	public String getAddTime() {	    return this.addTime;	}	public void setAddTime(String addTime) {	    this.addTime=addTime;	}	public Integer getShippingTime() {	    return this.shippingTime;	}	public void setShippingTime(Integer shippingTime) {	    this.shippingTime=shippingTime;	}	public Integer getIsOffharbour() {	    return this.isOffharbour;	}	public void setIsOffharbour(Integer isOffharbour) {	    this.isOffharbour=isOffharbour;	}	public Integer getIsPostorder() {	    return this.isPostorder;	}	public void setIsPostorder(Integer isPostorder) {	    this.isPostorder=isPostorder;	}	public Integer getStatus() {	    return this.status;	}	public void setStatus(Integer status) {	    this.status=status;	}	public Integer getIsOrderBatchNoOk() {	    return this.isOrderBatchNoOk;	}	public void setIsOrderBatchNoOk(Integer isOrderBatchNoOk) {	    this.isOrderBatchNoOk=isOrderBatchNoOk;	}	public String getOrderBatchNo() {	    return this.orderBatchNo;	}	public void setOrderBatchNo(String orderBatchNo) {	    this.orderBatchNo=orderBatchNo;	}
}

