package br.org.vinicius.jsf.ptrack.web;

import javax.faces.application.Application;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.org.vinicius.jsf.ptrack.model.RoleType;
import br.org.vinicius.jsf.ptrack.model.User;

public class AuthenticationBean extends BaseBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7935463407523495395L;

	public AuthenticationBean() {

	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isCreateNewAuthorized() {
		return getVisit().getUser().getRole().equals(RoleType.PROJECT_MANAGER);
	}

	public boolean isInboxAuthorized() {
		return !getVisit().getUser().getRole().equals(RoleType.UPPER_MANAGER);
	}

	public String login() {

		FacesContext facesContext = getFacesContext();
		User newUser = null;
		try {
			//newUser = getUserCoordinator().getUser(login, password);
			newUser = new User();
			newUser.setFirstName("Vinícius");
			newUser.setLastName("Ramos");
			newUser.setLogin("vinibdr");			
		}/* catch (ObjectNotFoundException e) {
			facesContext.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_WARN, "Incorrect name or password.",
					""));
			return Constants.FAILURE_OUTCOME;
		} catch (DataStoreException d) {
			Utils.reportError(facesContext, "A database error has occurred.",
					"Error loading User object", d);
			return Constants.ERROR_OUTCOME;
		}*/ finally {
			
		}

		Visit visit = new Visit();		
		visit.setUser(newUser);		
		visit.setAuthenticationBean(this);
		
		Application app = facesContext.getApplication();
		app.createValueBinding("#{"+Constants.VISIT_KEY_SCOPE+Constants.VISIT_KEY+"}").setValue(facesContext,
				visit);
		
		if(newUser.getRole().equals(RoleType.UPPER_MANAGER)) {
			return Constants.SUCCESS_READONLY_OUTCOME;
		}

		return Constants.SUCCESS_READWRITE_OUTCOME;
	}

	public String logout() {
		
		FacesContext facesContext = getFacesContext();
		
		HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
		
		if(session != null) {
			session.removeAttribute(Constants.VISIT_KEY_SCOPE+Constants.VISIT_KEY);
			session.invalidate();
		} 
		
		return Constants.SUCCESS_OUTCOME;
	}

	public boolean isReadOnly() {
		return getVisit().getUser().getRole().equals(RoleType.UPPER_MANAGER);
	}

	private String login;
	private String password;
	
}
