package com.xuzy.hotel.menutable.service.impl;

import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xuzy.hotel.menutable.service.TMenuTableServiceI;

@Service("tMenuTableService")
@Transactional
public class TMenuTableServiceImpl extends CommonServiceImpl implements TMenuTableServiceI {
	
}