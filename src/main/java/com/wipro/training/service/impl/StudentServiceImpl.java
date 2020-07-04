package com.wipro.training.service.impl;

import com.wipro.training.exception.StudentNotAvailableException;
import com.wipro.training.model.Student;
import com.wipro.training.repository.StudentRepository;
import com.wipro.training.service.StudentService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository repository;

    @Override
    public Student createStudent(Student student) {
        return repository.save(student);
    }

    @Override
    public Student getStudentById(String id) throws StudentNotAvailableException {
        Optional<Student> studentOptional = repository.findById(new ObjectId(id));
        if(!studentOptional.isPresent()){
            throw new StudentNotAvailableException(id);
        }

        return studentOptional.get();
    }

    @Override
    public Student updateStudentById(String id, Student student) throws StudentNotAvailableException {
        Optional<Student> studentOptional = repository.findById(new ObjectId(id));
        if(studentOptional.isPresent()){
            Student availableStudent = studentOptional.get();
            updateStudentData(student, availableStudent);
            return repository.save(availableStudent);
        } else {
            throw new StudentNotAvailableException(id);
        }
    }

    private void updateStudentData(Student newStudentData, Student availableStudent) {
        availableStudent.setGrade(newStudentData.getGrade());
        availableStudent.setHeight(newStudentData.getHeight());
        availableStudent.setName(newStudentData.getName());
        availableStudent.setSurname(newStudentData.getSurname());
        availableStudent.setWeight(newStudentData.getWeight());
    }

    @Override
    public Student deleteStudentById(String id) throws StudentNotAvailableException {
        Optional<Student> studentToDelete = repository.findById(new ObjectId(id));

        if(studentToDelete.isPresent()){
            Student student = studentToDelete.get();
            repository.deleteById(new ObjectId(id));
            return student;
        } else {
            throw new StudentNotAvailableException(id);
        }
    }
}
