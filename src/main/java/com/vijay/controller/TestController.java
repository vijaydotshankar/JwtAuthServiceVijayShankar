package com.vijay.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/testing")
public class TestController {

    @GetMapping
    public ResponseEntity<String> testApi(){
        return ResponseEntity.status(HttpStatus.OK).body("Api Test Successfully !!");
    }
}
