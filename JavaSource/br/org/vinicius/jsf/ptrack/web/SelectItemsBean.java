package br.org.vinicius.jsf.ptrack.web;

import java.util.List;

import javax.faces.model.SelectItem;

import br.org.vinicius.jsf.ptrack.model.RoleType;

public class SelectItemsBean {
	
	public SelectItemsBean() {
		SelectItem artifactA = new SelectItem();
		artifactA.setValue("Project Plan");
		
		SelectItem artifactB =  new SelectItem();
		artifactB.setValue("Proposal Document");
		
		SelectItem artifactC = new SelectItem();
		artifactC.setValue("Test Plan");
		
		SelectItem roleA = new SelectItem();
		roleA.setLabel("Project Manager");
		
		RoleType pmRole = new RoleType();
		pmRole.setType("Project Manager");		
		roleA.setValue(pmRole);
		
		SelectItem roleB = new SelectItem();
		roleB.setLabel("System Analyst");
		
		RoleType saRole = new RoleType();
		saRole.setType("System Analyst");
		roleB.setValue(roleB);
		
		SelectItem pTypeA = new SelectItem();
		pTypeA.setValue("Internal Web Application");
		
		SelectItem pTypeB = new SelectItem();
		pTypeB.setValue("Internal Desktop Application");
	}
	
	public List<SelectItem> getArtifacts() {
		return artifacts;
	}
	public void setArtifacts(List<SelectItem> artifacts) {
		this.artifacts = artifacts;
	}
	public List<SelectItem> getProjectTypes() {
		return projectTypes;
	}
	public void setProjectTypes(List<SelectItem> projectTypes) {
		this.projectTypes = projectTypes;
	}
	public List<SelectItem> getRoles() {
		return roles;
	}
	public void setRoles(List<SelectItem> roles) {
		this.roles = roles;
	}

	private List<SelectItem> artifacts;
	private List<SelectItem> projectTypes;
	private List<SelectItem> roles;

}
