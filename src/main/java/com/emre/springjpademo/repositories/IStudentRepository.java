package com.emre.springjpademo.repositories;

import com.emre.springjpademo.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IStudentRepository extends JpaRepository<Student,Integer> {

    @Query(value = "SELECT  * FROM student.student ",nativeQuery = true)
    public List<Student> getAllStudents();

    @Query(value = "from Student where id =:id")
    public Student getStudentById(int id);

}
