UPDATE cvc_order_goods
SET 
	   <#if cvcOrderGoods.orderId ?exists>
		   order_id = :cvcOrderGoods.orderId,
		</#if>
	   <#if cvcOrderGoods.goodsId ?exists>
		   goods_id = :cvcOrderGoods.goodsId,
		</#if>
	   <#if cvcOrderGoods.goodsName ?exists>
		   goods_name = :cvcOrderGoods.goodsName,
		</#if>
	   <#if cvcOrderGoods.goodsSn ?exists>
		   goods_sn = :cvcOrderGoods.goodsSn,
		</#if>
	   <#if cvcOrderGoods.productId ?exists>
		   product_id = :cvcOrderGoods.productId,
		</#if>
	   <#if cvcOrderGoods.goodsNumber ?exists>
		   goods_number = :cvcOrderGoods.goodsNumber,
		</#if>
	   <#if cvcOrderGoods.marketPrice ?exists>
		   market_price = :cvcOrderGoods.marketPrice,
		</#if>
	   <#if cvcOrderGoods.goodsPrice ?exists>
		   goods_price = :cvcOrderGoods.goodsPrice,
		</#if>
	   <#if cvcOrderGoods.goodsAttr ?exists>
		   goods_attr = :cvcOrderGoods.goodsAttr,
		</#if>
	   <#if cvcOrderGoods.sendNumber ?exists>
		   send_number = :cvcOrderGoods.sendNumber,
		</#if>
	   <#if cvcOrderGoods.isReal ?exists>
		   is_real = :cvcOrderGoods.isReal,
		</#if>
	   <#if cvcOrderGoods.extensionCode ?exists>
		   extension_code = :cvcOrderGoods.extensionCode,
		</#if>
	   <#if cvcOrderGoods.parentId ?exists>
		   parent_id = :cvcOrderGoods.parentId,
		</#if>
	   <#if cvcOrderGoods.isGift ?exists>
		   is_gift = :cvcOrderGoods.isGift,
		</#if>
	   <#if cvcOrderGoods.goodsAttrId ?exists>
		   goods_attr_id = :cvcOrderGoods.goodsAttrId,
		</#if>
	   <#if cvcOrderGoods.upcId ?exists>
		   upc_id = :cvcOrderGoods.upcId,
		</#if>
	   <#if cvcOrderGoods.superiorId ?exists>
		   superior_id = :cvcOrderGoods.superiorId,
		</#if>
	   <#if cvcOrderGoods.commission ?exists>
		   commission = :cvcOrderGoods.commission,
		</#if>
	   <#if cvcOrderGoods.superiorSome ?exists>
		   superior_some = :cvcOrderGoods.superiorSome,
		</#if>
	   <#if cvcOrderGoods.sellerId ?exists>
		   seller_id = :cvcOrderGoods.sellerId,
		</#if>
	   <#if cvcOrderGoods.systemSku ?exists>
		   system_sku = :cvcOrderGoods.systemSku,
		</#if>
	   <#if cvcOrderGoods.favGoodsName ?exists>
		   fav_goods_name = :cvcOrderGoods.favGoodsName,
		</#if>
	   <#if cvcOrderGoods.project ?exists>
		   project = :cvcOrderGoods.project,
		</#if>
	   <#if cvcOrderGoods.groupNo ?exists>
		   group_no = :cvcOrderGoods.groupNo,
		</#if>
	   <#if cvcOrderGoods.centerId ?exists>
		   center_id = :cvcOrderGoods.centerId,
		</#if>
WHERE id = :cvcOrderGoods.id