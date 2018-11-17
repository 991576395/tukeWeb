		<#if ( cvcCheckingAccountOrder.checkingAccountId )?? && cvcCheckingAccountOrder.checkingAccountId ?length gt 0>
		    /* 对账表头id */
			and ccao.checking_account_id = :cvcCheckingAccountOrder.checkingAccountId
		</#if>
		<#if ( cvcCheckingAccountOrder.orderId )?? && cvcCheckingAccountOrder.orderId ?length gt 0>
		    /* 订单id */
			and ccao.order_id = :cvcCheckingAccountOrder.orderId
		</#if>
		<#if (cvcCheckingAccountOrder.isAddCheckingAccount )?? && cvcCheckingAccountOrder.isAddCheckingAccount ?length gt 0>
		    /* 是否上传对账明细 */
			and ccao.is_add_checking_account = :cvcCheckingAccountOrder.isAddCheckingAccount
		</#if>
		<#if ( cvcCheckingAccountOrder.invoiceNo )?? && cvcCheckingAccountOrder.invoiceNo ?length gt 0>
		    /* 快递单号 */
			and ccao.invoice_no = :cvcCheckingAccountOrder.invoiceNo
		</#if>
