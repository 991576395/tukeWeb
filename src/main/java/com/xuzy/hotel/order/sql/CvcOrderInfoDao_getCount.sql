SELECT COUNT(distinct coi.order_id) FROM cvc_order_info coi LEFT JOIN cvc_delivery_order AS d_o ON coi.order_id=d_o.order_id  
where 1=1
<#include "CvcOrderInfoDao_condition.sql">