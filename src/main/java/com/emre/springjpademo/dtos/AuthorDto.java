package com.emre.springjpademo.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDto {
    private long id;
    private String authorName;
    private List<BookDto> books = new ArrayList<>();
}
