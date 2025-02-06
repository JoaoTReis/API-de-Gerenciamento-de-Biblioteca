package com.joaoreis.demo.repositories;

import com.joaoreis.demo.entities.RentItem;
import com.joaoreis.demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentItemRepository extends JpaRepository<RentItem, Long> {

}
