package com.example.demo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "usr")
@Getter
@Setter
@NoArgsConstructor
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  @Column(columnDefinition = "TEXT")
  private String email;
  private String password;
  private String fullName;
  @OneToMany
  private List<Integer> booksId;

  public User(final String email, final String password, final String fullName) {
    this.email = email;
    this.password = password;
    this.fullName = fullName;
  }

  public String toString(){
    return "email = "  +email + "; password = "  +password + "; Full name = " + fullName;
  }
}
