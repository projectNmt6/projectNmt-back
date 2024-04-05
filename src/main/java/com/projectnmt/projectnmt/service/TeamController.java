package com.projectnmt.projectnmt.service;

import com.projectnmt.projectnmt.dto.RegisterTeamReqDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
