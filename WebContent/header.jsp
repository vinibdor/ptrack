<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>

<f:subview id="header">
	<h:form>
		<h:panelGrid columns="3" cellspacing="0" cellpadding="0"
			styleClass="header" width="100%">
			<h:panelGrid id="header" columns="9" cellpadding="4" cellspacing="0"
				border="0">

				<h:outputText value="ProjectTrack:" styleClass="header-header" />
				<h:commandLink action="inbox">
					<h:graphicImage url="images/inbox.gif" styleClass="header-icon"
						alt="Inbox" />
					<h:outputText value="Inbox" styleClass="header-command" />
				</h:commandLink>
				<h:commandLink action="show_all">
					<h:graphicImage url="images/show_all.gif" styleClass="header-icon"
						alt="Show all projects" />
					<h:outputText value="Show all" styleClass="header-command" />
				</h:commandLink>
				<h:commandLink action="create">
					<h:graphicImage url="images/create.gif" styleClass="header-icon"
						alt="Create a new project" />
					<h:outputText value="Create new" styleClass="header-command" />
				</h:commandLink>
				<h:commandLink action="logout">
					<h:graphicImage url="images/logout.gif" styleClass="header-icon"
						alt="Logout" />
					<h:outputText value="Logout" styleClass="header-command" />
				</h:commandLink>
			</h:panelGrid>
			<h:panelGroup>
				<h:outputLabel for="languageSelect">
					<h:outputText value="Language:" styleClass="language-select" />
				</h:outputLabel>
				<h:selectOneListbox id="languageSelect" size="1"
					styleClass="language-select">
					<f:selectItem itemLabel="English" itemValue="English" />
					<f:selectItem itemLabel="Russian" itemValue="Russian" />
				</h:selectOneListbox>
				<h:commandButton value="Go!" styleClass="language-select-button" />
			</h:panelGroup>
			<h:outputText value="proj_mgr" styleClass="user-name" />
		</h:panelGrid>
	</h:form>
</f:subview>