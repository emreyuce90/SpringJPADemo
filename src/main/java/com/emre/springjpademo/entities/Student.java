package com.emre.springjpademo.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Entity
@Data
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;
    @Column(name = "last_name",nullable = false, length = 50)
    private String lastName;
    @Column(name = "date_of_birth",nullable = true)
    private Date dateOfBirth;
}
