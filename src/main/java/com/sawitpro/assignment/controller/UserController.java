package com.sawitpro.assignment.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @PostMapping
    public ResponseEntity<?> login(){
        return new ResponseEntity<>("", HttpStatus.OK);
    }
    @PostMapping("/register")
    public ResponseEntity<?> register(){
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateName(){
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    @GetMapping("/detail")
    public ResponseEntity<?> getDetail(){
        return new ResponseEntity<>("", HttpStatus.OK);
    }
}
