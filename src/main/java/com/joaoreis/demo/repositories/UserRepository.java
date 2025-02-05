package com.joaoreis.demo.repositories;

import com.joaoreis.demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
