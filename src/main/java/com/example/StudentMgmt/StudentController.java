package com.example.StudentMgmt;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class StudentController {

    private final StudentRepository repo;

    public StudentController(StudentRepository repo) {
        this.repo = repo;
    }

    // GET all students
    @GetMapping("/students")
    public List<Student> getStudents() {
        return repo.findAll();
    }

    // POST add student
    @PostMapping("/students")
    public String addStudent(@RequestBody Student student) {
        repo.save(student);
        return "Student added";
    }

    // DELETE by id
    @DeleteMapping("/students/{id}")
    public String deleteStudent(@PathVariable Long id) {
        repo.deleteById(id);
        return "Student deleted";
    }
}