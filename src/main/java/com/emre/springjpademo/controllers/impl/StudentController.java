package com.emre.springjpademo.controllers.impl;

import com.emre.springjpademo.controllers.IStudentController;
import com.emre.springjpademo.entities.Student;
import com.emre.springjpademo.services.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(path = "/api/students")
@RestController
public class StudentController implements IStudentController {

    @Autowired
    private IStudentService studentService;

    @PostMapping(path = "")
    @Override
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }
}
