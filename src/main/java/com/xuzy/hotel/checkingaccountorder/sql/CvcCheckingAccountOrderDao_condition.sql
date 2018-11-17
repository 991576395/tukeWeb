		<#if ( cvcCheckingAccountOrder.checkingAccountId )?? && cvcCheckingAccountOrder.checkingAccountId ?length gt 0>
		    /* 对账表头id */
			and ccao.checking_account_id = :cvcCheckingAccountOrder.checkingAccountId
		</#if>
		<#if ( cvcCheckingAccountOrder.orderId )?? && cvcCheckingAccountOrder.orderId ?length gt 0>
		    /* 订单id */
			and ccao.order_id = :cvcCheckingAccountOrder.orderId
		</#if>
		<#if ( cvcCheckingAccountOrder.shippingName )?? && cvcCheckingAccountOrder.shippingName ?length gt 0>
		    /* 快递公司 */
			and ccao.shipping_name = :cvcCheckingAccountOrder.shippingName
		</#if>
		<#if ( cvcCheckingAccountOrder.isAddCheckingAccount )?? && cvcCheckingAccountOrder.isAddCheckingAccount ?length gt 0>
		    /* 是否上传对账明细 */
			and ccao.is_add_checking_account = :cvcCheckingAccountOrder.isAddCheckingAccount
		</#if>
		<#if ( cvcCheckingAccountOrder.addCheckingAccountTime )?? && cvcCheckingAccountOrder.addCheckingAccountTime ?length gt 0>
		    /* 上传时间 */
			and ccao.add_checking_account_time = :cvcCheckingAccountOrder.addCheckingAccountTime
		</#if>
		<#if ( cvcCheckingAccountOrder.invoiceNo )?? && cvcCheckingAccountOrder.invoiceNo ?length gt 0>
		    /* 快递单号 */
			and ccao.invoice_no = :cvcCheckingAccountOrder.invoiceNo
		</#if>
		<#if ( cvcCheckingAccountOrder.goodsSn )?? && cvcCheckingAccountOrder.goodsSn ?length gt 0>
		    /* 商品编号 */
			and ccao.goods_sn = :cvcCheckingAccountOrder.goodsSn
		</#if>
		<#if ( cvcCheckingAccountOrder.goodsNumber )?? && cvcCheckingAccountOrder.goodsNumber ?length gt 0>
		    /* 商品数量 */
			and ccao.goods_number = :cvcCheckingAccountOrder.goodsNumber
		</#if>
		<#if ( cvcCheckingAccountOrder.address )?? && cvcCheckingAccountOrder.address ?length gt 0>
		    /* 收货地址 */
			and ccao.address = :cvcCheckingAccountOrder.address
		</#if>
		<#if ( cvcCheckingAccountOrder.consignee )?? && cvcCheckingAccountOrder.consignee ?length gt 0>
		    /* 收货人 */
			and ccao.consignee = :cvcCheckingAccountOrder.consignee
		</#if>
		<#if ( cvcCheckingAccountOrder.mobile )?? && cvcCheckingAccountOrder.mobile ?length gt 0>
		    /* 手机号 */
			and ccao.mobile = :cvcCheckingAccountOrder.mobile
		</#if>
		<#if ( cvcCheckingAccountOrder.signinDate )?? && cvcCheckingAccountOrder.signinDate ?length gt 0>
		    /* 签收时间 */
			and ccao.signin_date = :cvcCheckingAccountOrder.signinDate
		</#if>
