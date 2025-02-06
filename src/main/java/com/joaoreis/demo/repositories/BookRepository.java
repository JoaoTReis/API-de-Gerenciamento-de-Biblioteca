package com.joaoreis.demo.repositories;

import com.joaoreis.demo.entities.Book;
import com.joaoreis.demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}
