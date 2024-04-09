package com.projectnmt.projectnmt.controller;

import com.projectnmt.projectnmt.dto.EditAccountReqDto;
import com.projectnmt.projectnmt.dto.RegisterTeamReqDto;
import com.projectnmt.projectnmt.service.AccountService;
import com.projectnmt.projectnmt.service.PrincipalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    PrincipalService getPrincipalService;
    @Autowired
    AccountService accountService;

    @GetMapping("/principal")
    public ResponseEntity<?> getPrincipal() {
        return ResponseEntity.ok(getPrincipalService.getPrincipal());
    }

    @PutMapping("/mypage/edit")
    public ResponseEntity<?> accountEdit(@RequestBody EditAccountReqDto editAccountReqDto,
                                         BindingResult bindingResult) {
        System.out.println(editAccountReqDto);
            accountService.editAccount(editAccountReqDto);
            return ResponseEntity.ok().build();
    }
}
