UPDATE cvc_revoke_goods
SET 
	   <#if cvcRevokeGoods.revkId ?exists>
		   revk_id = :cvcRevokeGoods.revkId,
		</#if>
	   <#if cvcRevokeGoods.revkSn ?exists>
		   revk_sn = :cvcRevokeGoods.revkSn,
		</#if>
	   <#if cvcRevokeGoods.orderId ?exists>
		   order_id = :cvcRevokeGoods.orderId,
		</#if>
	   <#if cvcRevokeGoods.orderSn ?exists>
		   order_sn = :cvcRevokeGoods.orderSn,
		</#if>
	   <#if cvcRevokeGoods.goodsName ?exists>
		   goods_name = :cvcRevokeGoods.goodsName,
		</#if>
	   <#if cvcRevokeGoods.goodsSn ?exists>
		   goods_sn = :cvcRevokeGoods.goodsSn,
		</#if>
	   <#if cvcRevokeGoods.systemSku ?exists>
		   system_sku = :cvcRevokeGoods.systemSku,
		</#if>
	   <#if cvcRevokeGoods.colorId ?exists>
		   color_id = :cvcRevokeGoods.colorId,
		</#if>
	   <#if cvcRevokeGoods.colorName ?exists>
		   color_name = :cvcRevokeGoods.colorName,
		</#if>
	   <#if cvcRevokeGoods.sizeId ?exists>
		   size_id = :cvcRevokeGoods.sizeId,
		</#if>
	   <#if cvcRevokeGoods.sizeName ?exists>
		   size_name = :cvcRevokeGoods.sizeName,
		</#if>
	   <#if cvcRevokeGoods.marketPrice ?exists>
		   market_price = :cvcRevokeGoods.marketPrice,
		</#if>
	   <#if cvcRevokeGoods.goodsPrice ?exists>
		   goods_price = :cvcRevokeGoods.goodsPrice,
		</#if>
	   <#if cvcRevokeGoods.number ?exists>
		   number = :cvcRevokeGoods.number,
		</#if>
	   <#if cvcRevokeGoods.upcId ?exists>
		   upc_id = :cvcRevokeGoods.upcId,
		</#if>
	   <#if cvcRevokeGoods.imgPath ?exists>
		   img_path = :cvcRevokeGoods.imgPath,
		</#if>
WHERE id = :cvcRevokeGoods.id