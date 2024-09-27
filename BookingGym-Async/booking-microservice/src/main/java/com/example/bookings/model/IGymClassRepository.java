package com.example.bookings.model;

public interface IGymClassRepository {
    public GymClass save(GymClass gymClass);
    public GymClass findByID(Long id);
}
