<%@page contentType="text/html; charset=ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://jm.livrosonline/jsf/html" prefix="jm"%>
<f:view>
<head>
	<title>Livros Online: <h:outputText value="#{livrosBean.livro.nome}" /></title>
	<link href="style.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<h:form id="livrosform">
	<div id="head">
		Livros Online
	</div>
	<hr/>
	<jsp:include page="menu.jsp" />
	<div id="livrosContainer">
		<p>
			<jm:graphicImage value="#{livrosBean.livro.imagem}" style="float:left; height:240px; with:240px;"/>
			<h2><h:outputText value="#{livrosBean.livro.nome}" /></h2>
			<p><h:outputText value="#{livrosBean.livro.descricao}" escape="false"/></p>
		</p>
		
		<hr />
		
		<p>
			Por apenas: <h:outputText value="#{livrosBean.livro.preco}" style="color:#993300;">
				<f:convertNumber pattern="R$,##0.00" locale="BR"/>
			</h:outputText><br/>
			<b>Outras formas de pagamento</b><br/>
			2x - <h:outputText value="#{livrosBean.livro.preco / 2}" style="color:#993300;" >
				<f:convertNumber pattern="R$,##0.00" locale="BR"/>
			</h:outputText><br/>
			3x - <h:outputText value="#{livrosBean.livro.preco / 3}" style="color:#993300;">
				<f:convertNumber pattern="R$,##0.00" locale="BR"/>
			</h:outputText>
		</p>
		
		<hr/>
		<p>
			Autor: <h:outputText value="#{livrosBean.livro.autor}" style="color:#993300;" /><br/>
			Idioma: <h:outputText value="#{livrosBean.livro.idioma}" style="color:#993300;" /><br/>
			Nª de páginas: <h:outputText value="#{livrosBean.livro.paginas}" style="color:#993300;" /><br/>
			Editor: <h:outputText value="#{livrosBean.livro.editora}" style="color:#993300;" /><br/>
			Ano de Publicação: <h:outputText value="#{livrosBean.livro.anoPublicacao}" style="color:#993300;" /><br/>
		</p>
		
	</div>
	
</h:form>
</body>
</f:view>