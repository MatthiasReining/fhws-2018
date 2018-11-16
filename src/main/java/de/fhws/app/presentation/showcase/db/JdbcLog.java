package de.fhws.app.presentation.showcase.db;

import java.util.Date;

public class JdbcLog implements DBObject {

	private Date logtime;
	private String comment;

	public JdbcLog() {
	}

	public JdbcLog(Date logtime, String comment) {
		super();
		this.logtime = logtime;
		this.comment = comment;
	}

	public Date getLogtime() {
		return logtime;
	}

	public void setLogtime(Date logtime) {
		this.logtime = logtime;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
