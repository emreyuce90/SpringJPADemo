package com.emre.springjpademo.controllers.impl;

import com.emre.springjpademo.controllers.IStudentController;
import com.emre.springjpademo.dtos.StudentDto;
import com.emre.springjpademo.dtos.StudentUIDto;
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
    public StudentDto createStudent(@RequestBody StudentUIDto student) {
        return studentService.createStudent(student);
    }

    @DeleteMapping("{id}")
    @Override
    public void deleteStudent(@PathVariable(name="id") Integer id) {
        studentService.deleteStudent(id);
    }

    @GetMapping("{id}")
    @Override
    public StudentDto getStudentById(@PathVariable(name = "id") Integer id) {
        return studentService.getStudentById(id);
    }

    @GetMapping(path = "")
    @Override
    public List<StudentDto> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PutMapping(path = "{id}")
    @Override
    public StudentDto updateStudent(@PathVariable(name = "id") Integer id,@RequestBody StudentUIDto student) {
        return studentService.updateStudent(id, student);
    }
}
