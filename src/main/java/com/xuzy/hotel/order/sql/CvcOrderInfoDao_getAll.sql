SELECT <#include "CvcOrderInfoDao_selectData.sql"> 
FROM cvc_order_info coi 
LEFT JOIN cvc_delivery_order AS d_o ON coi.order_id=d_o.order_id  
LEFT JOIN cvc_order_goods AS good ON good.order_id = coi.order_id
where 1=1
<#include "CvcOrderInfoDao_condition.sql"> ORDER BY coi.add_time DESC