package com.projectnmt.projectnmt.service;

import com.projectnmt.projectnmt.dto.req.AdminMessageReqDto;
import com.projectnmt.projectnmt.dto.resp.CommentListRespDto;
import com.projectnmt.projectnmt.entity.AdminUser;
import com.projectnmt.projectnmt.entity.Authority;
import com.projectnmt.projectnmt.entity.Team;
import com.projectnmt.projectnmt.entity.User;
import com.projectnmt.projectnmt.repository.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    AdminMapper adminMapper;
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
            adminMapper.sendMessage(userId, adminMessageReqDto.getMessage());
        }
    }

    public List<Team> getTeamList() {
        return adminMapper.getTeamList();
    }
    public void deleteTeams(List<Integer> teamIds) {
        for(int teamId : teamIds) {
            adminMapper.deleteTeamListByTeamIds(teamId);
        }
    }


    public Boolean updatePageShow(int donationPageId) {

        try {
            adminMapper.updatePageShow(donationPageId);
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }



}
