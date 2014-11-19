<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>

<f:verbatim>
	<h:outputText value="Name:" />
	<h:outputText value="#{visit.currentProject.name}" styleClass="project-data" /><br/>
	<h:outputText value="Type:" />
	<h:outputText value="#{visit.currentProject.type}" styleClass="project-data" /><br/>
	<h:outputText value="Initiated by:" />
	<h:outputText value="#{visit.currentProject.initiatedBy}" styleClass="project-data" /><br/>
	<h:outputText value="Requirements contact:" />
	<h:outputText value="#{visit.currentProject.requirementsContact}" styleClass="project-data" /><br/>
	<h:outputText value="Requirements contact e-mail:" />
	<h:outputText value="#{visit.currentProject.requirementsContactEmail}" styleClass="project-data" /><br/>
	<h:outputText value="Initial comments:" />
	<h:outputText value="#{visit.currentProject.initialComments}"
			styleClass="project-data" />
</f:verbatim>