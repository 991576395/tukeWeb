SELECT <#include "CvcOrderInfoDao_selectData.sql"> 
FROM cvc_order_info coi 
LEFT JOIN 
	(
	SELECT coi_z.order_id id,group_concat(d_o_z.invoice_no) as invoice_no,MAX(d_o_z.shipping_id) as shipping_id, 
	MAX(d_o_z.shipping_name) as shipping_name 
	FROM cvc_order_info coi_z 
	LEFT JOIN cvc_delivery_order AS d_o_z ON coi_z.order_id=d_o_z.order_id  
	where d_o_z.delivery_id in (
		select MAX(delivery_id) from cvc_delivery_order where order_id = d_o_z.order_id  GROUP BY invoice_no 
	)
	GROUP BY coi_z.order_id
) AS d_o  ON coi.order_id=d_o.id  
LEFT JOIN cvc_order_goods AS good ON good.order_id = coi.order_id
where 1=1
<#include "CvcOrderInfoDao_condition.sql"> ORDER BY coi.add_time DESC