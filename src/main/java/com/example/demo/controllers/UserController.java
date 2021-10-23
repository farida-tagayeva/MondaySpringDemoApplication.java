package com.example.demo.controllers;

import com.example.demo.entity.User;
import com.example.demo.helpers.ValidateHelper;
import com.example.demo.models.UserRequest;
import com.example.demo.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
  private UserService userService;

  @Autowired public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping("/create") public ResponseEntity create(@RequestBody UserRequest userRequest) {
    boolean result = userService.saveUser(userRequest);
    if (result) {
      return new ResponseEntity("user created", HttpStatus.CREATED);
    }
    return ResponseEntity.badRequest().body("bad request");
  }

  @GetMapping("/get") public ResponseEntity getUserById(@RequestParam String email) {
    User userRequest = userService.getUser(email);
    if (userRequest == null) {
      return new ResponseEntity("User not found", HttpStatus.NOT_FOUND);
    }
    return ResponseEntity.ok(userRequest);
  }

  @PostMapping("/addBooks")
  public ResponseEntity addProducts(@RequestParam Integer userId, @RequestParam List<Integer> booksId) {
    userService.addProductsToUser(userId, booksId);
    return ResponseEntity.ok().body("Successfully added!");
  }
}
