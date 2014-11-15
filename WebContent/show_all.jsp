<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<f:view>
<html>
<head>
<title><h:outputText value="ProjectTrack - Inbox" /></title>
<link rel="stylesheet" type="text/css" href="stylesheet.css" />
</head>
<body class="page-background">
	<jsp:include page="header.jsp" />
	<h:form>
		<h:panelGrid headerClass="page-header" styleClass="table-background" columns="1" cellpadding="5">
			<f:facet name="header">
				<h:outputText value="Show All Projects" />
			</f:facet>
			<h:outputText value="Application messages." styleClass="errors" />
			<h:panelGrid columns="5" styleClass="table-background"
					rowClasses="table-odd-row,table-even-row" cellpadding="3">
				<h:commandLink styleClass="table-header">
					<h:outputText value="Project name" />
				</h:commandLink>
				<h:commandLink styleClass="table-header">
					<h:outputText value="Type" />
				</h:commandLink>
				<h:commandLink styleClass="table-header">
					<h:outputText value="Status" />
				</h:commandLink>
				<h:commandLink styleClass="table-header">
					<h:outputText value="Wainting for" />
				</h:commandLink>
				<h:panelGroup />
				<h:outputText value="Inventory Manager v2.0" />
				<h:outputText value="Internal Desktop Application" />
				<h:outputText value="Requirements/Analysis" />
				<h:outputText value="System Analyst" />
				<h:commandLink action="details">
					<h:outputText value="Details" />
				</h:commandLink>
				<h:outputText value="TimeTracker" />
				<h:outputText value="Internal Web Application" />
				<h:outputText value="Requirements/Analysis" />
				<h:outputText value="System Analyst" />
				<h:commandLink action="details">
					<h:outputText value="Details" />
				</h:commandLink>
			</h:panelGrid>
		</h:panelGrid>
	</h:form>
</body>
</html>
</f:view>