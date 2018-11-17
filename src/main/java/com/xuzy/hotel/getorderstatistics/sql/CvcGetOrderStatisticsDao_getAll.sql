SELECT 
id,unified_batch_no,batch_no,add_time,order_count,FROM_UNIXTIME(add_time,'%Y-%m-%d %H:%I:%S') as addTimeFormat,
(SELECT COUNT(*) FROM cvc_order_info io WHERE io.batch_no= cgos.unified_batch_no AND io.tk_order_status='1') as wait_delivery_count,
(SELECT COUNT(*) FROM cvc_order_info io WHERE io.batch_no= cgos.unified_batch_no AND io.tk_order_status='2') as delivery_count,
(SELECT COUNT(*) FROM cvc_order_info io WHERE io.batch_no= cgos.unified_batch_no AND io.tk_order_status='3') as offharbour_count,
(SELECT COUNT(*) FROM cvc_order_info io WHERE io.batch_no= cgos.unified_batch_no AND io.tk_order_status='4') as send_count,
(SELECT COUNT(*) FROM cvc_order_info io WHERE io.batch_no= cgos.unified_batch_no AND io.tk_order_status='5') as signin_count,
(SELECT COUNT(*) FROM cvc_order_info io WHERE io.batch_no= cgos.unified_batch_no AND io.tk_order_status='6') as signin_fail_count,
(SELECT COUNT(*) FROM cvc_order_info io WHERE io.batch_no= cgos.unified_batch_no AND io.exception_status > 0) as exception_count,
(SELECT COUNT(*) FROM cvc_order_info io WHERE io.batch_no= cgos.unified_batch_no AND io.tk_order_status='7') as back_count
FROM cvc_get_order_statistics cgos where 1=1
<#include "CvcGetOrderStatisticsDao_condition.sql">  

order by add_time desc