package br.org.vinicius.jsf.ptrack.web;

public class AuthenticationBean {
	
	public AuthenticationBean() {
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
		return createNewAuthorized;
	}
	public void setCreateNewAuthorized(boolean createNewAuthorized) {
		this.createNewAuthorized = createNewAuthorized;
	}
	public boolean isInboxAuthorized() {
		return inboxAuthorized;
	}
	public void setInboxAuthorized(boolean inboxAuthorized) {
		this.inboxAuthorized = inboxAuthorized;
	}
	
	public String login() {
		return "success_readwrite";
	}
	
	public String logout() {
		return "";
	}

	private String name;
	private String login;
	private String password;
	private boolean createNewAuthorized;
	private boolean inboxAuthorized = true;

}
