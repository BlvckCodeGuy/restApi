package com.samozwanczehelikoptry.restApi.controller;

import com.samozwanczehelikoptry.restApi.exception.ResourceNotFoundException;
import com.samozwanczehelikoptry.restApi.model.Student;
import com.samozwanczehelikoptry.restApi.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("/student")
    public Student addStudent(@RequestBody Student student)
    {
        return studentRepository.save(student);
    }

    @PostMapping("/students")
    public ResponseEntity<List<Student>> findAll()
    {
        return ResponseEntity.ok(studentRepository.findAll());
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<Student> findStudentById(@PathVariable(value = "id") Integer id)
    {
        Student student = studentRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Student not found: " + id));

        return ResponseEntity.ok().body(student);
    }

    @DeleteMapping("/student/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable(value = "id") Integer id) {

        Student student = studentRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Student not found: " + id));

        studentRepository.delete(student);

        return ResponseEntity.ok().build();
    }
}
