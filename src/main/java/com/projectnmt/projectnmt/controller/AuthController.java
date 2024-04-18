
package com.projectnmt.projectnmt.controller;

import com.projectnmt.projectnmt.aop.annotation.ValidAspect;
import com.projectnmt.projectnmt.dto.OAuth2SignupReqDto;
import com.projectnmt.projectnmt.dto.SignInReqDto;
import com.projectnmt.projectnmt.dto.SignUpReqDto;
import com.projectnmt.projectnmt.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@Valid @RequestBody SignUpReqDto signUpReqDto, BindingResult bindingResult) {
        authService.signup(signUpReqDto);
        System.out.println("work");
        return ResponseEntity.created(null).body(true);
    }

    @PostMapping("/signin")
    public ResponseEntity<?> signin(@RequestBody SignInReqDto signInReqDto) {
        System.out.println(authService.signin(signInReqDto ));
        return ResponseEntity.ok(authService.signin(signInReqDto));
    }

    @DeleteMapping("/user/delete/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable int userId) {
        authService.signout(userId);
        return ResponseEntity.ok(null);
    }

    @PostMapping("/oauth2/signup")
    public ResponseEntity<?> oAuth2Signup(@RequestBody OAuth2SignupReqDto oAuth2SignupReqDto) {
        String accessToken = authService.oAuth2Signup(oAuth2SignupReqDto);
        return ResponseEntity.created(null).body(accessToken);
    }

}

