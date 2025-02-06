package com.emre.springjpademo.controllers;

import com.emre.springjpademo.dtos.StudentDto;
import com.emre.springjpademo.dtos.StudentUIDto;
import com.emre.springjpademo.entities.Student;

import java.util.List;

public interface IStudentController {
    public StudentDto createStudent(StudentUIDto student);
    public void deleteStudent(Integer id);
    public StudentDto getStudentById(Integer id);
    public List<StudentDto> getAllStudents();
    public StudentDto updateStudent(Integer id,StudentUIDto student);
}
