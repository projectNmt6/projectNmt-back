package com.projectnmt.projectnmt.repository;

import com.projectnmt.projectnmt.entity.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TeamMapper {
    public int saveTeam(Team team);
    public int saveLeader(int userId, int teamId);
    public int saveMember(int userId, int teamId);
    public int saveAccount(Account account);
    public List<Team> teamList(int userId);
    public Team teamInfo(int teamId);
    public int updateTeam(Team team);
    public int deleteAccounts(int teamId);
    public TeamMember findMember(int userId, int teamId);
    public List<TeamMember> findMemberByTeamId(int teamId);
    public TeamMember findMemberByTeamIdAndUserId(int teamId,int userId);
    public List<Donation> getDonationListByTeamId(int teamId);
    public List<ChallengePage> getChallengeListByTeamId(int teamId);
    public List<Account> getAccountListByTeamId(int teamId);
    public int findTeamIdByUserId(int userId);

    public int updatePageDelete(int pageId);
}
