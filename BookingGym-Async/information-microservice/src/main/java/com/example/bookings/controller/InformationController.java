package com.example.bookings.controller;

import com.example.bookings.infra.dto.UserRequest;
import com.example.bookings.model.User;
import com.example.bookings.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Productor de mensajes
 */
@RestController
@RequestMapping("/api/information")
public class InformationController {
  @Autowired
  private UserService userService;

  @PostMapping("/users")
  public ResponseEntity<?> createUser(@RequestBody UserRequest userRequest) {
    User user = new User();
    user.setId(userRequest.getId());
    user.setFirsName(userRequest.getFirstName());
    user.setLastName(userRequest.getLastName());
    User savedUser = null;
    try {
      savedUser = userService.createUser(userRequest.getFacilityId(), user);
    } catch (IllegalAccessException e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
    return ResponseEntity.ok(savedUser);
  }

  @GetMapping("/users")
  public ResponseEntity<List<User>> getAllUser() {
    List<User> users = userService.findAllUsers();
    if (users == null) {
      return ResponseEntity.notFound().build();
    } else {
      return ResponseEntity.ok(users);
    }
  }

  @GetMapping("/users/{id}")
  public ResponseEntity<User> getUserById(@PathVariable Long id) {
    User user = userService.findById(id);
    if (user == null) {
      return ResponseEntity.notFound().build();
    } else {
      return ResponseEntity.ok(user);
    }
  }

}
