<%@page contentType="text/html; charset=ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://jm.livrosonline/jsf/html" prefix="jm"%>
<div id="menu">
	<span>Menu</span>
	<c:forEach items="#{livrosBean.categorias}" var="categoria">
	<h:commandLink value="#{categoria.descricao}" id="categoria" action="#{livrosBean.selecionarCategoria}">
		<f:setPropertyActionListener value="#{categoria}" target="#{livrosBean.categoriaSelecionada}" />
	</h:commandLink>
	</c:forEach>
</div>