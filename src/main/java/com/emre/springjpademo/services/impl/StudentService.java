package com.emre.springjpademo.services.impl;


import com.emre.springjpademo.entities.Student;
import com.emre.springjpademo.repositories.IStudentRepository;
import com.emre.springjpademo.services.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService implements IStudentService {

    @Autowired
   private IStudentRepository studentRepository;

    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }
}
