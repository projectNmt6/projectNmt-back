package com.projectnmt.projectnmt.repository;

import com.projectnmt.projectnmt.dto.AdminTeamListReqDto;
import com.projectnmt.projectnmt.dto.UserListRsqDto;
import com.projectnmt.projectnmt.dto.req.AdminDonationListReqDto;
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
    public void deleteReport(int commentId);
    public void sendMessage(int userId, int isTeam, String message, int senderId);
    public List<Team> getTeamList(AdminTeamListReqDto adminTeamListReqDto);
    public int deleteTeamListByTeamIds(int teamId);
    public TeamMember findTeamMemberListByTeamId(int teamId);
    public int updatePageShow(int donationPageId);
    public List<Role> findRoleList(int userId);
    public List<AdminUser> findUserListForRoleSelect(UserListRsqDto userListRsqDto);
    public Integer getUserCount(UserListRsqDto userListRsqDto);
    public Integer getTeamCount(AdminTeamListReqDto teamListReqDto);
    public Integer getDonationCount(AdminDonationListReqDto adminDonationListReqDto);
    public List<Donation> getDonationList(AdminDonationListReqDto adminDonationListReqDto);
    public int deleteDonation(int donationPageId);
    public void deleteCommemtByPageId(int donationPageId);
    public void deleteLikeByPageId(int donationPageId);
    public void deleteDonationImage(int donationPageId);

}
