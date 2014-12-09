<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>

<f:verbatim>
	<h:outputLabel for="artifactSelect">
		<h:outputText value="Completed artifacts:" />
	</h:outputLabel>
	<h:selectManyCheckbox id="artifactSelect" layout="pageDirection"
			styleClass="project-input"
			value="#{visit.currentProject.completedArtifacts}"
			converter="ArtifactType">
			
		<f:selectItems value="#{selectItems.artifacts}" />
		
	</h:selectManyCheckbox>
</f:verbatim>