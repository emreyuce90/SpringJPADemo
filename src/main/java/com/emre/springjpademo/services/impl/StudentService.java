package com.emre.springjpademo.services.impl;


import com.emre.springjpademo.dtos.StudentDto;
import com.emre.springjpademo.dtos.StudentUIDto;
import com.emre.springjpademo.entities.Student;
import com.emre.springjpademo.repositories.IStudentRepository;
import com.emre.springjpademo.services.IStudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService implements IStudentService {

    @Autowired
   private IStudentRepository studentRepository;


    @Override
    public StudentDto createStudent(StudentUIDto studentUIDto) {
        StudentDto studentDto = new StudentDto();
        Student student = new Student();
        BeanUtils.copyProperties(studentUIDto, student);
        Student dbStudent = studentRepository.save(student);
        BeanUtils.copyProperties(dbStudent, studentDto);
        return studentDto;
    }

    @Override
    public void deleteStudent(Integer id) {
        Optional<Student> optional = studentRepository.findById(id);
        if (optional.isPresent()) {
            studentRepository.delete(optional.get());
        }
    }

    @Override
    public StudentDto getStudentById(Integer id) {
        StudentDto studentDto = new StudentDto();
      Optional<Student> studentDb = Optional.ofNullable(studentRepository.getStudentById(id));
      if (studentDb.isPresent()) {
          BeanUtils.copyProperties(studentDb.get(), studentDto);
          return studentDto;
      }
      return null;
    }

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepository.getAllStudents();
        List<StudentDto> studentDtos = new ArrayList<>();
        for (Student student : students) {
            StudentDto studentDto = new StudentDto();
            BeanUtils.copyProperties(student, studentDto);
            studentDtos.add(studentDto);
        }
        return studentDtos;
    }

    @Override
    public StudentDto updateStudent(Integer id,StudentUIDto studentDto) {
       Optional<Student> optional = studentRepository.findById(id);
       if (optional.isPresent()) {
           StudentDto dto= new StudentDto();
           Student studentdb = optional.get();
           BeanUtils.copyProperties(studentDto, studentdb);
           Student dbStudent = studentRepository.save(studentdb);
           BeanUtils.copyProperties(dbStudent, dto);
           return  dto;
       }
        return null;
    }
}
