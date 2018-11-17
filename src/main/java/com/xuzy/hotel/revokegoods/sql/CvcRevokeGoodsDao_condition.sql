		<#if ( cvcRevokeGoods.revkId )?? && cvcRevokeGoods.revkId ?length gt 0>
		    /* revk_id */
			and crg.revk_id = :cvcRevokeGoods.revkId
		</#if>
		<#if ( cvcRevokeGoods.revkSn )?? && cvcRevokeGoods.revkSn ?length gt 0>
		    /* revk_sn */
			and crg.revk_sn = :cvcRevokeGoods.revkSn
		</#if>
		<#if ( cvcRevokeGoods.orderId )?? && cvcRevokeGoods.orderId ?length gt 0>
		    /* 订单id */
			and crg.order_id = :cvcRevokeGoods.orderId
		</#if>
		<#if ( cvcRevokeGoods.orderSn )?? && cvcRevokeGoods.orderSn ?length gt 0>
		    /* 订单编号 */
			and crg.order_sn = :cvcRevokeGoods.orderSn
		</#if>
		<#if ( cvcRevokeGoods.goodsName )?? && cvcRevokeGoods.goodsName ?length gt 0>
		    /* goods_name */
			and crg.goods_name = :cvcRevokeGoods.goodsName
		</#if>
		<#if ( cvcRevokeGoods.goodsSn )?? && cvcRevokeGoods.goodsSn ?length gt 0>
		    /* goods_sn */
			and crg.goods_sn = :cvcRevokeGoods.goodsSn
		</#if>
		<#if ( cvcRevokeGoods.systemSku )?? && cvcRevokeGoods.systemSku ?length gt 0>
		    /* system_sku */
			and crg.system_sku = :cvcRevokeGoods.systemSku
		</#if>
		<#if ( cvcRevokeGoods.colorId )?? && cvcRevokeGoods.colorId ?length gt 0>
		    /* color_id */
			and crg.color_id = :cvcRevokeGoods.colorId
		</#if>
		<#if ( cvcRevokeGoods.colorName )?? && cvcRevokeGoods.colorName ?length gt 0>
		    /* color_name */
			and crg.color_name = :cvcRevokeGoods.colorName
		</#if>
		<#if ( cvcRevokeGoods.sizeId )?? && cvcRevokeGoods.sizeId ?length gt 0>
		    /* size_id */
			and crg.size_id = :cvcRevokeGoods.sizeId
		</#if>
		<#if ( cvcRevokeGoods.sizeName )?? && cvcRevokeGoods.sizeName ?length gt 0>
		    /* size_name */
			and crg.size_name = :cvcRevokeGoods.sizeName
		</#if>
		<#if ( cvcRevokeGoods.marketPrice )?? && cvcRevokeGoods.marketPrice ?length gt 0>
		    /* market_price */
			and crg.market_price = :cvcRevokeGoods.marketPrice
		</#if>
		<#if ( cvcRevokeGoods.goodsPrice )?? && cvcRevokeGoods.goodsPrice ?length gt 0>
		    /* goods_price */
			and crg.goods_price = :cvcRevokeGoods.goodsPrice
		</#if>
		<#if ( cvcRevokeGoods.number )?? && cvcRevokeGoods.number ?length gt 0>
		    /* number */
			and crg.number = :cvcRevokeGoods.number
		</#if>
		<#if ( cvcRevokeGoods.upcId )?? && cvcRevokeGoods.upcId ?length gt 0>
		    /* upc_id */
			and crg.upc_id = :cvcRevokeGoods.upcId
		</#if>
		<#if ( cvcRevokeGoods.imgPath )?? && cvcRevokeGoods.imgPath ?length gt 0>
		    /* img_path */
			and crg.img_path = :cvcRevokeGoods.imgPath
		</#if>
