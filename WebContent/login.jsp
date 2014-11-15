<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>

<f:view>
	<html>
<head>
	<title><h:outputText value="ProjectTrack"></h:outputText></title>
	<script language="JavaScript">
		function set_image(button, img) {
			button.src = img;
		}
	</script>
	<link rel="stylesheet" type="text/css" href="stylesheet.css" />
</head>
<body>
	<h:form>				
		<h:panelGrid columns="2" border="0" cellpadding="3" cellspacing="3">
		
			<h:graphicImage alt="Welcome to ProjectTrack" height="160"
					title="Welcome to ProjectTrack" width="149" url="/images/logo.png"></h:graphicImage>
			
			<h:panelGrid columns="3" border="0" cellpadding="5"  cellspacing="3" headerClass="login-heading">

				<f:facet name="header">
					<h:outputText value="ProjectTrack" />
				</f:facet>
				
				<h:outputLabel for="userNameInput">
					<h:outputText value="Enter your user name:"></h:outputText>
				</h:outputLabel>
				
				<h:inputText id="userNameInput" maxlength="30" size="20" required="true">
					<f:validateLength minimum="5" maximum="30"/>
				</h:inputText>
				
				<h:message for="userNameInput" styleClass="errors" />
				
				<h:outputLabel for="passwordInput">
					<h:outputText value="Password:"></h:outputText>
				</h:outputLabel>
				
				<h:inputSecret id="passwordInput" maxlength="20" size="20" required="true">
					<f:validateLength minimum="5" maximum="15"/>
				</h:inputSecret>
					
				<h:message for="passwordInput" styleClass="errors"/>
				
				<h:panelGroup/>
				
				<h:commandButton action="success"
						image="/images/button.jpg" style="width:80px;height:20px;"
						onmouseover="set_image(this, '#{facesContext.externalContext.requestContextPath}/images/button_over.jpg')"
						onmouseout="set_image(this, '#{facesContext.externalContext.requestContextPath}/images/button.jpg')"></h:commandButton>
						
				<h:panelGroup/>
				
			</h:panelGrid>
		</h:panelGrid>
	</h:form>
</body>
</html>
</f:view>