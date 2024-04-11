package com.projectnmt.projectnmt.controller;

import com.projectnmt.projectnmt.dto.req.SearchTeamListDto;
import com.projectnmt.projectnmt.entity.Team;
//import com.projectnmt.projectnmt.security.PrincipalUser;
import com.projectnmt.projectnmt.service.PrincipalService;
import com.projectnmt.projectnmt.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
//    @GetMapping("/principal")
//    public ResponseEntity<?> getPrincipal() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
////        PrincipalUser principalUser = (PrincipalUser) authentication.getPrincipal();
////        return ResponseEntity.ok(principalUser);
//    }

    @GetMapping("/teams")
    public ResponseEntity<?> getTeamList(SearchTeamListDto searchTeamListDto) {
        List<Team> teamList = teamService.getTeamList(searchTeamListDto);
        System.out.println(teamList.toString());
        return ResponseEntity.ok(teamList);
    }
}

