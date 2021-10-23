package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.demo.entity.User;
import com.example.demo.helpers.ValidateHelper;
import com.example.demo.models.UserRequest;
import com.example.demo.respository.BookRepository;
import com.example.demo.respository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;
  @Autowired
  private BookRepository productRepository;

  public boolean saveUser(UserRequest userRequest) {
    if(!ValidateHelper.validate(userRequest.getEmail())) {
      return false;
    }
    User byEmail = userRepository.findByEmail(userRequest.getEmail());
    if(byEmail != null) {
      return false;
    }
    User user = new User(userRequest.getEmail(),userRequest.getPassword(),userRequest.getFullName());
    userRepository.save(user);
    return true;
  }

  public boolean addProductsToUser(Integer userId, List<Integer> booksId) {
    Optional<User> userOptional = userRepository.findById(userId.longValue());
    User user = userOptional.orElse(null);
    if(user == null) {
      return false;
    }
    booksId = new ArrayList<>();
    user.setBooksId(booksId);
    userRepository.save(user);
    return true;
  }

  public User getUser(String email) {
    return userRepository.findByEmail(email);
  }

}
