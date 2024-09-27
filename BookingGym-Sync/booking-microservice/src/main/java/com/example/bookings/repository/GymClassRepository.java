package com.example.bookings.repository;

import com.example.bookings.model.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Este repositorio guarda objetos en memoria en un Array, por ahora.
 */
@Repository
public class GymClassRepository implements IGymClassRepository {
    private final List<GymClass> gymClassStore;

    public GymClassRepository() {
        gymClassStore = new ArrayList<>();
        initilizeData();

    }
    private void initilizeData(){
        gymClassStore.add(new GymClass(1L, new Date(), new Instructor(1L,"Jesus Santos"), "Clase de aeróbicos" ));
        gymClassStore.add(new GymClass(2L, new Date(), new Instructor(1L,"Jesus Santos"), "Clase de yoga" ));
        gymClassStore.add(new GymClass(3L, new Date(), new Instructor(2L,"Maria Castro"), "Clase de salsa" ));
    }

    @Override
    public GymClass save(GymClass user) {
        gymClassStore.add(user);
        return user;
    }

    @Override
    public GymClass findByID(Long id) {
        for (GymClass gymClass: gymClassStore){
            if (gymClass.getId().equals(id)){
                return gymClass;
            }
        }
        return null;
    }
}
