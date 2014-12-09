package br.org.vinicius.jsf.ptrack.web;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.jia.ptrack.domain.DataStoreException;
import org.jia.ptrack.domain.ObjectNotFoundException;

import br.org.vinicius.jsf.ptrack.model.Project;

public class UpdateProjectBean extends BaseBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8492811906703500418L;

	public UpdateProjectBean() {

	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	protected String update(boolean approve) {
		FacesContext facesContext = getFacesContext();
		Visit visit = getVisit();
		boolean projectFound = true;
		Project project = visit.getCurrentProject();
		if (project.changeStatus(approve, getVisit().getUser(), comments)) {
			try {
				getProjectCoordinator().update(project);
			} catch (ObjectNotFoundException e) {
				projectFound = false;
			} catch (DataStoreException d)

			{
				Utils.reportError(facesContext,
						"A database error has occurred.",
						"Error updating project.", d);
				return Constants.ERROR_OUTCOME;
			}
		} else {
			Utils.addInvalidStateChangeMessage(facesContext, approve);
			return Constants.FAILURE_OUTCOME;
		}

		if (projectFound == false) {
			facesContext.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_WARN,
					"The project you selected cannot be found",
					"The project is no longer in the data store."));
			return Constants.FAILURE_OUTCOME;
		}
		if (visit.getAuthenticationBean().isReadOnly()) {
			return Constants.SUCCESS_READONLY_OUTCOME;
		} else {
			return Constants.SUCCESS_READWRITE_OUTCOME;
		}
	}

	public String approve() {
		return update(true);
	}

	public String reject() {
		return update(false);
	}

	private String comments;

}
