package com.projectnmt.projectnmt.repository;

import com.projectnmt.projectnmt.entity.Account;
import com.projectnmt.projectnmt.entity.Donation;
import com.projectnmt.projectnmt.entity.Team;
import com.projectnmt.projectnmt.entity.TeamMember;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TeamMapper {
    public int saveTeam(Team team);
    public int saveLeader(int userId, int teamId);
    public int saveAccount(Account account);
    public List<Team> teamList(int userId);
    public Team teamInfo(int teamId);
    public int updateTeam(Team team);
    public int deleteAccounts(int teamId);
    public TeamMember findMember(int userId, int teamId);
    public List<Donation> getDonationListByTeamId(int teamId);
    public int updatePageDelete(int pageId);
}
