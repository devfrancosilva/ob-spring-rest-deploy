package com.example.obspringrest2.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping(path = "/hola")
    public String hello() {
        return "Hola desde la api!";
    }
}
