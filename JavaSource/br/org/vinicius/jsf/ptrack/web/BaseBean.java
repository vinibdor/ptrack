package br.org.vinicius.jsf.ptrack.web;

import java.io.Serializable;

import javax.faces.context.FacesContext;

import br.org.vinicius.jsf.ptrack.model.IProjectCoordinator;
import br.org.vinicius.jsf.ptrack.model.IStatusCoordinator;
import br.org.vinicius.jsf.ptrack.model.IUserCoordinator;

public class BaseBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4088506174300675058L;

	// Faces objects
	public FacesContext getFacesContext() {
		return FacesContext.getCurrentInstance();
	}

	public javax.faces.application.Application getApplication() {
		return getFacesContext().getApplication();
	}

	// Common action methods
	public String cancel() {
		if (getVisit().getAuthenticationBean().isReadOnly()) {
			return Constants.CANCEL_READONLY_OUTCOME;
		} else {
			return Constants.CANCEL_READWRITE_OUTCOME;
		}
	}

	// Application objects
	public Visit getVisit() {
		return visit;
	}

	public void setVisit(Visit visit) {
		this.visit = visit;
	}

	public IProjectCoordinator getProjectCoordinator() {
		return projectCoordinator;
	}

	public void setProjectCoordinator(IProjectCoordinator projectCoordinator) {
		this.projectCoordinator = projectCoordinator;
	}

	public IStatusCoordinator getStatusCoordinator() {
		return statusCoordinator;
	}

	public void setStatusCoordinator(IStatusCoordinator statusCoordinator) {
		this.statusCoordinator = statusCoordinator;
	}

	public IUserCoordinator getUserCoordinator() {
		return userCoordinator;
	}

	public void setUserCoordinator(IUserCoordinator userCoordinator) {
		this.userCoordinator = userCoordinator;
	}

	private Visit visit;
	private IProjectCoordinator projectCoordinator;
	private IStatusCoordinator statusCoordinator;
	private IUserCoordinator userCoordinator;

}
