package com.projectnmt.projectnmt.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {
    @GetMapping("/principal")
    public ResponseEntity<?> getPrincical() {
        System.out.println("work");
        return ResponseEntity.ok(null);
    }

}

