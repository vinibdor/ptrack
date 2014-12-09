package br.org.vinicius.jsf.ptrack.web;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

public class Utils {

	public static void log(FacesContext facesContext, String message) {
		facesContext.getExternalContext().log(message);
	}

	public static void log(FacesContext facesContext, String message,
			Exception exception) {
		facesContext.getExternalContext().log(message, exception);
	}

	public static void reportError(FacesContext facesContext, String message,
			String detail, Exception exception) {
		facesContext.addMessage(null, new FacesMessage(
				FacesMessage.SEVERITY_ERROR, message, detail));
		if (exception != null) {
			facesContext.getExternalContext().log(message, exception);
		}
	}

	public static void log(ServletContext servletContext, String message) {
		servletContext.log(message);
	}

	protected static void addInvalidStateChangeMessage(FacesContext context,
			boolean approve) {
		String message;
		if (approve) {
			message = "You cannot approve a project with this status.";
		} else {
			message = "You cannot reject a project with this status.";
		}
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
				message, ""));
	}

}
