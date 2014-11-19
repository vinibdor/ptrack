<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<f:view>
<html>
<head>
<title><h:outputText value="ProjectTrack - Inbox" /></title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/stylesheet.css" />
</head>
<body class="page-background">
	<jsp:include page="/includes/header.jsp" />
	<h:form>
		<h:panelGrid headerClass="page-header" styleClass="table-background"
			columns="1" cellpadding="5">
			<f:facet name="header">
				<h:outputText value="Inbox - approve or reject projects" />
			</f:facet>
			<h:outputText value="Application messages." styleClass="errors" />
			<h:dataTable  styleClass="table-background" rowClasses="table-odd-row, table-even-row"
				cellpadding="3" value="#{inboxBean.inboxProjects}" var="project" 
				binding="#{inboxBean.projectTable}">	
								
				<h:column>
					<f:facet name="header">
						<h:commandLink styleClass="table-header" actionListener="#{inboxBean.sort}">
							<h:outputText value="Project name" />
							<f:param name="column" value="name" />
						</h:commandLink>
					</f:facet>
					<h:outputText value="#{project.name}" />
				</h:column>
				<h:column>
					<f:facet name="header">				
						<h:commandLink styleClass="table-header" actionListener="#{inboxBean.sort}">
							<h:outputText value="Type" />
							<f:param name="column" value="type" />
						</h:commandLink>						
					</f:facet>
					<h:outputText value="#{project.type}" />
				</h:column>
				<h:column>
					<f:facet name="header">
						<h:commandLink styleClass="table-header"  actionListener="#{inboxBean.sort}">
							<h:outputText value="Status" />
							<f:param name="column" value="status" />
						</h:commandLink>
					</f:facet>
					<h:outputText value="#{project.status.name}" />
				</h:column>
				<h:column>					
					<h:commandLink action="#{inboxBean.approve}">
						<h:outputText value="Approve" />						
					</h:commandLink>
				</h:column>
				<h:column>					
					<h:commandLink action="#{inboxBean.reject}">
						<h:outputText value="Reject" />						
					</h:commandLink>
				</h:column>
				<h:column>					
					<h:commandLink action="#{inboxBean.details}">
						<h:outputText value="Details" />
					</h:commandLink>
				</h:column>								
			</h:dataTable>
		</h:panelGrid>
	</h:form>
</body>
</html>
</f:view>