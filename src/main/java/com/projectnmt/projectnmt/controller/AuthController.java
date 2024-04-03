package com.projectnmt.projectnmt.controller;

import com.projectnmt.projectnmt.dto.SignInReqDto;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    // 제바로디라
    @PostMapping("/signup")
    public ResponseEntity<?> signup(BindingResult bindingResult) {
        return ResponseEntity.ok(null);
    }

    @PostMapping("/signin")
    public ResponseEntity<?> signin(@RequestBody SignInReqDto signInReqDto) {
        return ResponseEntity.ok(null);
    }
}
