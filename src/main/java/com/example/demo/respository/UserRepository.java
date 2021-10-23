package com.example.demo.respository;

import com.example.demo.entity.User;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
  User findByEmail(String email);
}
