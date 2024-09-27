package com.example.bookings.model;

import java.util.Date;
import java.util.UUID;

public class Booking {

  private Long id;
  private User user;
  private GymClass gymClass;

  public Booking(Long id, User user, GymClass gymClass, Date dateCreated) {
    this.id = id;
    this.user = user;
    this.gymClass = gymClass;
    this.dateCreated = dateCreated;
  }
  public Booking() {
    this.id = Math.abs(UUID.randomUUID().getMostSignificantBits() & Integer.MAX_VALUE);  // Limitar al rango de enteros positivos
  }
  private Date dateCreated;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Date getDateCreated() {
    return dateCreated;
  }

  public void setDateCreated(Date dateCreated) {
    this.dateCreated = dateCreated;
  }

  public GymClass getGymClass() {
    return gymClass;
  }

  public void setGymClass(GymClass gymClass) {
    this.gymClass = gymClass;
  }
}
