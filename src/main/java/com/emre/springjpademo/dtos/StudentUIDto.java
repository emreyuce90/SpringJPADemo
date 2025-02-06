package com.emre.springjpademo.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentUIDto {
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
}
