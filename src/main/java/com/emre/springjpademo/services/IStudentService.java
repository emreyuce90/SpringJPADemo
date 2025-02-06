package com.emre.springjpademo.services;

import com.emre.springjpademo.entities.Student;

import java.util.List;


public interface IStudentService {
    public Student createStudent(Student student);
    public void deleteStudent(Integer id);
    public Student getStudentById(Integer id);
    public List<Student> getAllStudents();
}
