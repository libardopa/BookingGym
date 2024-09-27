package com.example.bookings.model;

public interface IFacilityRepository {
    public Facility save(Facility facility);
    public Facility findById(Long id);
}
