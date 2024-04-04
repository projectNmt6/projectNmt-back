package com.projectnmt.projectnmt.controller;

import com.projectnmt.projectnmt.dto.SignInReqDto;
import com.projectnmt.projectnmt.dto.SignUpReqDto;
import com.projectnmt.projectnmt.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@Valid @RequestBody SignUpReqDto signUpReqDto, BindingResult bindingResult) {
        authService.signup(signUpReqDto);
        System.out.println(signUpReqDto);
        return ResponseEntity.created(null).body(true);
    }

    @PostMapping("/signin")
    public ResponseEntity<?> signin(@RequestBody SignInReqDto signInReqDto) {
        return ResponseEntity.ok(signInReqDto);
    }
}
