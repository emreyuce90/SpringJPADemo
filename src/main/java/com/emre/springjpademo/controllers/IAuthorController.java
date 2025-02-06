package com.emre.springjpademo.controllers;

import com.emre.springjpademo.dtos.AuthorDto;

public interface IAuthorController {
    AuthorDto GetAuthorById(long id);

}
