<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>

<f:view>
<html>
	<head>
		<title><h:outputText value="ProjectTrack"></h:outputText></title>
		<script language="JavaScript">
			function set_image(button, img) {
				button.src=img;
			}
		</script>
	</head>
	<body>
		<h:form>
		<table>
			<tr>
				<td><h:graphicImage alt="Welcome to ProjectTrack" height="160" title="Welcome to ProjectTrack" width="149" url="/images/logo.png"></h:graphicImage></td>
				<td>
					<table>
						<tr><td><font face="Arial, sans-serif" size="6"></font><h:outputText value="ProjectTrack"></h:outputText></td></tr>
						<tr>
							<td><h:outputLabel for="userNameInput"><h:outputText value="Enter your user name:"></h:outputText></h:outputLabel></td>
							<td><h:inputText id="userNameInput" maxlength="30" size="20"></h:inputText></td>
						</tr>
						<tr>
							<td><h:outputLabel for="passwordInput"><h:outputText value="Password:"></h:outputText></h:outputLabel></td>
							<td><h:inputSecret id="passwordInput" maxlength="20" size="20"></h:inputSecret></td>
						</tr>
						<tr>
							<td><h:commandButton action="success" image="/images/button.jpg" style="width:80px;height:20px;"
									onmouseover="set_image(this, '#{facesContext.externalContext.requestContextPath}/images/button_over.jpg')"
									onmouseout="set_image(this, '#{facesContext.externalContext.requestContextPath}/images/button.jpg')"></h:commandButton></td>
						</tr>
					</table>
				</td>				
			</tr>
		</table>
		</h:form>		
	</body>
</html>
</f:view>