package com.xuzy.hotel.tabletag.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.jeecgframework.core.common.entity.IdEntity;

import com.xuzy.hotel.diningtable.entity.TDiningTableEntity;

/**
 * TSRoleUser entity.
 * @author  张代浩
 */
@Entity
@Table(name = "t_dining_table_tag")
public class TDiningTableTag extends IdEntity implements java.io.Serializable {
	private TTableTagEntity tableTag;
	private TDiningTableEntity diningTable;

	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "dining_tag_id")
	public TTableTagEntity getTableTag() {
		return tableTag;
	}

	public void setTableTag(TTableTagEntity tableTag) {
		this.tableTag = tableTag;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "dining_table_id")
	public TDiningTableEntity getDiningTable() {
		return diningTable;
	}

	public void setDiningTable(TDiningTableEntity diningTable) {
		this.diningTable = diningTable;
	}
	
}