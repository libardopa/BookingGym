package com.example.bookings.repository;

import com.example.bookings.model.Facility;
import com.example.bookings.model.IFacilityRepository;
import com.example.bookings.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class FacilityRepository implements IFacilityRepository {
    private final List<Facility> facilitiesStore;

    public FacilityRepository() {
        this.facilitiesStore = new ArrayList<>();
        initilizeData();
    }
    private void initilizeData(){
        facilitiesStore.add(new Facility(1L,"Calle 22 No. 13-34 ","Popayan"));
        facilitiesStore.add(new Facility(2L,"Carrera 1 No. 7-33 ","Pasto"));
        facilitiesStore.add(new Facility(3L,"Calle 5 No. 50-2 ","Cali"));

    }
    @Override
    public Facility save(Facility facility) {
        facilitiesStore.add(facility);
        return facility;
    }

    @Override
    public Facility findById(Long id) {
        for (Facility facility: facilitiesStore){
            if (facility.getId().equals(id)){
                return facility;
            }
        }
        return null;
    }
}
