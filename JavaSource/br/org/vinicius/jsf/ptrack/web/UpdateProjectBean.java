package br.org.vinicius.jsf.ptrack.web;

import java.util.List;

import javax.faces.model.SelectItem;

public class UpdateProjectBean {
	
	public UpdateProjectBean() {
		
	}
	
	public String approve() {
		return "approve";
	}
	
	public String reject() {
		return "success";
	}
	
	public String cancel() {
		return "cancel_readonly";
	}
	
	public List<SelectItem> getComments() {
		return comments;
	}

	public void setComments(List<SelectItem> comments) {
		this.comments = comments;
	}	

	private List<SelectItem> comments; 

}
