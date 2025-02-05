package com.joaoreis.demo.services;

import com.joaoreis.demo.entities.Rent;
import com.joaoreis.demo.entities.User;
import com.joaoreis.demo.repositories.RentRepository;
import com.joaoreis.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RentService {

    @Autowired
    private RentRepository repository;

    public List<Rent> findAll(){
        return repository.findAll();
    }

    public Rent findById(Long id){
       Optional<Rent> obj = repository.findById(id);
       return obj.get();
    }
}
