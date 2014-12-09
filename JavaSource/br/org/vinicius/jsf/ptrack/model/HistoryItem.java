package br.org.vinicius.jsf.ptrack.model;

import java.util.Date;
public class HistoryItem {

	public HistoryItem() {
		
	}
	
	public Date getChangeDate() {
		return changeDate;
	}
	public void setChangeDate(Date changeDate) {
		this.changeDate = changeDate;
	}
	public String getFromStatus() {
		return fromStatus;
	}
	public void setFromStatus(String fromStatus) {
		this.fromStatus = fromStatus;
	}
	public String getToStatus() {
		return toStatus;
	}
	public void setToStatus(String toStatus) {
		this.toStatus = toStatus;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}

	private Date changeDate;
	private String fromStatus;
	private String toStatus;
	private User user;
	private String comments;
	
}
