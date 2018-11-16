package de.fhws.app.business.student.boundary;

import de.fhws.app.business.student.entity.Student;

public interface StudentWSRemote {

	Student getStudent(long id);

}