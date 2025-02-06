package com.emre.springjpademo.controllers;

import com.emre.springjpademo.entities.Student;

import java.util.List;

public interface IStudentController {
    public Student createStudent(Student student);
    public void deleteStudent(Integer id);
    public Student getStudentById(Integer id);
    public List<Student> getAllStudents();
}
