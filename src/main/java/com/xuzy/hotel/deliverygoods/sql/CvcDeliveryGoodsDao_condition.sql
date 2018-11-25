		<#if ( cvcDeliveryGoods.deliveryId )?? && cvcDeliveryGoods.deliveryId ?length gt 0>
		    /* delivery_id */
			and cdg.delivery_id = :cvcDeliveryGoods.deliveryId
		</#if>
		<#if ( cvcDeliveryGoods.goodsId )?? && cvcDeliveryGoods.goodsId ?length gt 0>
		    /* goods_id */
			and cdg.goods_id = :cvcDeliveryGoods.goodsId
		</#if>
		<#if ( cvcDeliveryGoods.productId )?? && cvcDeliveryGoods.productId ?length gt 0>
		    /* product_id */
			and cdg.product_id = :cvcDeliveryGoods.productId
		</#if>
		<#if ( cvcDeliveryGoods.productSn )?? && cvcDeliveryGoods.productSn ?length gt 0>
		    /* product_sn */
			and cdg.product_sn = :cvcDeliveryGoods.productSn
		</#if>
		<#if ( cvcDeliveryGoods.goodsName )?? && cvcDeliveryGoods.goodsName ?length gt 0>
		    /* goods_name */
			and cdg.goods_name = :cvcDeliveryGoods.goodsName
		</#if>
		<#if ( cvcDeliveryGoods.brandName )?? && cvcDeliveryGoods.brandName ?length gt 0>
		    /* brand_name */
			and cdg.brand_name = :cvcDeliveryGoods.brandName
		</#if>
		<#if ( cvcDeliveryGoods.goodsSn )?? && cvcDeliveryGoods.goodsSn ?length gt 0>
		    /* goods_sn */
			and cdg.goods_sn = :cvcDeliveryGoods.goodsSn
		</#if>
		<#if ( cvcDeliveryGoods.isReal )?? && cvcDeliveryGoods.isReal ?length gt 0>
		    /* is_real */
			and cdg.is_real = :cvcDeliveryGoods.isReal
		</#if>
		<#if ( cvcDeliveryGoods.extensionCode )?? && cvcDeliveryGoods.extensionCode ?length gt 0>
		    /* extension_code */
			and cdg.extension_code = :cvcDeliveryGoods.extensionCode
		</#if>
		<#if ( cvcDeliveryGoods.parentId )?? && cvcDeliveryGoods.parentId ?length gt 0>
		    /* parent_id */
			and cdg.parent_id = :cvcDeliveryGoods.parentId
		</#if>
		<#if ( cvcDeliveryGoods.sendNumber )?? && cvcDeliveryGoods.sendNumber ?length gt 0>
		    /* send_number */
			and cdg.send_number = :cvcDeliveryGoods.sendNumber
		</#if>
		<#if ( cvcDeliveryGoods.goodsAttr )?? && cvcDeliveryGoods.goodsAttr ?length gt 0>
		    /* goods_attr */
			and cdg.goods_attr = :cvcDeliveryGoods.goodsAttr
		</#if>
		<#if ( cvcDeliveryGoods.systemSku )?? && cvcDeliveryGoods.systemSku ?length gt 0>
		    /* 商品sku */
			and cdg.system_sku = :cvcDeliveryGoods.systemSku
		</#if>
		<#if ( cvcDeliveryGoods.goodsPrice )?? && cvcDeliveryGoods.goodsPrice ?length gt 0>
		    /* goods_price */
			and cdg.goods_price = :cvcDeliveryGoods.goodsPrice
		</#if>
		<#if ( cvcDeliveryGoods.upcId )?? && cvcDeliveryGoods.upcId ?length gt 0>
		    /* upc_id */
			and cdg.upc_id = :cvcDeliveryGoods.upcId
		</#if>
