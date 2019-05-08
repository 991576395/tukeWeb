<table border="1">
	<tr>
		<td style='padding:5px'>订单号</td>
		<td style='padding:5px'>收货人</td>
		<td style='padding:5px'>联系方式</td>
		<td style='padding:5px'>首次派送时间</td>
	</tr>
	
	<#list sendLists as user>
		<tr>
		  <td style='padding:5px'>${user.orderId}</td>
		  <td style='padding:5px'>${user.name}</td>
		  <td style='padding:5px'>${user.phone}</td>
		  <td style='padding:5px'>${user.firtTime}</td>
		</tr>
	</#list>
</table>