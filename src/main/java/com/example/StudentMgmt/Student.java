package com.example.StudentMgmt;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
public class Student {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;
    private String email;

    public Student() {}

    public Student(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}