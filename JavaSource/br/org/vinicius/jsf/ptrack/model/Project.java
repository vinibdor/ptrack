package br.org.vinicius.jsf.ptrack.model;

import java.util.List;

import javax.faces.model.SelectItem;

public class Project {
	
	public Project() {
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getInitiatedBy() {
		return initiatedBy;
	}
	public void setInitiatedBy(String initiatedBy) {
		this.initiatedBy = initiatedBy;
	}
	public String getRequirementsContact() {
		return requirementsContact;
	}
	public void setRequirementsContact(String requirementsContact) {
		this.requirementsContact = requirementsContact;
	}
	public String getRequirementsContactEmail() {
		return requirementsContactEmail;
	}
	public void setRequirementsContactEmail(String requirementsContactEmail) {
		this.requirementsContactEmail = requirementsContactEmail;
	}
	public List<SelectItem> getCompletedArtifacts() {
		return completedArtifacts;
	}
	public void setCompletedArtifacts(List<SelectItem> completedArtifacts) {
		this.completedArtifacts = completedArtifacts;
	}
	public List<HistoryItem> getHistory() {
		return history;
	}
	public void setHistory(List<HistoryItem> history) {
		this.history = history;
	}	
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}	

	public String getInitialComments() {
		return initialComments;
	}
	public void setInitialComments(String initialComments) {
		this.initialComments = initialComments;
	}


	private Status status;
	private String name;
	private String type;
	private String initiatedBy;
	private String requirementsContact;
	private String requirementsContactEmail;
	private List<SelectItem> completedArtifacts;
	private List<HistoryItem> history;
	private String initialComments;
	

}
