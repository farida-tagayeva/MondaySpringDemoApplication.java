package com.example.demo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.demo.models.BookRequest;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
public class Book {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String name;
  private String author;
  private Integer cost;

  public Book(BookRequest bookRequest) {
    this.name = bookRequest.getName();
    this.author = bookRequest.getAuthor();
    this.cost = bookRequest.getPrice();
  }

  public String toString(){
    return "id = " + id + "; name = " + name + "; author = " + author + "; price = " + cost;
  }
}
