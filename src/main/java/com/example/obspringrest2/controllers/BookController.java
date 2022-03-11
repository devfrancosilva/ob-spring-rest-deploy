package com.example.obspringrest2.controllers;


import com.example.obspringrest2.entities.Book;
import com.example.obspringrest2.repositories.BookRepository;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    private final Logger log = LoggerFactory.getLogger(BookController.class);

    BookRepository repository;

    public BookController(BookRepository repository) {
        this.repository = repository;
    }

    // buscar todos los libros

    @GetMapping(path = "/api/books")
    public List<Book> findAll() {
        return repository.findAll();
    }

    // buscar un libro por id
    @GetMapping(path = "/api/books/{id}")
    public ResponseEntity<Book> findById(@ApiParam("Clave primaria Id de tipo Long") @PathVariable Long id) {
       Optional<Book> bookOpt = repository.findById(id);

       if(bookOpt.isPresent()) {
           return ResponseEntity.ok(bookOpt.get());
       }else {
           return ResponseEntity.notFound().build();
       }

    }

    // crear un libro
    @PostMapping(path = "/api/books")
    public Book create(@RequestBody Book book){
       return repository.save(book);
    }

    // actualizar un libro
    @PutMapping(path = "/api/books")
    public Book update(@RequestBody Book book){
        return repository.save(book);
    }

    // eliminar
    @DeleteMapping(path = "/api/books/{id}")
    public void delete(@PathVariable Long id) {
    log.info("Dentro de delete()");
        repository.deleteById(id);
    }

}
