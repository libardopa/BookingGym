package com.example.bookings.repository;

import com.example.bookings.model.Facility;
import com.example.bookings.model.IUserRepository;
import com.example.bookings.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Este repositorio guarda objetos en memoria en un Array, por ahora.
 */
@Repository
public class UserRepository implements IUserRepository {
    private final List<User> usersStore;

    public UserRepository() {
        usersStore = new ArrayList<>();
        initilizeData();

    }
    private void initilizeData(){
        usersStore.add(new User(1L,"Juan","Sanchez",new Facility(1L,"Calle 23 No 12-2","Popayan")));
        usersStore.add(new User(2L,"Maria","Cardenas",new Facility(1L,"Calle 23 No 12-2","Popayan")));
        usersStore.add(new User(3L,"Andriana","Andrade",new Facility(1L,"Calle 23 No 12-2","Popayan")));
    }

    @Override
    public User save(User user) {
        usersStore.add(user);
        return user;
    }

    @Override
    public User findById(Long id) {
        for (User user: usersStore){
            if (user.getId().equals(id)){
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> findAllUsers() {
        return usersStore;
    }
}
