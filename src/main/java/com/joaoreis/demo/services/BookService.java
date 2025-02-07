package com.joaoreis.demo.services;

import com.joaoreis.demo.entities.Book;
import com.joaoreis.demo.entities.User;
import com.joaoreis.demo.repositories.BookRepository;
import com.joaoreis.demo.services.exceptions.DatabaseException;
import com.joaoreis.demo.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    public List<Book> findAll(){
        return repository.findAll();
    }

    public Book findById(Long id){
        Optional<Book> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Book insert(Book obj){
        return repository.save(obj);
    }

    public void delete(Long id){
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }
    }
}
