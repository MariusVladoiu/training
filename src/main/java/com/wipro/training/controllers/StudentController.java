package com.wipro.training.controllers;

import com.wipro.training.exception.StudentNotAvailableException;
import com.wipro.training.model.Student;
import com.wipro.training.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable String id) throws StudentNotAvailableException {
        Student student = studentService.getStudentById(id);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PostMapping(path = "/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        Student student1 = this.studentService.createStudent(student);
        return new ResponseEntity<>(student1, HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Student> deleteStudentById(@PathVariable String id) throws StudentNotAvailableException {
        Student deletedStudent = studentService.deleteStudentById(id);
        return new ResponseEntity<>(deletedStudent, HttpStatus.OK);
    }

    @PutMapping(path = "/update/{id}")
    public ResponseEntity<Student> updateStudentById(@PathVariable String id, @RequestBody Student newStudentData) throws StudentNotAvailableException {
        Student student = studentService.updateStudentById(id, newStudentData);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }


}
