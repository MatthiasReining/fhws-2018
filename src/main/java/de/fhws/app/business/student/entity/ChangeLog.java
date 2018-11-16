package de.fhws.app.business.student.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;

@Entity
public class ChangeLog {

	@Id
	@GeneratedValue
	private Long id;

	private Date modifiedTime;
	private String action;

	@ManyToOne
	private Student student;
	
	@PrePersist
	public void prepareSave() {
		modifiedTime = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "ChangeLog [id=" + id + ", modifiedTime=" + modifiedTime + ", action=" + action + "]";
	}

}
