SELECT 
distinct coi.order_id id,
coi.batch_no batchNo,
coi.consignee consignee, 
coi.user_name userName,
coi.tk_order_status orderStatus, 
coi.yl_order_status tkOrderStatus, 
coi.is_balance isBalance, 
coi.exception_status exceptionStatus, 
coi.add_time addTime, 
coi.get_time getTime,
coi.order_sn orderSn,
coi.email,
coi.address,
coi.zipcode,
coi.tel,
coi.mobile,
coi.remark,
coi.return_reason  returnReason
FROM cvc_order_info coi
where 1=1
<#include "CvcOrderInfoDao_condition.sql">