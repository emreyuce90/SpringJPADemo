package com.emre.springjpademo.dtos;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentUIDto {
    @NotEmpty(message = "FirstName alanı boş geçilemez")
    private String firstName;
    @NotEmpty(message = "LastName alanı boş geçilemez")
    private String lastName;
    private Date dateOfBirth;
}
