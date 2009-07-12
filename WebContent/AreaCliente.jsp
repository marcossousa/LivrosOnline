<%@page contentType="text/html; charset=ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<f:view>
<head>
	<title>Livros Online: Cadastre-se � simples e r�pido</title>
	<link href="style.css" rel="stylesheet" type="text/css"/>
</head>
<body>
	<h:form id="ClienteForm">
		<fieldset>
		<div><h:messages globalOnly="true" errorClass="errorMessage" infoClass="successMessage"/></div>
		<h2><h:outputText value="�rea do #{cliente.nome}," /></h2>
		</fieldset>
</h:form>
</body>
</f:view>