package com.emre.springjpademo.controllers.impl;

import com.emre.springjpademo.controllers.IAuthorController;
import com.emre.springjpademo.dtos.AuthorDto;
import com.emre.springjpademo.services.IAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/authors")
public class AuthorController implements IAuthorController {

    @Autowired
    private IAuthorService authorService;

    @GetMapping("{id}")
    @Override
    public AuthorDto GetAuthorById(@PathVariable(name = "id") long id) {
        return authorService.GetAuthorById(id);
    }
}
