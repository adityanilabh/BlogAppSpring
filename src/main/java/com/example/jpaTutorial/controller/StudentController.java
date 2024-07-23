package com.example.jpaTutorial.controller;

import com.example.jpaTutorial.bean.Student;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @GetMapping(student)
    public Student getStudent(){
        Student student = new Student(
                1,
                 "Ramesh",
                "Fadatare"
        );
        return student;
    }
}
