UPDATE cvc_checking_account_order
SET 
	   <#if cvcCheckingAccountOrder.checkingAccountId ?exists>
		   checking_account_id = :cvcCheckingAccountOrder.checkingAccountId,
		</#if>
	   <#if cvcCheckingAccountOrder.orderId ?exists>
		   order_id = :cvcCheckingAccountOrder.orderId,
		</#if>
	   <#if cvcCheckingAccountOrder.shippingName ?exists>
		   shipping_name = :cvcCheckingAccountOrder.shippingName,
		</#if>
	   <#if cvcCheckingAccountOrder.isAddCheckingAccount ?exists>
		   is_add_checking_account = :cvcCheckingAccountOrder.isAddCheckingAccount,
		</#if>
	   <#if cvcCheckingAccountOrder.addCheckingAccountTime ?exists>
		   add_checking_account_time = :cvcCheckingAccountOrder.addCheckingAccountTime,
		</#if>
	   <#if cvcCheckingAccountOrder.invoiceNo ?exists>
		   invoice_no = :cvcCheckingAccountOrder.invoiceNo,
		</#if>
	   <#if cvcCheckingAccountOrder.goodsSn ?exists>
		   goods_sn = :cvcCheckingAccountOrder.goodsSn,
		</#if>
	   <#if cvcCheckingAccountOrder.goodsNumber ?exists>
		   goods_number = :cvcCheckingAccountOrder.goodsNumber,
		</#if>
	   <#if cvcCheckingAccountOrder.address ?exists>
		   address = :cvcCheckingAccountOrder.address,
		</#if>
	   <#if cvcCheckingAccountOrder.consignee ?exists>
		   consignee = :cvcCheckingAccountOrder.consignee,
		</#if>
	   <#if cvcCheckingAccountOrder.mobile ?exists>
		   mobile = :cvcCheckingAccountOrder.mobile,
		</#if>
	   <#if cvcCheckingAccountOrder.signinDate ?exists>
		   signin_date = :cvcCheckingAccountOrder.signinDate,
		</#if>
WHERE id = :cvcCheckingAccountOrder.id