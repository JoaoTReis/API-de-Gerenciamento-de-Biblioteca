package com.joaoreis.demo.repositories;

import com.joaoreis.demo.entities.Rent;
import com.joaoreis.demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentRepository extends JpaRepository<Rent, Long> {

}
