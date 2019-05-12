SELECT 
count(*)
FROM cvc_order_info coi 
LEFT JOIN cvc_delivery_order AS d_o ON coi.order_id=d_o.order_id  
LEFT JOIN cvc_order_goods AS good ON good.order_id = coi.order_id
where (is_show=1 or is_show=2) AND exception_status!=0 
<#include "CvcOrderInfoDao_condition.sql"> 