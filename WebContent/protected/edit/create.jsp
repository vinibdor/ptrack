<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>

<f:view>
<html>
<head>
	<title><h:outputText value="ProjectTrack - Create a new project" />
	</title>
	<link rel="stylesheet" type="text/css" href="stylesheet.css" />
</head>
<body class="page-background">
	<jsp:include page="/includes/header.jsp" />
	<h:form>
		<h:panelGrid columns="3" cellpadding="5"
				footerClass="project-background" styleClass="project-background"
				rowClasses="project-row" columnClasses=",project-input">
			<f:facet name="header">
				<h:panelGrid columns="1" width="100%" cellpadding="3"
					styleClass="project-background" headerClass="page-header">
					<f:facet name="header">
						<h:outputText value="Create a project" />
					</f:facet>
					<h:outputText value="Application messages." styleClass="errors" />
				</h:panelGrid>
			</f:facet>
			<h:outputLabel for="nameInput">
				<h:outputText value="Name:" />
			</h:outputLabel>
			<h:inputText id="nameInput" size="40" required="true">
				<f:validateLength minimum="5" />
			</h:inputText>
			<h:message for="nameInput" styleClass="errors" />
			<h:outputLabel for="typeSelectOne">
				<h:outputText value="Type:" />
			</h:outputLabel>
			<h:selectOneMenu id="typeSelectOne" title="Select the project type"
				required="true">
				<f:selectItem itemValue="" itemLabel="" />
				<f:selectItem itemValue="0" itemLabel="Internal Database" />
				<f:selectItem itemValue="5" itemLabel="External Database" />
				<f:selectItem itemValue="10" itemLabel="Internal Web Application" />
				<f:selectItem itemValue="15" itemLabel="External Web Application" />
				<f:selectItem itemValue="20"
					itemLabel="Internal Desktop Application" />
				<f:selectItem itemValue="25"
					itemLabel="External Desktop Application" />
			</h:selectOneMenu>
			<h:message for="typeSelectOne" styleClass="errors" />
			<h:outputLabel for="initiatedByInput">
				<h:outputText value="Initiated by:" />
			</h:outputLabel>
			<h:inputText id="initiatedByInput" size="40" required="true">
				<f:validateLength minimum="2" />
			</h:inputText>
			<h:message for="initiatedByInput" styleClass="errors" />
			<h:outputLabel for="requirementsInput">
				<h:outputText value="Requirements contact:" />
			</h:outputLabel>
			<h:inputText id="requirementsInput" size="40" />
			<h:panelGroup />
			<h:outputLabel for="requirementsEmailInput">
				<h:outputText value="Requirements contact e-mail:" />
			</h:outputLabel>
			<h:inputText id="requirementsEmailInput" size="40">				
			</h:inputText>
			<h:message for="requirementsEmailInput" styleClass="errors" />
			<%@ include file="/includes/project_artifacts.jsp"%>
			<h:panelGroup />
			<f:facet name="footer">
				<h:panelGroup>
					<h:panelGrid columns="1" cellpadding="5"
						styleClass="table-background"
						rowClasses="table-odd-row,table-even-row">
						<h:outputLabel for="commentsInput">
							<h:outputText value="Your comments:" />
						</h:outputLabel>
						<h:inputTextarea id="commentsInput" rows="10" cols="80" />
					</h:panelGrid>
					<h:panelGrid columns="2" rowClasses="table-odd-row">
						<h:commandButton value="Save" action="save" />
						<h:commandButton value="Cancel" action="cancel" immediate="true" />
					</h:panelGrid>
					<h:panelGroup />
				</h:panelGroup>
			</f:facet>
		</h:panelGrid>
	</h:form>
</body>
</html>
</f:view>