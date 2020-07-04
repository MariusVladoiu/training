package com.wipro.training.service;

import com.wipro.training.exception.StudentNotAvailableException;
import com.wipro.training.model.Student;

public interface StudentService {

    Student createStudent(Student student);
    Student getStudentById(String id) throws StudentNotAvailableException;
    Student updateStudentById(String id, Student student) throws StudentNotAvailableException;
    Student deleteStudentById(String id) throws StudentNotAvailableException;
}
