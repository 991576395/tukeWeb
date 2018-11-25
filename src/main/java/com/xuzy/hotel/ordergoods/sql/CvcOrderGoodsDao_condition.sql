		<#if ( cvcOrderGoods.orderId )?? && cvcOrderGoods.orderId ?length gt 0>
		    /* order_id */
			and cog.order_id = :cvcOrderGoods.orderId
		</#if>
		<#if ( cvcOrderGoods.goodsId )?? && cvcOrderGoods.goodsId ?length gt 0>
		    /* goods_id */
			and cog.goods_id = :cvcOrderGoods.goodsId
		</#if>
		<#if ( cvcOrderGoods.goodsName )?? && cvcOrderGoods.goodsName ?length gt 0>
		    /* goods_name */
			and cog.goods_name = :cvcOrderGoods.goodsName
		</#if>
		<#if ( cvcOrderGoods.goodsSn )?? && cvcOrderGoods.goodsSn ?length gt 0>
		    /* goods_sn */
			and cog.goods_sn = :cvcOrderGoods.goodsSn
		</#if>
		<#if ( cvcOrderGoods.productId )?? && cvcOrderGoods.productId ?length gt 0>
		    /* product_id */
			and cog.product_id = :cvcOrderGoods.productId
		</#if>
		<#if ( cvcOrderGoods.goodsNumber )?? && cvcOrderGoods.goodsNumber ?length gt 0>
		    /* goods_number */
			and cog.goods_number = :cvcOrderGoods.goodsNumber
		</#if>
		<#if ( cvcOrderGoods.marketPrice )?? && cvcOrderGoods.marketPrice ?length gt 0>
		    /* market_price */
			and cog.market_price = :cvcOrderGoods.marketPrice
		</#if>
		<#if ( cvcOrderGoods.goodsPrice )?? && cvcOrderGoods.goodsPrice ?length gt 0>
		    /* goods_price */
			and cog.goods_price = :cvcOrderGoods.goodsPrice
		</#if>
		<#if ( cvcOrderGoods.goodsAttr )?? && cvcOrderGoods.goodsAttr ?length gt 0>
		    /* goods_attr */
			and cog.goods_attr = :cvcOrderGoods.goodsAttr
		</#if>
		<#if ( cvcOrderGoods.sendNumber )?? && cvcOrderGoods.sendNumber ?length gt 0>
		    /* send_number */
			and cog.send_number = :cvcOrderGoods.sendNumber
		</#if>
		<#if ( cvcOrderGoods.isReal )?? && cvcOrderGoods.isReal ?length gt 0>
		    /* is_real */
			and cog.is_real = :cvcOrderGoods.isReal
		</#if>
		<#if ( cvcOrderGoods.extensionCode )?? && cvcOrderGoods.extensionCode ?length gt 0>
		    /* extension_code */
			and cog.extension_code = :cvcOrderGoods.extensionCode
		</#if>
		<#if ( cvcOrderGoods.parentId )?? && cvcOrderGoods.parentId ?length gt 0>
		    /* parent_id */
			and cog.parent_id = :cvcOrderGoods.parentId
		</#if>
		<#if ( cvcOrderGoods.isGift )?? && cvcOrderGoods.isGift ?length gt 0>
		    /* is_gift */
			and cog.is_gift = :cvcOrderGoods.isGift
		</#if>
		<#if ( cvcOrderGoods.goodsAttrId )?? && cvcOrderGoods.goodsAttrId ?length gt 0>
		    /* goods_attr_id */
			and cog.goods_attr_id = :cvcOrderGoods.goodsAttrId
		</#if>
		<#if ( cvcOrderGoods.upcId )?? && cvcOrderGoods.upcId ?length gt 0>
		    /* upc_id */
			and cog.upc_id = :cvcOrderGoods.upcId
		</#if>
		<#if ( cvcOrderGoods.superiorId )?? && cvcOrderGoods.superiorId ?length gt 0>
		    /* 所属分销商用户id */
			and cog.superior_id = :cvcOrderGoods.superiorId
		</#if>
		<#if ( cvcOrderGoods.commission )?? && cvcOrderGoods.commission ?length gt 0>
		    /* 佣金 */
			and cog.commission = :cvcOrderGoods.commission
		</#if>
		<#if ( cvcOrderGoods.superiorSome )?? && cvcOrderGoods.superiorSome ?length gt 0>
		    /* 上级用户提点率 */
			and cog.superior_some = :cvcOrderGoods.superiorSome
		</#if>
		<#if ( cvcOrderGoods.sellerId )?? && cvcOrderGoods.sellerId ?length gt 0>
		    /* 卖家id(此商品来自哪个店铺) */
			and cog.seller_id = :cvcOrderGoods.sellerId
		</#if>
		<#if ( cvcOrderGoods.systemSku )?? && cvcOrderGoods.systemSku ?length gt 0>
		    /* 商品sku */
			and cog.system_sku = :cvcOrderGoods.systemSku
		</#if>
		<#if ( cvcOrderGoods.favGoodsName )?? && cvcOrderGoods.favGoodsName ?length gt 0>
		    /* fav_goods_name */
			and cog.fav_goods_name = :cvcOrderGoods.favGoodsName
		</#if>
		<#if ( cvcOrderGoods.project )?? && cvcOrderGoods.project ?length gt 0>
		    /* 所属项目组 */
			and cog.project = :cvcOrderGoods.project
		</#if>
		<#if ( cvcOrderGoods.groupNo )?? && cvcOrderGoods.groupNo ?length gt 0>
		    /* 团号 */
			and cog.group_no = :cvcOrderGoods.groupNo
		</#if>
		<#if ( cvcOrderGoods.centerId )?? && cvcOrderGoods.centerId ?length gt 0>
		    /* 进销存商品id */
			and cog.center_id = :cvcOrderGoods.centerId
		</#if>
