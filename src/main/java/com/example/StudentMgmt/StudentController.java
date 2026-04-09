package com.example.StudentMgmt;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello Student API";
    }
}