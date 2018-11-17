		<#if ( cvcCheckingAccount.checkingAccountId )?? && cvcCheckingAccount.checkingAccountId ?length gt 0>
		    /* 对账表头id */
			and cca.checking_account_id = :cvcCheckingAccount.checkingAccountId
		</#if>
		<#if ( cvcCheckingAccount.topic )?? && cvcCheckingAccount.topic ?length gt 0>
		    /* 对账明细主题 */
			and cca.topic = :cvcCheckingAccount.topic
		</#if>
		<#if ( cvcCheckingAccount.accountType )?? && cvcCheckingAccount.accountType ?length gt 0>
		    /* 积分账号（1.金领冠账户；2.托菲尔账户） */
			and cca.account_type = :cvcCheckingAccount.accountType
		</#if>
		<#if ( cvcCheckingAccount.deliver )?? && cvcCheckingAccount.deliver ?length gt 0>
		    /* 配货商id */
			and cca.deliver = :cvcCheckingAccount.deliver
		</#if>
		<#if ( cvcCheckingAccount.oppstaff )?? && cvcCheckingAccount.oppstaff ?length gt 0>
		    /* 操作人id */
			and cca.oppstaff = :cvcCheckingAccount.oppstaff
		</#if>
		<#if ( cvcCheckingAccount.startTime )?? && cvcCheckingAccount.startTime ?length gt 0>
		    /* 对账开始时间 */
			and cca.start_time = :cvcCheckingAccount.startTime
		</#if>
		<#if ( cvcCheckingAccount.endTime )?? && cvcCheckingAccount.endTime ?length gt 0>
		    /* 对账结束时间 */
			and cca.end_time = :cvcCheckingAccount.endTime
		</#if>
		<#if ( cvcCheckingAccount.addTime )?? && cvcCheckingAccount.addTime ?length gt 0 && cvcCheckingAccount.addTime gt 0>
		    /* 对账生成时间 */
			and cca.add_time = :cvcCheckingAccount.addTime
		</#if>
		<#if ( cvcCheckingAccount.isBalance )?? && cvcCheckingAccount.isBalance ?length gt 0>
		    /* 是否已结算（0:否；1:是） */
			and cca.is_balance = :cvcCheckingAccount.isBalance
		</#if>
