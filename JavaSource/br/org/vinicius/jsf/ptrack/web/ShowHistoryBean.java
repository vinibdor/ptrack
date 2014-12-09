package br.org.vinicius.jsf.ptrack.web;

import java.util.List;

import javax.faces.component.html.HtmlDataTable;

import br.org.vinicius.jsf.ptrack.model.HistoryItem;

public class ShowHistoryBean {
		
	public ShowHistoryBean() {
		
	}
	
	public String next() {
		return "";
	}
	
	public String previous() {
		return "";
	}
	
	public String cancel() {
		return "";
	}
	
	public HtmlDataTable getHistoryDataTable() {
		return historyDataTable;
	}
	public void setHistoryDataTable(HtmlDataTable historyDataTable) {
		this.historyDataTable = historyDataTable;
	}
	public List<HistoryItem> getCurrentProjectHistory() {
		return currentProjectHistory;
	}
	public void setCurrentProjectHistory(List<HistoryItem> currentProjectHistory) {
		this.currentProjectHistory = currentProjectHistory;
	}
	public int getFirstRow() {
		return firstRow;
	}
	public void setFirstRow(int firstRow) {
		this.firstRow = firstRow;
	}
	public int getRowsToDisplay() {
		return rowsToDisplay;
	}
	public void setRowsToDisplay(int rowsToDisplay) {
		this.rowsToDisplay = rowsToDisplay;
	}
	
	public boolean isShowNext() {
		return showNext;
	}

	public void setShowNext(boolean showNext) {
		this.showNext = showNext;
	}

	public boolean isShowPrevious() {
		return showPrevious;
	}

	public void setShowPrevious(boolean showPrevious) {
		this.showPrevious = showPrevious;
	}

	private HtmlDataTable historyDataTable;
	private List<HistoryItem> currentProjectHistory;
	private int firstRow;
	private int rowsToDisplay;
	private boolean showNext;
	private boolean showPrevious;

}
