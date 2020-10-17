SELECT  distinct coi.order_id id,
coi.batch_no batchNo,coi.order_source_name orderSourceName,
good.goods_sn goodsSn,
good.goods_number goodsNumber,
good.goods_name goodName,
good.extension_code goodsCompanyNum,
 coi.consignee consignee, 
 coi.user_name userName, 
 coi.tk_order_status orderStatus, 
 coi.yl_order_status ylOrderStatus,
  coi.is_balance isBalance,
 coi.exception_status exceptionStatus, 
coi.add_time addTime,
 coi.get_time getTime,
 d_o.shipping_id shippingId,
 d_o.shipping_name shippingName,
 d_o.address address,
 d_o.tel tel,
 d_o.invoice_no invoiceNo,
 coi.return_reason  returnReason, 
 coi.user_id
FROM cvc_order_info coi 
LEFT JOIN cvc_delivery_order AS d_o ON coi.order_id=d_o.order_id  
LEFT JOIN cvc_order_goods AS good ON good.order_id = coi.order_id
where is_show=1  AND exception_status!=0 AND  coi.tk_order_status != 5  AND coi.yl_order_status !=5
<#include "CvcOrderInfoDao_condition.sql"> 