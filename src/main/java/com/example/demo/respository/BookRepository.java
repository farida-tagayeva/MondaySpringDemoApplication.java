package com.example.demo.respository;

import com.example.demo.entity.Book;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
    Book findBookByName(String name);

}
