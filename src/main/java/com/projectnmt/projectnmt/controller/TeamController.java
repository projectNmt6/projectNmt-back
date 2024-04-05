package com.projectnmt.projectnmt.controller;

import com.projectnmt.projectnmt.dto.RegisterTeamReqDto;
import com.projectnmt.projectnmt.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/team")
public class TeamController {
    @Autowired
    TeamService teamService;
    @PostMapping("/register")
    public ResponseEntity<?> registerTeam(@RequestBody RegisterTeamReqDto registerTeamReqDto) {
        teamService.saveTeam(registerTeamReqDto);
        return ResponseEntity.ok(null);
    }

}
