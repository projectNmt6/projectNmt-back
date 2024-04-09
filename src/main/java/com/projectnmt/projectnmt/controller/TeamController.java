package com.projectnmt.projectnmt.controller;

import com.projectnmt.projectnmt.dto.RegisterTeamReqDto;
import com.projectnmt.projectnmt.dto.req.SearchTeamInfoDto;
import com.projectnmt.projectnmt.entity.Team;
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
    @GetMapping("/info")
    public ResponseEntity<?> getTeamInfo(SearchTeamInfoDto searchTeamListDto) {
        Team team = teamService.getTeamInfo(searchTeamListDto);
        System.out.println(team);
        return ResponseEntity.ok(team);
    }

}
