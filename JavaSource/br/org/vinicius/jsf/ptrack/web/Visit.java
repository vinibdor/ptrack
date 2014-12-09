package br.org.vinicius.jsf.ptrack.web;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import javax.faces.application.Application;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import br.org.vinicius.jsf.ptrack.model.Project;
import br.org.vinicius.jsf.ptrack.model.User;

public class Visit {

	public Visit() {
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

	public String getLocale() {
		return FacesContext.getCurrentInstance().getViewRoot().getLocale().toString();
	}

	public void setLocale(String locale) {
		FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale(locale));
	}

	public List<SelectItem> getSupportedLocaleItems() {
		if (supportedLocaleItems == null) {
			supportedLocaleItems = new ArrayList<SelectItem>();
			Application app = FacesContext.getCurrentInstance()
					.getApplication();
			for (Iterator<?> i = app.getSupportedLocales(); i.hasNext();) {
				Locale locale = (Locale) i.next();
				SelectItem item = new SelectItem(locale.toString(),
						locale.getDisplayName());
				supportedLocaleItems.add(item);
			}
			if (supportedLocaleItems.size() == 0) {
				Locale defaultLocale = app.getDefaultLocale();
				supportedLocaleItems.add(new SelectItem(defaultLocale
						.toString(), defaultLocale.getDisplayName()));
			}
		}
		return supportedLocaleItems;
	}

	public SelectItem getExtraLocaleItem() {
		return new SelectItem("es", "Spanish");
	}

	public void setExtraLocaleItem(SelectItem extraLocaleItem) {
		this.extraLocaleItem = extraLocaleItem;
	}

	public AuthenticationBean getAuthenticationBean() {
		return authenticationBean;
	}

	public void setAuthenticationBean(AuthenticationBean authenticationBean) {
		this.authenticationBean = authenticationBean;
	}

	private User user;
	private Project currentProject;
	@SuppressWarnings("unused")
	private String locale;
	private List<SelectItem> supportedLocaleItems;
	@SuppressWarnings("unused")
	private SelectItem extraLocaleItem;
	private AuthenticationBean authenticationBean;
}