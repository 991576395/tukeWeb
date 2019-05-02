package com.xuzy.hotel.offermoney.dao;

import com.xuzy.hotel.offermoney.entity.CvcOfferMoneyEntity;
import org.jeecgframework.minidao.annotation.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 描述：批量发货订单表
 *
 * @author：www.jeecg.org
 * @since：2018年11月21日 20时52分03秒 星期三
 * @version:1.0
 */
@Repository
public interface CvcOfferMoneyDao {

    /**
     * 插入数据
     *
     * @param act
     */
    void insert(@Param("cvcOfferMoney") CvcOfferMoneyEntity cvcOfferMoney);

    /**
     * 插入数据
     *
     * @param act
     */
    void batchInsert(@Param("cvcOfferMoneyList") List<CvcOfferMoneyEntity> cvcOfferMoneyList);
}

