package com.joaoreis.demo.resource;

import com.joaoreis.demo.entities.Rent;
import com.joaoreis.demo.entities.User;
import com.joaoreis.demo.services.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/rents")
public class RentResource {

    @Autowired
    private RentService service;

    @GetMapping
    public ResponseEntity<List<Rent>> findAll(){
        List<Rent> list = service.findAll();

        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Rent> findById(@PathVariable Long id){
        Rent obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
