package com.example.StudentMgmt;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

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
    public String deleteStudent(@PathVariable UUID id) {
        repo.deleteById(id);
        return "Student deleted";
    }

    // UPDATE by id
    @PatchMapping("/students/{id}")
    public Student updateStudent(@PathVariable UUID id, @RequestBody Student updatedStudent) {
        Student s = repo.findById(id).orElseThrow();
        if (updatedStudent.getName() != null) {
            s.setName(updatedStudent.getName());
        }
        if (updatedStudent.getEmail() != null) {
            s.setEmail(updatedStudent.getEmail());
        }
        return repo.save(s);
    }
}