package com.example.demo.models;

import lombok.Data;

import java.math.BigInteger;
import java.util.Date;

@Data
public class BookRequest {
  private String name;
  private String author;
  private Integer price;
}