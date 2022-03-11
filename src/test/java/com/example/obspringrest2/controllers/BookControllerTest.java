package com.example.obspringrest2.controllers;

import com.example.obspringrest2.entities.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BookControllerTest {

    private TestRestTemplate trt;

    @Autowired
    private RestTemplateBuilder rtb;

    @LocalServerPort
    private int port;

    @BeforeEach
    void setUp() {
        rtb = rtb.rootUri("http://localhost:" + port);
        trt = new TestRestTemplate(rtb);
    }

    @Test
    void findAll() {
        ResponseEntity<Book[]> books = trt.getForEntity("/api/books", Book[].class);
        assertEquals(HttpStatus.OK, books.getStatusCode());
//        List<Book> list = Arrays.asList(books.getBody());
//        System.out.println(list.size());
    }


}