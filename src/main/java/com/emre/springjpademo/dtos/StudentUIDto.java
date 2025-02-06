package com.emre.springjpademo.dtos;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
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
    @Min(value = 2,message = "FirstName alanı en az iki karakter olmalıdır")
    private String firstName;
    @NotEmpty(message = "LastName alanı boş geçilemez")
    private String lastName;
    private Date dateOfBirth;
}
