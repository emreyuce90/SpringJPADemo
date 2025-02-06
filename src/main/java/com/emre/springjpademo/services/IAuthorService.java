package com.emre.springjpademo.services;

import com.emre.springjpademo.dtos.AuthorDto;

public interface IAuthorService {
    AuthorDto GetAuthorById(long id);
}
