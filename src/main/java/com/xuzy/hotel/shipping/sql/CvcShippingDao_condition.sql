		<#if ( cvcShipping.shippingCode )?? && cvcShipping.shippingCode ?length gt 0>
		    /* shipping_code */
			and cs.shipping_code = :cvcShipping.shippingCode
		</#if>
		<#if ( cvcShipping.shippingName )?? && cvcShipping.shippingName ?length gt 0>
		    /* shipping_name */
			and cs.shipping_name = :cvcShipping.shippingName
		</#if>
		<#if ( cvcShipping.shippingDesc )?? && cvcShipping.shippingDesc ?length gt 0>
		    /* shipping_desc */
			and cs.shipping_desc = :cvcShipping.shippingDesc
		</#if>
		<#if ( cvcShipping.insure )?? && cvcShipping.insure ?length gt 0>
		    /* insure */
			and cs.insure = :cvcShipping.insure
		</#if>
		<#if ( cvcShipping.supportCod )?? && cvcShipping.supportCod ?length gt 0>
		    /* support_cod */
			and cs.support_cod = :cvcShipping.supportCod
		</#if>
		<#if ( cvcShipping.enabled )?? && cvcShipping.enabled ?length gt 0>
		    /* enabled */
			and cs.enabled = :cvcShipping.enabled
		</#if>
		<#if ( cvcShipping.shippingPrint )?? && cvcShipping.shippingPrint ?length gt 0>
		    /* shipping_print */
			and cs.shipping_print = :cvcShipping.shippingPrint
		</#if>
		<#if ( cvcShipping.printBg )?? && cvcShipping.printBg ?length gt 0>
		    /* print_bg */
			and cs.print_bg = :cvcShipping.printBg
		</#if>
		<#if ( cvcShipping.configLable )?? && cvcShipping.configLable ?length gt 0>
		    /* config_lable */
			and cs.config_lable = :cvcShipping.configLable
		</#if>
		<#if ( cvcShipping.printModel )?? && cvcShipping.printModel ?length gt 0>
		    /* print_model */
			and cs.print_model = :cvcShipping.printModel
		</#if>
		<#if ( cvcShipping.shippingOrder )?? && cvcShipping.shippingOrder ?length gt 0>
		    /* shipping_order */
			and cs.shipping_order = :cvcShipping.shippingOrder
		</#if>
		<#if ( cvcShipping.suppliersId )?? && cvcShipping.suppliersId ?length gt 0>
		    /* 供货商suppliers_id */
			and cs.suppliers_id = :cvcShipping.suppliersId
		</#if>
		<#if ( cvcShipping.isDefault )?? && cvcShipping.isDefault ?length gt 0>
		    /* 是否为默认物流 0、否 1、是 */
			and cs.is_default = :cvcShipping.isDefault
		</#if>
