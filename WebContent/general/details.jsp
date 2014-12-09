<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>

<f:view>
	<html>
<head>
<title><h:outputText value="ProjectTrack - Project details" /></title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/stylesheet.css" />
</head>
<body class="page-background">
	<jsp:include page="/includes/header.jsp" />
	<h:form>
		<h:panelGrid id="projectPanel" columns="1" cellpadding="5"
			footerClass="project-background" columnClasses="project-data"
			styleClass="project-background" rowClasses="project-row">
			<f:facet name="header">
				<h:panelGrid columns="1" width="100%" cellpadding="3"
					styleClass="project-background" rowClasses="page-header">
					<h:outputText value="Project details" />
				</h:panelGrid>
			</f:facet>
			<%@ include file="/includes/project_info.jsp"%>
			<h:outputText value="Completed artifacts:" />
			<h:dataTable rowClasses="project-data" 
					value="#{visit.currentProject.completedArtifacts}" var="artifact" 
					cellpadding="0" cellspacing="0">
				
				<h:column>
					<h:outputText value="#{artifact}" />
				</h:column>
				
			</h:dataTable>
			<f:facet name="footer">
				<h:panelGroup>
					<h:dataTable value="#{visit.currentProject.history}" var="operation"   
							binding="#{showHistoryBean.historyDataTable}" rows="#{showHistoryBean.rowsToDisplay}"
							cellpadding="5" styleClass="table-background">
						<f:facet name="header">
							<h:outputText value="History" styleClass="table-header" />
						</f:facet>
						<h:panelGrid columns="1" width="100%" border="1"
							styleClass="table-even-row">
							<h:panelGrid columns="3" cellpadding="7"
								styleClass="table-even-row">
								<h:outputText value="#{operation.changeDate}">
									<f:convertDateTime dateStyle="full" timeStyle="short"/>
								</h:outputText>
								<h:outputText value="#{operation.fromStatus} -> #{operation.toStatus}" />
								<h:outputText value="#{operation.user.role.type}" />
							</h:panelGrid>
							<h:panelGrid columns="1" cellpadding="3"
								styleClass="table-odd-row" width="100%">
								<h:outputText value="Comments:" />
								<h:outputText value="#{operation.comments}"
									styleClass="project-data" />
							</h:panelGrid>
						</h:panelGrid>
						<f:facet name="footer">
							<h:panelGroup>
							<h:commandLink action="#{showHistoryBean.previous}" rendered="#{showHistoryBean.showPrevious}"
										style="padding-right: 5px;">
								<h:outputText value="Previous"/>
							</h:commandLink>
							<h:commandLink action="#{showHistoryBean.next}"
									rendered="#{showHistoryBean.showNext}">
								<h:outputText value="Next"/>
							</h:commandLink>
							</h:panelGroup>
						</f:facet>
					</h:dataTable>					
					<h:commandButton value="OK" action="#{showHistoryBean.cancel}" style="margin-top: 5px" immediate="true"/>					
				</h:panelGroup>
			</f:facet>
		</h:panelGrid>
	</h:form>
</body>
	</html>
</f:view>
