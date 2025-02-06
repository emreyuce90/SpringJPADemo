package com.emre.springjpademo.controllers.impl;

import com.emre.springjpademo.controllers.IStudentController;
import com.emre.springjpademo.entities.Student;
import com.emre.springjpademo.services.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @DeleteMapping("{id}")
    @Override
    public void deleteStudent(@PathVariable(name = "id")Integer id) {
        studentService.deleteStudent(id);
    }

    @GetMapping(path = "{id}")
    @Override
    public Student getStudentById(@PathVariable(name = "id") Integer id) {
        return studentService.getStudentById(id);
    }

    @GetMapping("")
    @Override
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }
}
