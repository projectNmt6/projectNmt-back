package com.projectnmt.projectnmt.service;

import com.projectnmt.projectnmt.dto.AdminTeamListReqDto;
import com.projectnmt.projectnmt.dto.TeamListReqDto;
import com.projectnmt.projectnmt.dto.UserCountRespDto;
import com.projectnmt.projectnmt.dto.UserListRsqDto;
import com.projectnmt.projectnmt.dto.req.AdminDonationListReqDto;
import com.projectnmt.projectnmt.dto.req.AdminMessageReqDto;
import com.projectnmt.projectnmt.dto.req.DonationListReqDto;
import com.projectnmt.projectnmt.dto.resp.CommentListRespDto;
import com.projectnmt.projectnmt.dto.resp.DonationListRespDto;
import com.projectnmt.projectnmt.entity.*;
import com.projectnmt.projectnmt.repository.AdminMapper;
import com.projectnmt.projectnmt.repository.TeamMapper;
import com.projectnmt.projectnmt.repository.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminService {

    @Autowired
    AdminMapper adminMapper;

    @Autowired
    UserMapper userMapper;

    @Autowired
    TeamMapper teamMapper;

    public List<AdminUser> getUserList(UserListRsqDto userListRsqDto) {
        List<AdminUser> list = List.of();
        userListRsqDto.setPageNumber((userListRsqDto.getPageNumber() - 1) * 10);
        if(userListRsqDto.getSelectedRoleoption() == 0) {
            list = adminMapper.findUserList(userListRsqDto);
            for(AdminUser user : list) {
                List<Role> roleList = adminMapper.findRoleList(user.getUserId());
                List<Role> max = new ArrayList<>();
                Role maxRole = Role.builder().build();
                for (Role role : roleList) {
                    maxRole = maxRole.getRoleId() > role.getRoleId() ? maxRole : role;
                }
                max.add(maxRole);
                user.setRole(max);
            }
        } else {
            list = adminMapper.findUserListForRoleSelect(userListRsqDto);
            userListRsqDto.setSearchCount(userListRsqDto.getSearchCount() + userListRsqDto.getPageNumber());
            int lastNum = list.size() < userListRsqDto.getSearchCount() ? list.size() :userListRsqDto.getSearchCount();
            list = list.subList(userListRsqDto.getPageNumber(), lastNum);
        }
        return list;
    }
    public UserCountRespDto getUserCount(UserListRsqDto userListRsqDto) {
        int count = 0;
        if(userListRsqDto.getSelectedRoleoption() == 0) {
            count = adminMapper.getUserCount(userListRsqDto);
        } else {

        }
        int MaxPageNumber = (int)Math.ceil(((double) count) / userListRsqDto.getSearchCount());
        return UserCountRespDto.builder()
                .maxPageNumber(MaxPageNumber)
                .totalCount(count)
                .build();
    }
    public UserCountRespDto getTeamCount(AdminTeamListReqDto adminTeamListReqDto) {
        int count = adminMapper.getTeamCount(adminTeamListReqDto);
        int MaxPageNumber = (int)Math.ceil(((double) count) / adminTeamListReqDto.getSearchCount());
        return UserCountRespDto.builder()
                .maxPageNumber(MaxPageNumber)
                .totalCount(count)
                .build();
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
            adminMapper.deleteReport(commentId);
        }
    }
    public void addRole(Authority authority) {
        adminMapper.addRole(authority);
    }

    public void sendMessage(AdminMessageReqDto adminMessageReqDto) {
        for(int userId : adminMessageReqDto.getUserId()) {
            adminMapper.sendMessage(userId, adminMessageReqDto.getIsTeam(), adminMessageReqDto.getMessage(), adminMessageReqDto.getSenderId());
        }
    }

    public List<Team> getTeamList(AdminTeamListReqDto adminTeamListReqDto) {
        adminTeamListReqDto.setPageNumber((adminTeamListReqDto.getPageNumber() - 1) * 10);
        List<Team> list = new ArrayList<>();
        if(adminTeamListReqDto.getUserId() != 0) {
            list = teamMapper.teamList(adminTeamListReqDto.getUserId());
            for (Team team : list) {
                List<TeamMember> teamMembers = teamMapper.findMemberByTeamId(team.getTeamId());
                List<Account> accounts = teamMapper.getAccountListByTeamId(team.getTeamId());
                team.setTeamMembers(teamMembers);
                team.setAccounts(accounts);
            }
        } else {
            list = adminMapper.getTeamList(adminTeamListReqDto);
            for (Team team : list) {
                List<TeamMember> teamMembers = teamMapper.findMemberByTeamId(team.getTeamId());
                List<Account> accounts = teamMapper.getAccountListByTeamId(team.getTeamId());
                team.setTeamMembers(teamMembers);
                team.setAccounts(accounts);
            }
        }
        return list;
    }

    public void deleteTeams(List<Team> teamList) {
        for(Team team : teamList) {
            adminMapper.deleteTeamListByTeamIds(team.getTeamId());
            TeamMember member = adminMapper.findTeamMemberListByTeamId(team.getTeamId());
            adminMapper.sendMessage(member.getUserId(), 0,"관리자에 의해 팀"+team.getTeamName()+"이(가) 해체되었습니다.", 0);
        }
    }
    public int updatePageShow(List<DonationPage> donationPageList) {
        int num = 0;
        for (DonationPage donationPage : donationPageList) {
            num += adminMapper.updatePageShow(donationPage.getDonationPageId());
        }
        return num;
    }
    public void signout(List<Integer> userIds) {
        for (int userId : userIds) {
            userMapper.deleteUserByUserId(userId);
            userMapper.deleteAuthority(userId);
            List<TeamMember> userTeamList = userMapper.findTeamMemberByUserId(userId);
            userMapper.deleteOAuth2ByUserId(userId);
            for (TeamMember team : userTeamList) {
                if(team.getTeamRoleId() == 1) {
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
    public List<DonationListRespDto> getDonationList(AdminDonationListReqDto adminDonationListReqDto) {
        adminDonationListReqDto.setPageId((adminDonationListReqDto.getPageId() - 1) * adminDonationListReqDto.getSearchCount());
        List<Donation> donations = adminMapper.getDonationList(adminDonationListReqDto);
        return donations.stream().map(Donation::toDonationListRespDto).collect(Collectors.toList());
    }

    public UserCountRespDto getStoryCount(AdminDonationListReqDto adminDonationListReqDto) {
        int count = adminMapper.getDonationCount(adminDonationListReqDto);
        int MaxPageNumber = (int)Math.ceil(((double) count) / adminDonationListReqDto.getSearchCount());
        return UserCountRespDto.builder()
                .maxPageNumber(MaxPageNumber)
                .totalCount(count)
                .build();
    }

    public void deleteDonation(List<Donation> list) {
        for(Donation donation : list) {
            adminMapper.deleteCommemtByPageId(donation.getDonationPageId());
            adminMapper.deleteDonationImage(donation.getDonationPageId());
            adminMapper.deleteLikeByPageId(donation.getDonationPageId());
            adminMapper.deleteDonation(donation.getDonationPageId());
        }
    }
}
