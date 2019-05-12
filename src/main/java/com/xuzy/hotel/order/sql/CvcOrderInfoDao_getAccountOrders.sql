SELECT distinct o.order_id as id, d_o.shipping_name, d_o.invoice_no,o.address,o.consignee,o.mobile,d_o.signin_date FROM  cvc_order_info AS o LEFT JOIN 
cvc_delivery_order AS d_o ON o.order_id=d_o.order_id where  (is_show=1 or is_show=2) AND is_balance=0 
<#if (userName)?? && userName ?length gt 0>
	/* 积分账户 */
	and o.user_name like CONCAT('%', :userName ,'%')
</#if> 

<#if (startTime)?? && startTime ?length gt 0>
	/* 积分账户 */
	and d_o.signin_date >= :startTime
</#if> 

<#if (endTime)?? && endTime ?length gt 0>
	/* 积分账户 */
	and d_o.signin_date <= :endTime
</#if> 

AND tk_order_status=5
