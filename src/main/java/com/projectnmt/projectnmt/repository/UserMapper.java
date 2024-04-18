package com.projectnmt.projectnmt.repository;

import com.projectnmt.projectnmt.dto.resp.MessageRespDto;
import com.projectnmt.projectnmt.entity.OAuth2;
import com.projectnmt.projectnmt.entity.TeamMember;
import com.projectnmt.projectnmt.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    public User findUserTest();
    public User findUserByUsername(String username);
    public int saveUser(User user);
    public int saveRole(int userId, int roleId);
    public int deleteAuthority(int userId);
    public List<MessageRespDto> getMessageList(int userId);
    public int deleteUserByUserId (Integer userId);
    public User findUserByUserId(int userId);
    public List<TeamMember> findTeamMemberByUserId(int userId);
    public int deleteTeamByTeamId(int TeamId);
    public int deleteTeamMemberByTeamId(int TeamId);
    public int deleteTeamMemberByUserId(int TeamId);
    public int deleteOAuth2ByUserId(int userId);
    public List<TeamMember> findTeamMemberListByTeamId(int TeamId);
    public void sendMessage(int userId, String message);
    public int saveOAuth2(OAuth2 oAuth2);
    public User findUserByOAuth2name(String name);
    public int deleteMessageByUserId(int userId);
}
