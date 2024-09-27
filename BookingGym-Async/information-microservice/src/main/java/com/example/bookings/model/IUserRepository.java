package com.example.bookings.model;

import java.util.List;

public interface IUserRepository {
    public User save(User user);
    public User findById(Long id);
    public List<User> findAllUsers();
}
