package io.hitesh.learning.demo.controller;

import io.hitesh.learning.demo.entities.Student;
import io.hitesh.learning.demo.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {
    private StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping("/student")
    public List<Student> getAllStudent(){
        return service.finAll();
    }
}
