package br.org.vinicius.jsf.ptrack.web;

import java.util.ArrayList;
import java.util.List;

import javax.faces.FacesException;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIData;
import javax.faces.component.UIParameter;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.jia.ptrack.domain.DataStoreException;
import org.jia.ptrack.domain.ObjectNotFoundException;
import org.jia.ptrack.domain.ProjectColumnType;

import br.org.vinicius.jsf.ptrack.model.EnumeratedType;
import br.org.vinicius.jsf.ptrack.model.Project;

class CommandType extends EnumeratedType {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5598518104138479822L;

	public final static CommandType APPROVE = new CommandType(0, "Approve");
	public final static CommandType REJECT = new CommandType(10, "Reject");
	public final static CommandType DETAILS = new CommandType(20, "Details");

	private CommandType(int value, String description) {
		super(value, description);
	}
}

public class SelectProjectBean extends BaseBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5855457994328244217L;

	public SelectProjectBean() {
	}

	public UIData getProjectTable() {
		return projectTable;
	}

	public void setProjectTable(UIData projectTable) {
		this.projectTable = projectTable;
	}

	public List getInboxProjects() throws DataStoreException {
		try {
			return getProjectCoordinator().getProjects(
					getVisit().getUser().getRole(), sortColumn);
		} catch (ObjectNotFoundException e) {
			return new ArrayList(0);
		}
	}

	public List getAllProjects() throws DataStoreException {
		try {
			return getProjectCoordinator().getProjects(sortColumn);
		} catch (ObjectNotFoundException e) {
			return new ArrayList(0);
		}
	}

	public void sort(ActionEvent actionEvent) {
		boolean paramFound = false;
		List children = actionEvent.getComponent().getChildren();
		for (int i = 0; i < children.size(); i++) {
			if (children.get(i) instanceof UIParameter) {
				UIParameter currentParam = (UIParameter) children.get(i);
				if (currentParam.getName().equals("column")
						&& currentParam.getValue() != null) {
					String paramValue = currentParam.getValue().toString();
					sortColumn = (ProjectColumnType) ProjectColumnType
							.getEnumManager().getInstance(paramValue);
					paramFound = true;
					break;
				}
			}
		}
		if (!paramFound) {
			throw new FacesException(
					"Expected child UIParameter with "
							+ "name 'column' and a value equal to the column name to sort.");
		}
	}

	protected String getProject(CommandType command) {
		FacesContext facesContext = getFacesContext();
		Project project = (Project) projectTable.getRowData();
		try {
			project = getProjectCoordinator().get(project.getId());
		} catch (ObjectNotFoundException e) {
			facesContext.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_WARN,
					"The project you selected cannot be found",
					"The project is no longer in the data store."));
			return Constants.FAILURE_OUTCOME;
		} catch (DataStoreException d) {
			Utils.reportError(facesContext, "A database error has occrred",
					"Error loading project", d);
			return Constants.ERROR_OUTCOME;
		}
		if (command == CommandType.APPROVE || command == CommandType.REJECT) {
			if (!getStatusCoordinator().isValidStateChange(project.getStatus(),
					command == CommandType.APPROVE)) {
				Utils.addInvalidStateChangeMessage(facesContext,
						command == CommandType.APPROVE);
				return Constants.FAILURE_OUTCOME;
			}
		}
		getVisit().setCurrentProject(project);
		return Constants.SUCCESS_OUTCOME;
	}

	public String approve() {
		return getProject(CommandType.APPROVE);
	}

	public String reject() {
		return getProject(CommandType.REJECT);
	}

	public String details() {
		return getProject(CommandType.DETAILS);
	}

	private UIData projectTable;
	private ProjectColumnType sortColumn;
}
