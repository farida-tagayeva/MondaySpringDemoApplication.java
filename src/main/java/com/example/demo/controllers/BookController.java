package com.example.demo.controllers;

import com.example.demo.entity.Book;
import com.example.demo.models.BookRequest;
import com.example.demo.services.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {
  @Autowired
  BookService bookService;

  @PostMapping("/add")
  public ResponseEntity create(@RequestBody BookRequest product){
    return ResponseEntity.ok(bookService.create(product));
  }
  @PostMapping("/get")
  public ResponseEntity get(@RequestParam String name){
    Book book = bookService.getBookByName(name);
    if(book != null){
      return ResponseEntity.ok(book);
    }
    return ResponseEntity.ok("Something is invalid!");
  }
}
