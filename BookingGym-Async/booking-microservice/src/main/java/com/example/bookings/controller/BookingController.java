package com.example.bookings.controller;

import com.example.bookings.infra.dto.BookingRequest;
import com.example.bookings.model.Booking;
import com.example.bookings.model.User;
import com.example.bookings.service.BookingService;
import com.example.bookings.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
/*
  Consumidor de mensajes
 */
@RestController
@RequestMapping("/api/bookings")
public class BookingController {

  @Autowired
  private BookingService bookingService;

  @Autowired
  private UserService userService;

  @PostMapping("/booking")
  public ResponseEntity<?> createBooking(@RequestBody BookingRequest bookingRequest) {
    Booking booking = new Booking();
    booking.setDateCreated(new Date());
    Booking savedBooking = null;
    try {
        savedBooking = bookingService.createBooking(bookingRequest.getUserId(), bookingRequest.getGymClassId(), booking);
    } catch (IllegalAccessException e) {
        throw new RuntimeException(e);
    }
    return ResponseEntity.ok(savedBooking);
  }

  @GetMapping("/booking/{id}")
  public ResponseEntity<Booking> getBookingById(@PathVariable Long id) {

    Booking booking = bookingService.findById(id);
    if (booking == null) {
      return ResponseEntity.notFound().build();
    } else {
      return ResponseEntity.ok(booking);
    }
  }

  // Solicitudes de Usuarios
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
