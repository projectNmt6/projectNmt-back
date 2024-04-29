package com.projectnmt.projectnmt.repository;

import com.projectnmt.projectnmt.dto.UserListRsqDto;
import com.projectnmt.projectnmt.dto.req.AdminMessageReqDto;
import com.projectnmt.projectnmt.dto.resp.CommentListRespDto;
import com.projectnmt.projectnmt.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AdminMapper {
    public List<AdminUser> findUserList(UserListRsqDto userListRsqDto);
    public AdminUser findUserByUserId(int userId);
    public List<CommentListRespDto> findCommentListByUserId(int userId);
    public void addRole(Authority authority);
    public void deleteCommemt(int commentId);
    public void sendMessage(int userId, int isTeam, String message);
    public List<Team> getTeamList();
    public int deleteTeamListByTeamIds(int teamId);
    public TeamMember findTeamMemberListByTeamId(int teamId);
    public int updatePageShow(int donationPageId);
    public List<Role> findRoleList(int userId);
    public List<AdminUser> findUserListForRoleSelect(UserListRsqDto userListRsqDto);
    public Integer getUserCount(UserListRsqDto userListRsqDto);
}
