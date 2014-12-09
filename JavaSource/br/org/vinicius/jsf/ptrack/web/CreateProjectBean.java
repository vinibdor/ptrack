package br.org.vinicius.jsf.ptrack.web;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import org.jia.ptrack.domain.DataStoreException;

import br.org.vinicius.jsf.ptrack.model.Project;

public class CreateProjectBean extends BaseBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5046030387664029624L;

	public CreateProjectBean() {

	}

	public String create() {
		getVisit().setCurrentProject(new Project());
		return Constants.CREATE_OUTCOME;
	}

	public String add() {
		FacesContext facesContext = getFacesContext();
		Project project = getVisit().getCurrentProject();
		project.setInitialStatus(getStatusCoordinator().getInitialStatus());
		try {
			getProjectCoordinator().add(project);
		} catch (DataStoreException e) {
			Utils.reportError(facesContext, "A database error has occurred",
					"Error adding project", e);
			return Constants.ERROR_OUTCOME;
		}
		return Constants.SUCCESS_OUTCOME;
	}

	public void validateReqContact(FacesContext facesContext,
			UIComponent component, Object newValue) throws ValidatorException {
		if (reqContactEmailInput.getSubmittedValue().toString().equals("")) {
			facesContext.addMessage(
					reqContactEmailInput.getClientId(facesContext),
					new FacesMessage("Please fill in this field."));
			throw new ValidatorException(new FacesMessage(
					"E-mail address is required for the contact."));
		}
	}

	@SuppressWarnings("deprecation")
	public HtmlSelectOneMenu getProjectSelectOne() {
		if (projectSelectOne == null) {

			projectSelectOne = (HtmlSelectOneMenu) getApplication()
					.createComponent(HtmlSelectOneMenu.COMPONENT_TYPE);
			projectSelectOne.setId("typeSelectOne");
			projectSelectOne.setTitle("Select the project type");
			projectSelectOne.setRequired(true);
			projectSelectOne.setValueBinding("value", getApplication()
					.createValueBinding("#{visit.currentProject.type}"));
			projectSelectOne.setConverter(getApplication().createConverter(
					ProjectTypeConverter.CONVERTER_ID));
		}

		return projectSelectOne;
	}

	public void setProjectSelectOne(HtmlSelectOneMenu projectSelectOne) {
		this.projectSelectOne = projectSelectOne;
	}

	public UIInput getReqContactEmailInput() {
		return reqContactEmailInput;
	}

	public void setReqContactEmailInput(UIInput reqContactEmailInput) {
		this.reqContactEmailInput = reqContactEmailInput;
	}

	private HtmlSelectOneMenu projectSelectOne;
	private UIInput reqContactEmailInput;

}
