package de.fhws.app.business.student.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@NamedQueries(@NamedQuery(name = Student.FIND_ALL, query = "SELECT student FROM Student student"))
@Entity
public class Student implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public static final String FIND_ALL = "Student.findAll";

	@Id
	@GeneratedValue
	private long id;

	private String firstName;

	@NotNull
	@NotEmpty
	private String lastName;
	private String studentId;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

}
