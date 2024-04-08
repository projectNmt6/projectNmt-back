package com.projectnmt.projectnmt.service;

import com.projectnmt.projectnmt.dto.RegisterTeamReqDto;
import com.projectnmt.projectnmt.dto.req.SearchTeamInfoDto;
import com.projectnmt.projectnmt.dto.req.SearchTeamListDto;
import com.projectnmt.projectnmt.entity.Account;
import com.projectnmt.projectnmt.entity.Team;
import com.projectnmt.projectnmt.repository.TeamMapper;
import com.projectnmt.projectnmt.repository.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TeamService {
    @Autowired
    TeamMapper teamMapper;
    @Autowired
    UserMapper userMapper;

    @Transactional(rollbackFor = Exception.class)
    public void saveTeam(RegisterTeamReqDto registerTeamReqDto) {
        Team team = registerTeamReqDto.toEntity();
        System.out.println(registerTeamReqDto);
        int successCount = 0;
        successCount += teamMapper.saveTeam(team);
        successCount += teamMapper.saveLeader(registerTeamReqDto.getUserId(), team.getTeamId());
        successCount += userMapper.saveRole(registerTeamReqDto.getUserId(), 2);
        for(Account account : registerTeamReqDto.getAccountInfos()) {
            account.setTeamId(team.getTeamId());
            successCount += teamMapper.saveAccount(account);
        }
        if(successCount < 3 + registerTeamReqDto.getAccountInfos().length) {
            throw new UsernameNotFoundException("");
        }

    }
    public List<Team> getTeamList(SearchTeamListDto searchTeamListDto) {
        List<Team> teamList = teamMapper.teamList(searchTeamListDto.getUserId());
        return teamList;
    }
    public Team getTeamInfo(SearchTeamInfoDto searchTeamInfoDto) {
        Team team = teamMapper.teamInfo(searchTeamInfoDto.getTeamId());
        return team;
    }
}
