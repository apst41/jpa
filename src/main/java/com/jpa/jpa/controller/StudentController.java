package com.jpa.jpa.controller;

import com.jpa.jpa.dao.StudentRepository;
import com.jpa.jpa.entity.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {
    private final StudentRepository repository;

    public StudentController(StudentRepository repository) {
        this.repository = repository;
    }

    @GetMapping("all")
    public List<Student> getSudent(){
      return  repository.findAll();
    }

    @GetMapping("{id}")
    public Student getStudent(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(StudentNotFoundException::new);
    }
    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return repository.save(student);
    }

    @PutMapping("{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
        Student studentToUpdate = repository.findById(id).orElseThrow(StudentNotFoundException::new);

        studentToUpdate.setFirstName(student.getFirstName());
        studentToUpdate.setLastName(student.getLastName());
        studentToUpdate.setYear(student.getYear());

        return repository.save(studentToUpdate);
    }

}
