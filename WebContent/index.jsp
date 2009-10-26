<%@page contentType="text/html; charset=ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://jm.livrosonline/jsf/html" prefix="jm"%>
<f:view>
<head>
	<title>Livros Online: Encontre seu livro já!</title>
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
		<c:forEach items="#{livrosBean.livros}" var="livro">
		<div id="LivroItem">
			<h:commandLink action="#{livrosBean.selecionarLivro}">
				<f:setPropertyActionListener value="#{livro.id}" target="#{livrosBean.livroIdSelecionado}" />
				<jm:graphicImage value="#{livro.imagem}" width="88" height="110"/><br/>
				<h:outputText value="#{livro.nome}" />
			</h:commandLink><br/>
			<jm:tooltip id="FormasPagamento">
				<f:facet name="content">
					<h:panelGroup>
						<b>Outras formas de pagamento</b><br/>
						2x - <h:outputText value="#{livro.preco / 2}" >
							<f:convertNumber pattern="R$,##0.00" locale="BR"/>
						</h:outputText><br/>
						3x - <h:outputText value="#{livro.preco / 3}" >
							<f:convertNumber pattern="R$,##0.00" locale="BR"/>
						</h:outputText>
					</h:panelGroup>
				</f:facet>
				<h:outputText value="#{livro.editora} por #{livro.autor}"/><br/>
				Por apenas: <h:outputText value="#{livro.preco}" style="color:#993300;">
					<f:convertNumber pattern="R$,##0.00" locale="BR"/>
				</h:outputText>
			</jm:tooltip>
		</div>
		</c:forEach>
	</div>
</h:form>
</body>
</f:view>