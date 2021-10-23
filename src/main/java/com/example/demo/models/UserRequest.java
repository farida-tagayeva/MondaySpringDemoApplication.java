package com.example.demo.models;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UserRequest {
  private Integer id;
  private String email;
  private String password;
  private String fullName;
}
