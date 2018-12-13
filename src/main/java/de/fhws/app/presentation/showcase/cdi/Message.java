package de.fhws.app.presentation.showcase.cdi;

import java.io.Serializable;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;

@RequestScoped
public class Message implements Serializable {

	private static final long serialVersionUID = 1L;
	private String message;
	private Date createdAt;

	@PostConstruct
	void init() {
		System.out.println("in PostConstruct#init");
		createdAt = new Date();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "Message [message=" + message + ", createdAt=" + createdAt + "]";
	}

}
