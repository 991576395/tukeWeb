package com.xuzy.hotel.deliveryinfonew.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.lang.String;
import java.lang.Double;
import java.lang.Integer;
import java.math.BigDecimal;
import javax.xml.soap.Text;
import java.sql.Blob;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.SequenceGenerator;
import org.jeecgframework.poi.excel.annotation.Excel;

/**   
 * @Title: Entity
 * @Description: 新物流记录表
 * @author onlineGenerator
 * @date 2019-05-11 16:19:16
 * @version V1.0   
 *
 */
@Entity
@Table(name = "cvc_delivery_info_new", schema = "")
@SuppressWarnings("serial")
public class CvcDeliveryInfoNewEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**创建日期*/
	private java.util.Date createDate;
	/**更新日期*/
	private java.util.Date updateDate;
	/**快递单号*/
	@Excel(name="快递单号",width=15)
	private java.lang.String invoiceNo;
	/**快递公司名称*/
	@Excel(name="快递公司名称",width=15)
	private java.lang.String shippingName;
	/**快递公司id*/
	@Excel(name="快递公司id",width=15)
	private java.lang.Integer shippingId;
	/**快递100最新结果*/
	@Excel(name="快递100最新结果",width=15)
	private java.lang.String kuaid100Result;
	/**快递100最新时间*/
	@Excel(name="快递100最新时间",width=15)
	private java.lang.String kuaid100Ftime;
	/**快递100最新物流状态*/
	@Excel(name="快递100最新物流状态",width=15)
	private java.lang.String kuaid100Status;
	/**申通最新结果*/
	@Excel(name="申通最新结果",width=15)
	private java.lang.String shentongResult;
	/**申通最新时间*/
	@Excel(name="申通最新时间",width=15)
	private java.lang.String shentongFtime;
	/**申通最新物流状态*/
	@Excel(name="申通最新物流状态",width=15)
	private java.lang.String shentongStatus;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主键
	 */
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")

	@Column(name ="ID",nullable=false,length=36)
	public java.lang.String getId(){
		return this.id;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  主键
	 */
	public void setId(java.lang.String id){
		this.id = id;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  创建日期
	 */

	@Column(name ="CREATE_DATE",nullable=true,length=20)
	public java.util.Date getCreateDate(){
		return this.createDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  创建日期
	 */
	public void setCreateDate(java.util.Date createDate){
		this.createDate = createDate;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  更新日期
	 */

	@Column(name ="UPDATE_DATE",nullable=true,length=20)
	public java.util.Date getUpdateDate(){
		return this.updateDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  更新日期
	 */
	public void setUpdateDate(java.util.Date updateDate){
		this.updateDate = updateDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  快递单号
	 */

	@Column(name ="INVOICE_NO",nullable=true,length=50)
	public java.lang.String getInvoiceNo(){
		return this.invoiceNo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  快递单号
	 */
	public void setInvoiceNo(java.lang.String invoiceNo){
		this.invoiceNo = invoiceNo;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  快递公司名称
	 */

	@Column(name ="SHIPPING_NAME",nullable=true,length=32)
	public java.lang.String getShippingName(){
		return this.shippingName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  快递公司名称
	 */
	public void setShippingName(java.lang.String shippingName){
		this.shippingName = shippingName;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  快递公司id
	 */

	@Column(name ="SHIPPING_ID",nullable=true,length=3)
	public java.lang.Integer getShippingId(){
		return this.shippingId;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  快递公司id
	 */
	public void setShippingId(java.lang.Integer shippingId){
		this.shippingId = shippingId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  快递100最新结果
	 */

	@Column(name ="KUAID100_RESULT",nullable=true)
	public java.lang.String getKuaid100Result(){
		return this.kuaid100Result;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  快递100最新结果
	 */
	public void setKuaid100Result(java.lang.String kuaid100Result){
		this.kuaid100Result = kuaid100Result;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  快递100最新时间
	 */

	@Column(name ="KUAID100_FTIME",nullable=true,length=32)
	public java.lang.String getKuaid100Ftime(){
		return this.kuaid100Ftime;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  快递100最新时间
	 */
	public void setKuaid100Ftime(java.lang.String kuaid100Ftime){
		this.kuaid100Ftime = kuaid100Ftime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  快递100最新物流状态
	 */

	@Column(name ="KUAID100_STATUS",nullable=true,length=1)
	public java.lang.String getKuaid100Status(){
		return this.kuaid100Status;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  快递100最新物流状态
	 */
	public void setKuaid100Status(java.lang.String kuaid100Status){
		this.kuaid100Status = kuaid100Status;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  申通最新结果
	 */

	@Column(name ="SHENTONG_RESULT",nullable=true)
	public java.lang.String getShentongResult(){
		return this.shentongResult;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  申通最新结果
	 */
	public void setShentongResult(java.lang.String shentongResult){
		this.shentongResult = shentongResult;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  申通最新时间
	 */

	@Column(name ="SHENTONG_FTIME",nullable=true,length=32)
	public java.lang.String getShentongFtime(){
		return this.shentongFtime;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  申通最新时间
	 */
	public void setShentongFtime(java.lang.String shentongFtime){
		this.shentongFtime = shentongFtime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  申通最新物流状态
	 */

	@Column(name ="SHENTONG_STATUS",nullable=true,length=1)
	public java.lang.String getShentongStatus(){
		return this.shentongStatus;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  申通最新物流状态
	 */
	public void setShentongStatus(java.lang.String shentongStatus){
		this.shentongStatus = shentongStatus;
	}
}
