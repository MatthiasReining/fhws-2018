package de.fhws.app.business.log.enitity;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class LogMessage {

	@GeneratedValue
	@Id
	private long id;

	private String message;
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;

	@PostConstruct
	@PrePersist
	void init() {
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "LogMessage [id=" + id + ", message=" + message + ", createdAt=" + createdAt + "]";
	}

}
