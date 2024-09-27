package com.example.bookings.service;


import com.example.bookings.model.Booking;
import com.example.bookings.model.GymClass;
import com.example.bookings.model.ServiceInformationClient;
import com.example.bookings.model.User;
import com.example.bookings.repository.BookingRepository;
import com.example.bookings.repository.GymClassRepository;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

  //@Autowired
  private final BookingRepository bookingRepository;
  private final GymClassRepository gymClassRepository;

  private final ServiceInformationClient serviceInformationClient;


  public BookingService(BookingRepository bookingRepository,GymClassRepository gymClassRepository, ServiceInformationClient serviceInformationClient) {

    this.bookingRepository = bookingRepository;
    this.gymClassRepository = gymClassRepository;
    this.serviceInformationClient = serviceInformationClient;
  }
  public Booking createBooking(Long userId, Long gymClassId, Booking booking) throws IllegalAccessException {
    //Invoca el servicio de Information-Microservice
    System.out.println("Invocando servicio getuserById desde Booking-Microservice");
    User user = serviceInformationClient.getUserById(userId);
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
