package com.projectnmt.projectnmt.controller;

import com.projectnmt.projectnmt.dto.RegisterTeamReqDto;
import com.projectnmt.projectnmt.dto.req.SearchTeamInfoDto;
import com.projectnmt.projectnmt.dto.req.SearchTeamListDto;
import com.projectnmt.projectnmt.dto.req.TeamMemberListReqDto;
import com.projectnmt.projectnmt.dto.req.UpdateTeamReqDto;
import com.projectnmt.projectnmt.entity.Team;
import com.projectnmt.projectnmt.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PutMapping("/update")
    public ResponseEntity<?> updateTeam(@RequestBody UpdateTeamReqDto updateTeamReqDto) {
        teamService.updateTeam(updateTeamReqDto);
        return ResponseEntity.ok(null);
    }

    @GetMapping("/info")
    public ResponseEntity<?> getTeamInfo(SearchTeamInfoDto searchTeamListDto) {
        Team team = teamService.getTeamInfo(searchTeamListDto);
        return ResponseEntity.ok(team);
    }
    @GetMapping("/member")
    public ResponseEntity<?> getTeamMemberList(TeamMemberListReqDto teamMemberListReqDto) {
        return ResponseEntity.ok(teamService.getMemberInfo(teamMemberListReqDto));
    }

    @GetMapping("/donations")
    public ResponseEntity<?> getDonationList(int teamId) {
        return ResponseEntity.ok( teamService.getDonationList(teamId));
    }
}
