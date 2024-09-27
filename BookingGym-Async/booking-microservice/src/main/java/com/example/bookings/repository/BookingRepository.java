package com.example.bookings.repository;

import com.example.bookings.model.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Repository
public class BookingRepository implements IBookingRepository {

    private static final List<Booking> bookingStore = new ArrayList<>();;
    public BookingRepository(){
        //bookingStore = new ArrayList<>();
        initializeData();
        System.out.println("Se inicializó datos");
    }
    private void initializeData(){
        Booking booking = new Booking();
        booking.setId(1L);
        booking.setUser(new User(1L,"Sandra","Cardenas", new Facility(1L,"Calle 12 no 12-12","Popayan")));
        booking.setDateCreated(new Date());
        booking.setGymClass(new GymClass(1L, new Date(), new Instructor(1L,"Maxi Palacios"), "Clase de aerobicos"));
        bookingStore.add(booking);
    }

    @Override
    public Booking save(Booking booking) {
        bookingStore.add(booking);
        System.out.println("agregada reserva. Total reservas: " + bookingStore.size());
        return booking;
    }

    @Override
    public Booking findById(Long id) {
        for (Booking booking:bookingStore){
            if (booking.getId().equals(id)){
                return booking;
            }
        }
        return null;
    }
}
