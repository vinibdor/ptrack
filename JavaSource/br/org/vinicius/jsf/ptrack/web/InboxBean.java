package br.org.vinicius.jsf.ptrack.web;

import java.util.ArrayList;
import java.util.List;

import javax.faces.component.html.HtmlDataTable;

import br.org.vinicius.jsf.ptrack.model.Project;
import br.org.vinicius.jsf.ptrack.model.Status;

public class InboxBean extends BaseBean {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3425998537589689608L;
	
	public InboxBean() {
		
		Project projectA = new Project();
		projectA.setName("Inventory Manager v2.0");
		projectA.setType("Internal Desktop Application");
		
		projectA.setStatus(new Status("Requirements/Analysis", "System Analyst"));
		projectA.setInitiatedBy("Rip Van Winkle");
		
		Project projectB = new Project();
		projectB.setName("Time Tracker");
		projectB.setType("Internal Web Application");
		projectB.setStatus(new Status("Proposal", "Project Manager"));
		projectB.setInitiatedBy("Vinícius Botelho");
			
		inboxProjects = new ArrayList<Project>();
		
		inboxProjects.add(projectA);
		inboxProjects.add(projectB);
		
	}
	
	public String approve() {
		return "success";
	}
	
	public String reject() {
		return "success";
	}
	
	public String details() {
		return "success";
	}
	
	public String cancel() {
		return "cancel_readwrite";
	}
	
	public void sort() {
		
	}
	
	public HtmlDataTable getProjectTable() {
		return projectTable;
	}

	public void setProjectTable(HtmlDataTable projectTable) {
		this.projectTable = projectTable;
	}

	public List<Project> getInboxProjects() {
		return inboxProjects;
	}

	public void setInboxProjects(List<Project> inboxProjects) {
		this.inboxProjects = inboxProjects;
	}

	public List<Project> getAllProjects() {
		return allProjects;
	}

	public void setAllProjects(List<Project> allProjects) {
		this.allProjects = allProjects;
	}

	private HtmlDataTable projectTable;
	private List<Project> inboxProjects;
	private List<Project> allProjects;

}
