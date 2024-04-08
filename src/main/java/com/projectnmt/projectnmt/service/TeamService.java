package com.projectnmt.projectnmt.service;

import com.projectnmt.projectnmt.dto.RegisterTeamReqDto;
import com.projectnmt.projectnmt.entity.Team;
import com.projectnmt.projectnmt.repository.TeamMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TeamService {
    @Autowired
    TeamMapper teamMapper;

    @Transactional(rollbackFor = Exception.class)
    public void saveTeam(RegisterTeamReqDto registerTeamReqDto) {
        Team team = registerTeamReqDto.toEntity();
        int successCount = 0;
        successCount += teamMapper.saveTeam(team);
        successCount += teamMapper.saveLeader(registerTeamReqDto.getUserId(), team.getTeamId());
//        if(successCount < 2) {
//            throw new UsernameNotFoundException("");
//        }

    }
}
