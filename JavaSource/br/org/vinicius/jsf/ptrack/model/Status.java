package br.org.vinicius.jsf.ptrack.model;

public class Status {
	
	public Status() {
		
	}
	
	public Status(String name, String role) {
		this.name = name;
		this.role = role;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

	private String name;
	private String role;

}
