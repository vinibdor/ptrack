<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>

<f:loadBundle basename="ptrack-Resources" var="bundle"/>

<f:subview id="header">
	<h:form>
		<h:panelGrid columns="3" cellspacing="0" cellpadding="0"
			styleClass="header" width="100%">
			<h:panelGrid id="header" columns="9" cellpadding="4" cellspacing="0"
				border="0">

				<h:outputText value="#{bundle.AppNameHeader }:" styleClass="header-header" />
				<h:commandLink action="inbox" style="#{!authenticationBean.inboxAuthorized?'pointer-events: none; color: gray':''}">
					<h:graphicImage url="images/inbox.png" styleClass="header-icon" alt="Inbox" />
					<h:outputText value="#{bundle.InboxToolbarButton}" styleClass="header-command" />
				</h:commandLink>
				<h:commandLink action="show_all">
					<h:graphicImage url="images/show_all.gif" styleClass="header-icon" alt="Show all projects" />
					<h:outputText value="#{bundle.ShowAllToolbarButton}" styleClass="header-command" />
				</h:commandLink>
				<h:commandLink action="#{createProjectBean.create}"  style="#{!authenticationBean.createNewAuthorized?'pointer-events: none; color: gray':''}">
					<h:graphicImage url="images/create.png" styleClass="header-icon" alt="Create a new project" />
					<h:outputText value="#{bundle.CreateNewToolbarButton}" styleClass="header-command" />
				</h:commandLink>
				<h:commandLink action="#{authenticationBean.logout}">
					<h:graphicImage url="images/logout.png" styleClass="header-icon" alt="Logout" />
					<h:outputText value="#{bundle.LogoutToolbarButton}" styleClass="header-command" />
				</h:commandLink>
			</h:panelGrid>
			<h:panelGroup>
				<h:outputLabel for="languageSelect">
					<h:outputText value="#{bundle.LanguageCaption}:" styleClass="language-select" />
				</h:outputLabel>
				<h:selectOneListbox id="languageSelect" size="1"
					styleClass="language-select" value="#{visit.locale}">
					<f:selectItems value="#{visit.supportedLocaleItems}" />
					<f:selectItem value="#{visit.extraLocaleItem}"/>
				</h:selectOneListbox>
				<h:commandButton value="#{bundle.LanguageButton}" styleClass="language-select-button" />
			</h:panelGroup>
			<h:outputText value="#{visit.user.login}" styleClass="user-name" />
		</h:panelGrid>
	</h:form>
</f:subview>