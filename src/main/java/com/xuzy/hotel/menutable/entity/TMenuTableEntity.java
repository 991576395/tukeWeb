package com.xuzy.hotel.menutable.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.jeecgframework.core.common.entity.IdEntity;
import org.jeecgframework.web.system.pojo.base.TSAttachment;

import com.xuzy.hotel.company.entity.TSCompanyEntity;
import com.xuzy.hotel.menuclassfry.entity.TMenuClassfryEntity;

/**   
 * @Title: Entity
 * @Description: 菜名维护
 * @author zhangdaihao
 * @date 2018-03-04 10:57:18
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_menu_table", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class TMenuTableEntity extends IdEntity implements java.io.Serializable {
	/**创建人名称*/
	private java.lang.String create_name;
	/**创建人登录名称*/
	private java.lang.String create_by;
	/**创建日期*/
	private java.util.Date create_date;
	/**更新人名称*/
	private java.lang.String update_name;
	/**更新人登录名称*/
	private java.lang.String update_by;
	/**更新日期*/
	private java.util.Date update_date;
	/**所属部门*/
	private java.lang.String sys_org_code;
	/**
	 * 所属公司
	 */
	private TSCompanyEntity company;
	/**流程状态*/
	private java.lang.String bpm_status;
	/**
	 * 所属菜类
	 */
	private TMenuClassfryEntity classfryEntity;
	
	/**菜名*/
	private java.lang.String dishName;
	/**描述*/
	private java.lang.String decription;
	/**库存量*/
	private java.lang.Integer storageNumber;
	/**文件表id*/
	private TSAttachment fileid;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "classfryid")
	public TMenuClassfryEntity getClassfryEntity() {
		return classfryEntity;
	}

	public void setClassfryEntity(TMenuClassfryEntity classfryEntity) {
		this.classfryEntity = classfryEntity;
	}

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建人名称
	 */
	@Column(name ="CREATE_NAME",nullable=true,length=50)
	public java.lang.String getCreate_name(){
		return this.create_name;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人名称
	 */
	public void setCreate_name(java.lang.String create_name){
		this.create_name = create_name;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建人登录名称
	 */
	@Column(name ="CREATE_BY",nullable=true,length=50)
	public java.lang.String getCreate_by(){
		return this.create_by;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人登录名称
	 */
	public void setCreate_by(java.lang.String create_by){
		this.create_by = create_by;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  创建日期
	 */
	@Column(name ="CREATE_DATE",nullable=true)
	public java.util.Date getCreate_date(){
		return this.create_date;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  创建日期
	 */
	public void setCreate_date(java.util.Date create_date){
		this.create_date = create_date;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  更新人名称
	 */
	@Column(name ="UPDATE_NAME",nullable=true,length=50)
	public java.lang.String getUpdate_name(){
		return this.update_name;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  更新人名称
	 */
	public void setUpdate_name(java.lang.String update_name){
		this.update_name = update_name;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  更新人登录名称
	 */
	@Column(name ="UPDATE_BY",nullable=true,length=50)
	public java.lang.String getUpdate_by(){
		return this.update_by;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  更新人登录名称
	 */
	public void setUpdate_by(java.lang.String update_by){
		this.update_by = update_by;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  更新日期
	 */
	@Column(name ="UPDATE_DATE",nullable=true)
	public java.util.Date getUpdate_date(){
		return this.update_date;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  更新日期
	 */
	public void setUpdate_date(java.util.Date update_date){
		this.update_date = update_date;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  所属部门
	 */
	@Column(name ="SYS_ORG_CODE",nullable=true,length=50)
	public java.lang.String getSys_org_code(){
		return this.sys_org_code;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  所属部门
	 */
	public void setSys_org_code(java.lang.String sys_org_code){
		this.sys_org_code = sys_org_code;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "companyid")
	public TSCompanyEntity getCompany() {
		return company;
	}
	public void setCompany(TSCompanyEntity company) {
		this.company = company;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  流程状态
	 */
	@Column(name ="BPM_STATUS",nullable=true,length=32)
	public java.lang.String getBpm_status(){
		return this.bpm_status;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  流程状态
	 */
	public void setBpm_status(java.lang.String bpm_status){
		this.bpm_status = bpm_status;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  菜名
	 */
	@Column(name ="DISH_NAME",nullable=true,length=100)
	public java.lang.String getDishName(){
		return this.dishName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  菜名
	 */
	public void setDishName(java.lang.String dishName){
		this.dishName = dishName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  描述
	 */
	@Column(name ="DECRIPTION",nullable=true,length=100)
	public java.lang.String getDecription(){
		return this.decription;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  描述
	 */
	public void setDecription(java.lang.String decription){
		this.decription = decription;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  库存量
	 */
	@Column(name ="STORAGE_NUMBER",nullable=true,precision=10,scale=0)
	public java.lang.Integer getStorageNumber(){
		return this.storageNumber;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  库存量
	 */
	public void setStorageNumber(java.lang.Integer storageNumber){
		this.storageNumber = storageNumber;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  文件表id
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FILEID")
	public TSAttachment getFileid() {
		return fileid;
	}

	public void setFileid(TSAttachment fileid) {
		this.fileid = fileid;
	}

}
