<%@page contentType="text/html; charset=ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<f:view>
<head>
	<title>Livros Online: Cadastre-se é simples e rápido</title>
	<link href="style.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<h:form id="ClienteForm">
	<fieldset>
	<div><h:messages globalOnly="true" errorClass="errorMessage" infoClass="successMessage"/></div>
	<div class="titulo">Meus dados pessoais</div>
	<p>
		<h:outputLabel value="Nome:" for="nome" />
		<h:inputText id="nome" value="#{cliente.nome}" required="true" maxlength="60" 
		size="40" requiredMessage="Informe o seu nome"/>
		<br/><h:message for="nome" styleClass="message" />
	</p>	
	<p>
		<h:outputLabel value="Sobrenome:" for="sobrenome" />
		<h:inputText id="sobrenome" value="#{cliente.sobrenome}" required="true" 
		maxlength="60" size="40" requiredMessage="Informe o seu sobrenome"/>
		<br/><h:message for="sobrenome" styleClass="message" />
	</p>
	<p>
		<h:outputLabel value="CPF:" for="cpf" />
		<h:inputText id="cpf" value="#{cliente.cpf}" required="true" maxlength="11"  
		size="20" requiredMessage="Informe o seu CPF"/> <h:outputText value="(Apenas Números)" />
		<br/><h:message for="cpf" styleClass="message" />
	</p>
	
	<p>
		<h:outputLabel value="RG:" for="rg" />
		<h:inputText id="rg" value="#{cliente.rg}" maxlength="10"  
		size="20" requiredMessage="Informe o seu CPF"/>
		<br/><h:message for="rg" styleClass="message" />
	</p>
	
	<p>
		<h:outputLabel value="Data de Nascimento:" for="DadaNascimento" />
		<h:inputText id="DadaNascimento" value="#{cliente.dataNascimento}" maxlength="10"  size="15">
			<f:convertDateTime pattern="dd/MM/yyyy"/>
		</h:inputText>
		<br/><h:message for="DadaNascimento" styleClass="message" />
	</p>
	
	<p>
		<h:outputLabel value="Sexo:" for="sexo" />
		<h:selectOneRadio id="sexo" value="#{cliente.sexo}" required="true" 
		requiredMessage="Sexo é obrigatório" styleClass="radio">
			<f:selectItems value="#{clienteBean.opcoesSexo}"/>
		</h:selectOneRadio>
		<br/><h:message for="sexo" styleClass="message" />
	</p>
	
	<p>
		<h:outputLabel value="Telefone:" for="telefone" />
		<h:inputText id="telefone" value="#{cliente.telefone}" maxlength="10" size="20" /><h:outputText value="(Apenas Números)" />
		<br/><h:message for="telefone" styleClass="message" />
	</p>
	
	<p>
		<h:outputLabel value="Celular:" for="celular" />
		<h:inputText id="celular" value="#{cliente.celular}" maxlength="10" size="20" /><h:outputText value="(Apenas Números)" />
		<br/><h:message for="celular" styleClass="message" />
	</p>
	<div class="titulo">Meu endereço</div>
	<p>
		<h:outputLabel value="Endereço:" for="endereco" />
		<h:inputText id="endereco" value="#{cliente.endereco}" required="true" 
		maxlength="60" size="40" requiredMessage="Informe o seu endereco"/>
		<br/><h:message for="endereco" styleClass="message" />
	</p>
	<p>
		<h:outputLabel value="Numero:" for="numero" />
		<h:inputText id="numero" value="#{cliente.numero}" required="true" 
		maxlength="4" size="10" requiredMessage="Informe o número do seu endereço"/>
		<br/><h:message for="numero" styleClass="message" />
	</p>
	<p>	
		<h:outputLabel value="Complemento:" for="complemento" />
		<h:inputText id="complemento" value="#{cliente.complemento}" maxlength="20" size="20" />
	</p>
	<p>
		<h:outputLabel value="Bairro:" for="bairro" />
		<h:inputText id="bairro" value="#{cliente.bairro}" required="true" 
		maxlength="60" size="40" requiredMessage="Informe o bairro do seu endereço"/>
		<br/><h:message for="bairro" styleClass="message" />
	</p>
	<p>
		<h:outputLabel value="Estado:" for="estado" />
		<h:selectOneMenu id="uf" value="#{cliente.unidadeFederativa}" required="true" immediate="true"
		requiredMessage="Informe o estado do seu endereço" valueChangeListener="#{clienteBean.atualizaMunicipio}" onchange="submit()">
			<f:selectItem itemLabel="--Selecione um --"/>
			<f:selectItems value="#{clienteBean.unidadesFederativas}"/>
		</h:selectOneMenu>
		<br/><h:message for="estado" styleClass="message" />
	</p>
	
	<p>
		<h:outputLabel value="Cidade:" for="cidade" />
		<h:selectOneMenu id="cidade" value="#{cliente.municipio}" required="true" 
		requiredMessage="Informe a cidade do seu endereço">
			<f:selectItem itemLabel="--Selecione uma --"/>
			<f:selectItems value="#{clienteBean.municipios}"/>
		</h:selectOneMenu>
		<br/><h:message for="estado" styleClass="message" />
	</p>
	<p>
		<h:outputLabel value="Referência:" for="referencia" />
		<h:inputText id="referencia" value="#{cliente.referencia}" maxlength="100" size="60"/>
		<br/><h:message for="referencia" styleClass="message" />
	</p>
	<div class="titulo">Meus dados para acesso</div>
	<p>
		<h:outputLabel value="E-mail:" for="email" />
		<h:inputText id="email" value="#{cliente.email}" required="true" 
		maxlength="100" size="60" requiredMessage="É necessário informar um e-mail válido para login">
			<f:validator validatorId="jm.validator.email"/>
		</h:inputText>
		<br/><h:message for="email" styleClass="message" />
	</p>
	<p>
		<h:outputLabel value="Senha:" for="senha" />
		<h:inputSecret id="senha" value="#{cliente.senha}" required="true" 
		maxlength="16" size="20" requiredMessage="A senha é obrigatório"/>
		<br/><h:message for="senha" styleClass="message" />
	</p>
	<p>
		<h:outputLabel value="Confirme seu senha:" for="senhaConfirmacao" />
		<h:inputSecret id="senhaConfirmacao" value="#{clienteBean.senhaConfirmacao}" required="true" 
		maxlength="16" size="20" requiredMessage="Informe a confirmação de senha"/>
		<br/><h:message for="senhaConfirmacao" styleClass="message" />
	</p>
	
	<p>
		<h:commandButton action="#{clienteBean.registrar}" value="Registrar" styleClass="ok"/>
	</p>
	</fieldset>
</h:form>
</body>
</f:view>