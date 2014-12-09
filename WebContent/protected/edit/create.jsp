<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="jsf-in-action-components" prefix="jia"%>

<f:view>	
<html>
<head>
	<title><h:outputText value="ProjectTrack - Create a new project" />
	</title>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/stylesheet.css" />
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
					<h:messages globalOnly="true" showDetail="true" styleClass="errors"/>
				</h:panelGrid>
			</f:facet>
			<h:outputLabel for="nameInput">
				<h:outputText value="Name:" />
			</h:outputLabel>
			<h:inputText id="nameInput" size="40" required="true" value="#{visit.currentProject.name}">
				<f:validateLength minimum="5" />
			</h:inputText>
			<h:message for="nameInput" styleClass="errors" />
			<h:outputLabel for="typeSelectOne">
				<h:outputText value="Type:" />
			</h:outputLabel>
			<h:selectOneMenu id="typeSelectOne" title="Select the project type"
				required="true">
				<f:selectItems value="#{selectItems.projectTypes}" /> 
			</h:selectOneMenu>
			<h:message for="typeSelectOne" styleClass="errors" />
			<h:outputLabel for="initiatedByInput">
				<h:outputText value="Initiated by:" />
			</h:outputLabel>
			<h:inputText id="initiatedByInput" size="40" required="true" value="#{visit.currentProject.initiatedBy}">
				<f:validateLength minimum="2" />
			</h:inputText>
			<h:message for="initiatedByInput" styleClass="errors" />
			<h:outputLabel for="requirementsInput">
				<h:outputText value="Requirements contact:" />
			</h:outputLabel>
			<h:inputText id="requirementsInput" size="40" value="#{visit.currentProject.requirementsContact }" 
					validator="#{createProjectBean.validateReqContact}" />
			<h:message for="requirementsInput" styleClass="errors" />
			<h:panelGroup />
			<h:outputLabel for="requirementsEmailInput">
				<h:outputText value="Requirements contact e-mail:" />
			</h:outputLabel>
			<h:inputText id="requirementsEmailInput" size="40" value="#{visit.currentProject.requirementsContactEmail }"
					binding="#{createProjectBean.reqContactEmailInput}">
					
				<jia:validateRegexp expression="\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*" 
						errorMessage="Please enter a valid e-mail address."/>
								
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
						<h:inputTextarea id="commentsInput" rows="10" cols="80" value="#{visit.currentProject.initialComments}"/>
					</h:panelGrid>
					<h:panelGrid columns="2" rowClasses="table-odd-row">
						<h:commandButton value="Save" action="#{createProjectBean.add}" />
						<h:commandButton value="Cancel" action="#{createProjectBean.cancel}" immediate="true" />
					</h:panelGrid>
					<h:panelGroup />
				</h:panelGroup>
			</f:facet>
		</h:panelGrid>
	</h:form>
</body>
</html>
</f:view>