<#macro helloFoo>Hello, Foo</#macro>

<#macro hello name="Foo">Hello, ${name}</#macro>

<#macro twoDecimalDigits numInput>
	<#compress>
		${numInput?string("#,###,###,##0.00###")}
	</#compress>
</#macro>



