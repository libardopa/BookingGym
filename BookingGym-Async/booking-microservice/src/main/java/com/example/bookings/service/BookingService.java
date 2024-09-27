package com.example.bookings.service;


import com.example.bookings.model.Booking;
import com.example.bookings.model.GymClass;
import com.example.bookings.model.User;
import com.example.bookings.repository.BookingRepository;
import com.example.bookings.repository.GymClassRepository;
import com.example.bookings.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

  //@Autowired
  private final BookingRepository bookingRepository;
  private final UserRepository userRepository;
  private final GymClassRepository gymClassRepository;

  public BookingService(BookingRepository bookingRepository, UserRepository userRepository, GymClassRepository gymClassRepository) {

    this.bookingRepository = bookingRepository;
    this.userRepository = userRepository;
    this.gymClassRepository = gymClassRepository;
  }
  public Booking createBooking(Long userId, Long gymClassId, Booking booking) throws IllegalAccessException {
    User user = userRepository.findById(userId);
    if (user ==  null){
      throw new IllegalAccessException("El usuario con ID " + userId + " no existe");
    }
    booking.setUser(user);

    GymClass gymClass = gymClassRepository.findByID(gymClassId);
    if (gymClass ==  null){
      throw new IllegalAccessException("La clase  con ID " + gymClassRepository + " no existe");
    }
    booking.setGymClass(gymClass);

    return bookingRepository.save(booking);
  }

  public Booking findById(Long id) {
    return bookingRepository.findById(id);
  }
}
