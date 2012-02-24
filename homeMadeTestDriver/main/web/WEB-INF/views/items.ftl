<#import "formatters.ftl" as formatters />
<h1><@spring.message "item.list.heading" /></h1>

<table id="items">
	<tr>
		<td><@spring.message "item.list.description" /></td>
		<td><@spring.message "item.list.price" /></td>
	</tr>
	<#list items as eachItem>
		<tr>
			<td>${eachItem.description}</td>
			<td><@formatters.currency eachItem.price /></td>
		</tr>
	</#list>
</table>



