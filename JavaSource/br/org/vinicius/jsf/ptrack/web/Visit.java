package br.org.vinicius.jsf.ptrack.web;

import java.util.List;

import javax.faces.model.SelectItem;

import br.org.vinicius.jsf.ptrack.model.Project;
import br.org.vinicius.jsf.ptrack.model.User;

public class Visit {

	public Visit() {
		if(supportedLocaleItems == null || supportedLocaleItems.isEmpty()) {
			supportedLocaleItems = new java.util.ArrayList<SelectItem>();
			supportedLocaleItems.add(new SelectItem("English"));
			supportedLocaleItems.add(new SelectItem("Russian"));
		}
		
		locale = this.getSupportedLocaleItems().get(0);
		
		user = new User();
		user.setLogin("Vinícius");
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Project getCurrentProject() {
		return currentProject;
	}
	public void setCurrentProject(Project currentProject) {
		this.currentProject = currentProject;
	}
	public SelectItem getLocale() {
		return locale;
	}
	public void setLocale(SelectItem locale) {
		this.locale = locale;
	}
	public List<SelectItem> getSupportedLocaleItems() {
		return supportedLocaleItems;
	}
	public void setSupportedLocaleItems(List<SelectItem> supportedLocaleItems) {
		this.supportedLocaleItems = supportedLocaleItems;
	}

	private User user;
	private Project currentProject;
	private SelectItem locale;
	private List<SelectItem> supportedLocaleItems;
	
}
