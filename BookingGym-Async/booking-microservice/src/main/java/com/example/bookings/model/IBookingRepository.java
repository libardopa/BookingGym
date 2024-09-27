package com.example.bookings.model;

public interface IBookingRepository {
    public Booking save(Booking booking);
    public Booking findById(Long id);
}
