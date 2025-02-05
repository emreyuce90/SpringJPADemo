package com.emre.springjpademo.repositories;

import com.emre.springjpademo.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepository extends JpaRepository<Student,Integer> {
}
