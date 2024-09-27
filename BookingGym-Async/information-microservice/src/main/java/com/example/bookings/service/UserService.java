package com.example.bookings.service;

import com.example.bookings.infra.config.RabbitMQConfig;
import com.example.bookings.model.Facility;
import com.example.bookings.model.User;
import com.example.bookings.repository.FacilityRepository;
import com.example.bookings.repository.UserRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private RabbitTemplate rabbitTemplate;


    private final UserRepository userRepository;
    private final FacilityRepository facilityRepository;

    public UserService(UserRepository userRepository, FacilityRepository facilityRepository) {


        this.userRepository = userRepository;
        this.facilityRepository = facilityRepository;
    }

    public User createUser(Long facilityId, User user) throws IllegalAccessException {
        Facility facility = facilityRepository.findById(facilityId);
        if (facility == null) {
            throw new IllegalAccessException("La instalación con ID " + facilityId + " no existe");
        }
        User userFounded = userRepository.findById(user.getId());
        if ( userFounded != null){
            throw new IllegalAccessException("El usuario con ID " + user.getId() + " ya existe");
        }
        user.setFacility(facility);

        rabbitTemplate.convertAndSend(RabbitMQConfig.USER_QUEUE, user);
        return userRepository.save(user);
    }

    public User findById(Long id) {
        return userRepository.findById(id);
    }

    public List<User> findAllUsers() {
        return userRepository.findAllUsers();
    }
}