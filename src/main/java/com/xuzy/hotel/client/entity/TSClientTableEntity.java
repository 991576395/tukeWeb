package com.xuzy.hotel.client.entity;

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

import com.appinterface.app.base.core.entity.request.Requestbody;

/**   
 * @Title: Entity
 * @Description: 客户表
 * @author onlineGenerator
 * @date 2018-06-03 00:55:12
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_s_client_table", schema = "")
@SuppressWarnings("serial")
public class TSClientTableEntity extends Requestbody implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**创建人名称*/
	private java.lang.String createName;
	/**创建人登录名称*/
	private java.lang.String createBy;
	/**创建日期*/
	private java.util.Date createDate;
	/**更新人名称*/
	private java.lang.String updateName;
	/**更新人登录名称*/
	private java.lang.String updateBy;
	/**更新日期*/
	private java.util.Date updateDate;
	/**所属部门*/
	private java.lang.String sysOrgCode;
	/**所属公司*/
	private java.lang.String sysCompanyCode;
	/**流程状态*/
	private java.lang.String bpmStatus;
	/**客户姓名*/
	@Excel(name="客户姓名",width=15)
	private java.lang.String name;
	/**客户生日*/
	@Excel(name="客户生日",width=15)
	private java.lang.String birthday;
	/**性别*/
	@Excel(name="性别",width=15)
	private java.lang.String sex;
	/**地址*/
	@Excel(name="地址",width=15)
	private java.lang.String address;
	/**联系电话或手机*/
	@Excel(name="联系电话或手机",width=15)
	private java.lang.String phone;
	/**公司名*/
	@Excel(name="公司名",width=15)
	private java.lang.String commpany;
	/**备注*/
	@Excel(name="备注",width=15)
	private java.lang.String content;
	/**续单周期开始时间*/
	@Excel(name="续单周期开始时间",width=15)
	private java.lang.String startorderdate;
	/**续单周期*/
	@Excel(name="续单周期",width=15)
	private java.lang.String orderperiod;
	/**周期单位*/
	@Excel(name="周期单位",width=15)
	private java.lang.String ordertype;
	/**
	 * 最近日期
	 */
	private java.lang.String zuijinDate;
	
	@Column(name ="ZUIJINDATE",nullable=true,length=32)
	public java.lang.String getZuijinDate() {
		return zuijinDate;
	}

	public void setZuijinDate(java.lang.String zuijinDate) {
		this.zuijinDate = zuijinDate;
	}

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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建人名称
	 */

	@Column(name ="CREATE_NAME",nullable=true,length=50)
	public java.lang.String getCreateName(){
		return this.createName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人名称
	 */
	public void setCreateName(java.lang.String createName){
		this.createName = createName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建人登录名称
	 */

	@Column(name ="CREATE_BY",nullable=true,length=50)
	public java.lang.String getCreateBy(){
		return this.createBy;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人登录名称
	 */
	public void setCreateBy(java.lang.String createBy){
		this.createBy = createBy;
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  更新人名称
	 */

	@Column(name ="UPDATE_NAME",nullable=true,length=50)
	public java.lang.String getUpdateName(){
		return this.updateName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  更新人名称
	 */
	public void setUpdateName(java.lang.String updateName){
		this.updateName = updateName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  更新人登录名称
	 */

	@Column(name ="UPDATE_BY",nullable=true,length=50)
	public java.lang.String getUpdateBy(){
		return this.updateBy;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  更新人登录名称
	 */
	public void setUpdateBy(java.lang.String updateBy){
		this.updateBy = updateBy;
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
	 *@return: java.lang.String  所属部门
	 */

	@Column(name ="SYS_ORG_CODE",nullable=true,length=50)
	public java.lang.String getSysOrgCode(){
		return this.sysOrgCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  所属部门
	 */
	public void setSysOrgCode(java.lang.String sysOrgCode){
		this.sysOrgCode = sysOrgCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  所属公司
	 */

	@Column(name ="SYS_COMPANY_CODE",nullable=true,length=50)
	public java.lang.String getSysCompanyCode(){
		return this.sysCompanyCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  所属公司
	 */
	public void setSysCompanyCode(java.lang.String sysCompanyCode){
		this.sysCompanyCode = sysCompanyCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  流程状态
	 */

	@Column(name ="BPM_STATUS",nullable=true,length=32)
	public java.lang.String getBpmStatus(){
		return this.bpmStatus;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  流程状态
	 */
	public void setBpmStatus(java.lang.String bpmStatus){
		this.bpmStatus = bpmStatus;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  客户姓名
	 */

	@Column(name ="NAME",nullable=true,length=32)
	public java.lang.String getName(){
		return this.name;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  客户姓名
	 */
	public void setName(java.lang.String name){
		this.name = name;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  客户生日
	 */

	@Column(name ="BIRTHDAY",nullable=true,length=8)
	public java.lang.String getBirthday(){
		return this.birthday;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  客户生日
	 */
	public void setBirthday(java.lang.String birthday){
		this.birthday = birthday;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  性别
	 */

	@Column(name ="SEX",nullable=true,length=1)
	public java.lang.String getSex(){
		return this.sex;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  性别
	 */
	public void setSex(java.lang.String sex){
		this.sex = sex;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  地址
	 */

	@Column(name ="ADDRESS",nullable=true,length=100)
	public java.lang.String getAddress(){
		return this.address;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  地址
	 */
	public void setAddress(java.lang.String address){
		this.address = address;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  联系电话或手机
	 */

	@Column(name ="PHONE",nullable=true,length=11)
	public java.lang.String getPhone(){
		return this.phone;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  联系电话或手机
	 */
	public void setPhone(java.lang.String phone){
		this.phone = phone;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  公司名
	 */

	@Column(name ="COMMPANY",nullable=true,length=50)
	public java.lang.String getCommpany(){
		return this.commpany;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  公司名
	 */
	public void setCommpany(java.lang.String commpany){
		this.commpany = commpany;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */

	@Column(name ="CONTENT",nullable=true,length=300)
	public java.lang.String getContent(){
		return this.content;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注
	 */
	public void setContent(java.lang.String content){
		this.content = content;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  续单周期开始时间
	 */

	@Column(name ="STARTORDERDATE",nullable=true,length=32)
	public java.lang.String getStartorderdate(){
		return this.startorderdate;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  续单周期开始时间
	 */
	public void setStartorderdate(java.lang.String startorderdate){
		this.startorderdate = startorderdate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  续单周期
	 */

	@Column(name ="ORDERPERIOD",nullable=true,length=32)
	public java.lang.String getOrderperiod(){
		return this.orderperiod;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  续单周期
	 */
	public void setOrderperiod(java.lang.String orderperiod){
		this.orderperiod = orderperiod;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  周期单位
	 */

	@Column(name ="ORDERTYPE",nullable=true,length=1)
	public java.lang.String getOrdertype(){
		return this.ordertype;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  周期单位
	 */
	public void setOrdertype(java.lang.String ordertype){
		this.ordertype = ordertype;
	}
}
