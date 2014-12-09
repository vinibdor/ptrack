<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>

<f:view>
<html>
<head>
<title><h:outputText value="ProjectTrack - Approve a Project" />
</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/stylesheet.css" />
</head>
<body class="page-background">
	<jsp:include page="/includes/header.jsp" />
	<h:form>
		<h:panelGrid columns="2" cellpadding="5" headerClass="page-header"
				footerClass="project-background" styleClass="project-background" 
				rowClasses="project-row">
			<f:facet name="header">
				<h:panelGrid columns="1" width="100%" cellpadding="3"
					styleClass="project-background" headerClass="page-header">
					<f:facet name="header">
						<h:outputText value="Approve a project" />
					</f:facet>
					<h:messages globalOnly="true" styleClass="errors"/>
				</h:panelGrid>
			</f:facet>
			
			<h:panelGrid columns="1" cellpadding="5">
			
				<%@ include file="/includes/project_info.jsp" %>
							
				<%@ include file="/includes/project_artifacts.jsp" %>
			
			</h:panelGrid>
			
			<f:facet name="footer">
				<h:panelGroup>
					<%@ include file="/includes/project_comments.jsp"%>
					<h:panelGrid columns="2" rowClasses="table-odd-row">
						<h:commandButton value="Approve" action="#{updateProjectBean.approve}" />
						<h:commandButton value="Cancel" action="#{updateProjectBean.cancel}" immediate="true" />
					</h:panelGrid>
				</h:panelGroup>
			</f:facet>
		</h:panelGrid>
	</h:form>
</body>
</html>
</f:view>