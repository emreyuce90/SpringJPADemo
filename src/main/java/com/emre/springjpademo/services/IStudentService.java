package com.emre.springjpademo.services;

import com.emre.springjpademo.dtos.StudentDto;
import com.emre.springjpademo.dtos.StudentUIDto;

import java.util.List;


public interface IStudentService {
    public StudentDto createStudent(StudentUIDto student);
    public void deleteStudent(Integer id);
    public StudentDto getStudentById(Integer id);
    public List<StudentDto> getAllStudents();
    public StudentDto updateStudent(Integer id,StudentUIDto student);
}
