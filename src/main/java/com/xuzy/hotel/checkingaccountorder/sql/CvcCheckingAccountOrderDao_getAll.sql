SELECT id,checking_account_id checkingAccountId,order_id,shipping_name,is_add_checking_account,add_checking_account_time,invoice_no,goods_sn,goods_number,address,consignee,mobile,signin_date FROM cvc_checking_account_order ccao where 1=1
<#include "CvcCheckingAccountOrderDao_condition.sql"> 
ORDER BY id DESC 

