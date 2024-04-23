package com.projectnmt.projectnmt.service;

import com.projectnmt.projectnmt.dto.req.AdminMessageReqDto;
import com.projectnmt.projectnmt.dto.resp.CommentListRespDto;
import com.projectnmt.projectnmt.entity.*;
import com.projectnmt.projectnmt.repository.AdminMapper;
import com.projectnmt.projectnmt.repository.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminService {

    @Autowired
    AdminMapper adminMapper;

    @Autowired
    UserMapper userMapper;
    public List<AdminUser> getUserList() {
        return adminMapper.findUserList();
    }
    public AdminUser getUser(int userId) {
        return adminMapper.findUserByUserId(userId);
    }
    public List<CommentListRespDto> getCommentList(int userId) {
        return adminMapper.findCommentListByUserId(userId);
    }
    public void deleteCommemt(List<Integer> commentIds) {
        for(int commentId : commentIds) {
            adminMapper.deleteCommemt(commentId);
        }
    }
    public void addRole(Authority authority) {
        adminMapper.addRole(authority);
    }

    public void sendMessage(AdminMessageReqDto adminMessageReqDto) {
        for(int userId : adminMessageReqDto.getUserId()) {
            adminMapper.sendMessage(userId, adminMessageReqDto.getIsTeam(), adminMessageReqDto.getMessage());
        }
    }

    public List<Team> getTeamList() {
        return adminMapper.getTeamList();
    }
    public void deleteTeams(List<Team> teamList) {
        for(Team team : teamList) {
//            adminMapper.deleteTeamListByTeamIds(team.getTeamId());
            TeamMember member = adminMapper.findTeamMemberListByTeamId(team.getTeamId());
            adminMapper.sendMessage(member.getUserId(), 0,"관리자에 의해 팀"+team.getTeamName()+"이(가) 해체되었습니다.");
        }
    }
    public int updatePageShow(List<DonationPage> donationPageList) {
        int num = 0;
        for (DonationPage donationPage : donationPageList) {
            num += adminMapper.updatePageShow(donationPage.getDonationPageId());
        }
        System.out.println(num);
        return num;
    }
    public void signout(List<Integer> userIds) {
        for (int userId : userIds) {
            userMapper.deleteUserByUserId(userId);
            userMapper.deleteAuthority(userId);
            List<TeamMember> userTeamList = userMapper.findTeamMemberByUserId(userId);
            userMapper.deleteOAuth2ByUserId(userId);
            System.out.println(userTeamList);
            for (TeamMember team : userTeamList) {
                if(team.getTeamRoleId() == 1) {
                    System.out.println(userMapper.deleteTeamByTeamId(team.getTeamId()));
                    List<TeamMember> teamMembers = userMapper.findTeamMemberListByTeamId(team.getTeamId());
                    userMapper.deleteTeamMemberByTeamId(team.getTeamId());
                    for ( TeamMember mem : teamMembers ) {
                        if(mem.getUserId() != userId) {
                            userMapper.sendMessage(mem.getUserId(), "리더의 약관위반으로 팀이 해산되었습니다.");
                        }
                    }
                } else {
                    userMapper.deleteTeamMemberByUserId(userId);
                }
            }
        }
    }

}
