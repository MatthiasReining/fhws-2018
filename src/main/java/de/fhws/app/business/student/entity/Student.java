package de.fhws.app.business.student.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@NamedQueries(@NamedQuery(name = Student.FIND_ALL, query = "SELECT student FROM Student student"))
@Entity
public class Student implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final String FIND_ALL = "Student.findAll";

	@Id
	@GeneratedValue
	private long id;

	@Size(max = 100)
	private String firstName;

	@NotNull
	@NotEmpty
	@Size(min = 2, max = 100)
	private String lastName;

	@Pattern(regexp = "\\w{2}\\d{4}")
	private String matriculationId;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "student_id")
	private List<ChangeLog> changeLogs = new ArrayList<>();

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

	public String getMatriculationId() {
		return matriculationId;
	}

	public void setMatriculationId(String matriculationId) {
		this.matriculationId = matriculationId;
	}

	public List<ChangeLog> getChangeLogs() {
		return changeLogs;
	}

	public void setChangeLogs(List<ChangeLog> changeLogs) {
		this.changeLogs = changeLogs;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", matriculationId="
				+ matriculationId + ", changeLogs=" + changeLogs + "]";
	}

}
