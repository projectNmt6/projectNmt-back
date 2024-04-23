package com.projectnmt.projectnmt.controller;

import com.projectnmt.projectnmt.dto.EditAccountReqDto;
import com.projectnmt.projectnmt.dto.GetMyDonationListReqDto;

import com.projectnmt.projectnmt.dto.req.SearchTeamListDto;
import com.projectnmt.projectnmt.entity.Team;
import com.projectnmt.projectnmt.security.PrincipalUser;
import com.projectnmt.projectnmt.service.AccountService;
import com.projectnmt.projectnmt.service.AuthService;
import com.projectnmt.projectnmt.service.PrincipalService;
import com.projectnmt.projectnmt.service.TeamService;
import com.projectnmt.projectnmt.service.UserSerive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.validation.BindingResult;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    PrincipalService getPrincipalService;
    @Autowired
    TeamService teamService;
    @Autowired
    UserSerive userSerive;
    @Autowired
    AccountService accountService;


    @GetMapping("/principal")
    public ResponseEntity<?> getPrincipal() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PrincipalUser principalUser = (PrincipalUser) authentication.getPrincipal();
        return ResponseEntity.ok(principalUser);
    }

    @PutMapping("/mypage/edit")
    public ResponseEntity<?> accountEdit(@RequestBody EditAccountReqDto editAccountReqDto,
                                         BindingResult bindingResult) {
        System.out.println(editAccountReqDto);
        accountService.editAccount(editAccountReqDto);
        return ResponseEntity.ok().build();
    }

        @GetMapping("/teams")
        public ResponseEntity<?> getTeamList (SearchTeamListDto searchTeamListDto){
            List<Team> teamList = teamService.getTeamList(searchTeamListDto);
            return ResponseEntity.ok(teamList);
        }

    @GetMapping("/message")
    public ResponseEntity<?> getMessageList(int userId) {
        return ResponseEntity.ok(userSerive.getMessageList(userId));
    }

    @DeleteMapping("/message/delete/{userId}")
    public ResponseEntity<?> deleteMessageList(@PathVariable int userId) {
        System.out.println(userId);
        userSerive.deleteMessageByUserId(userId);
        return ResponseEntity.ok(null);
    }

    @GetMapping("/mypage/donation")
    public ResponseEntity<?> getMyList(GetMyDonationListReqDto getMyDonationListReqDto) {
        return ResponseEntity.ok(accountService.GetMyDonation(getMyDonationListReqDto));
    }
}


