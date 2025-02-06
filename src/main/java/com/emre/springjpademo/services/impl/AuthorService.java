package com.emre.springjpademo.services.impl;

import com.emre.springjpademo.dtos.AuthorDto;
import com.emre.springjpademo.dtos.BookDto;
import com.emre.springjpademo.entities.Author;
import com.emre.springjpademo.entities.Book;
import com.emre.springjpademo.repositories.IAuthorRepository;
import com.emre.springjpademo.services.IAuthorService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorService implements IAuthorService {

    @Autowired
    private IAuthorRepository authorRepository;

    @Override
    public AuthorDto GetAuthorById(long id) {
      Optional<Author> optional =  authorRepository.findById(id);

      if(!optional.isPresent()) {
          return null;
      }
      //vt değerini karşıladım
      Author author = optional.get();
      //dto oluşturdum
      AuthorDto authorDto = new AuthorDto();

      //vt kaydını author dtoya kopyaladım
      BeanUtils.copyProperties(author, authorDto);

      List<BookDto> bookDtos = new ArrayList<>();
      if(!author.getBook().isEmpty()) {
          for(Book book : author.getBook()) {
              BookDto bookDto = new BookDto();
              BeanUtils.copyProperties(book, bookDto);
              bookDtos.add(bookDto);
          }
      }
      authorDto.setBooks(bookDtos);

      return authorDto;
    }
}
