UPDATE cvc_checking_account
SET 
	   <#if cvcCheckingAccount.checkingAccountId ?exists>
		   checking_account_id = :cvcCheckingAccount.checkingAccountId,
		</#if>
	   <#if cvcCheckingAccount.topic ?exists>
		   topic = :cvcCheckingAccount.topic,
		</#if>
	   <#if cvcCheckingAccount.accountType ?exists>
		   account_type = :cvcCheckingAccount.accountType,
		</#if>
	   <#if cvcCheckingAccount.deliver ?exists>
		   deliver = :cvcCheckingAccount.deliver,
		</#if>
	   <#if cvcCheckingAccount.oppstaff ?exists>
		   oppstaff = :cvcCheckingAccount.oppstaff,
		</#if>
	   <#if cvcCheckingAccount.startTime ?exists>
		   start_time = :cvcCheckingAccount.startTime,
		</#if>
	   <#if cvcCheckingAccount.endTime ?exists>
		   end_time = :cvcCheckingAccount.endTime,
		</#if>
	   <#if cvcCheckingAccount.addTime ?exists>
		   add_time = :cvcCheckingAccount.addTime,
		</#if>
	   <#if cvcCheckingAccount.isBalance ?exists>
		   is_balance = :cvcCheckingAccount.isBalance,
		</#if>
WHERE checking_account_id = :cvcCheckingAccount.checkingAccountId