package com.example.demo.services;

import java.util.Date;

import com.example.demo.entity.Book;
import com.example.demo.models.BookRequest;
import com.example.demo.respository.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

  @Autowired
  BookRepository bookRepository;

  public boolean create(BookRequest bookRequest) {
    Book book = bookRepository.findBookByName(bookRequest.getName());
    if(book == null){
      book = new Book(bookRequest);
      bookRepository.save(book);
      return true;
    }
    return false;
  }
  public boolean delete(String name){
    Book book = bookRepository.findBookByName(name);
    if(book != null){
      bookRepository.delete(book);
      return true;
    }
    return false;
  }
  public Book getBookByName(String name){
    return bookRepository.findBookByName(name);
  }
}
