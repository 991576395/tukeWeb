package com.xuzy.hotel.checkingaccount.dao;

import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.annotation.ResultType;
import org.jeecgframework.minidao.annotation.Sql;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.springframework.stereotype.Repository;

import com.xuzy.hotel.checkingaccount.entity.CvcCheckingAccountEntity;

/**
 * 描述：对账表
 * @author：www.jeecg.org
 * @since：2018年11月14日 19时44分59秒 星期三 
 * @version:1.0
 */
@Repository
public interface CvcCheckingAccountDao{

    /**
	 * 查询返回Java对象
	 * @param id
	 * @return
	 */
	@Sql("SELECT * FROM cvc_checking_account WHERE checking_account_id = :checkingAccountId")
	CvcCheckingAccountEntity get(@Param("checkingAccountId") String checkingAccountId);
	
	/**
	 * 修改数据
	 * @param cvcCheckingAccount
	 * @return
	 */
	int update(@Param("cvcCheckingAccount") CvcCheckingAccountEntity cvcCheckingAccount);
	
	/**
	 * 插入数据
	 * @param act
	 */
	void insert(@Param("cvcCheckingAccount") CvcCheckingAccountEntity cvcCheckingAccount);
	
	/**
	 * 获取数量
	 * @param cvcCheckingAccount
	 * @return
	 */
	@Sql("SELECT COUNT(*) FROM cvc_checking_account")
	int getCount(@Param("cvcCheckingAccount") CvcCheckingAccountEntity cvcCheckingAccount);
	
	/**
	 * 通用分页方法，支持（oracle、mysql、SqlServer、postgresql）
	 * @param cvcCheckingAccount
	 * @param page
	 * @param rows
	 * @return
	 */
	@ResultType(CvcCheckingAccountEntity.class)
	public MiniDaoPage<CvcCheckingAccountEntity> getAll(@Param("cvcCheckingAccount") CvcCheckingAccountEntity cvcCheckingAccount,@Param("page")  int page,@Param("rows") int rows);
	
	@Sql("DELETE from cvc_checking_account WHERE checking_account_id = :id")
	public void delete(@Param("id") String id);
	
	/**
	 * 根据ID删除
	 * @param id
	 */
	 @Sql("DELETE from cvc_checking_account WHERE ID = :id")
	 public void deleteById(@Param("id") String id);
	
}

