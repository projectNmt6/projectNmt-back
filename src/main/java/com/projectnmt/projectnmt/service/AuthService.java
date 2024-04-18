
package com.projectnmt.projectnmt.service;

import com.projectnmt.projectnmt.dto.OAuth2SignupReqDto;
import com.projectnmt.projectnmt.dto.SignInReqDto;
import com.projectnmt.projectnmt.dto.SignUpReqDto;
import com.projectnmt.projectnmt.entity.TeamMember;
import com.projectnmt.projectnmt.entity.User;
import com.projectnmt.projectnmt.exception.SaveException;
import com.projectnmt.projectnmt.jwt.JwtProvider;
import com.projectnmt.projectnmt.repository.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AuthService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private JwtProvider jwtProvider;

    public boolean isDuplicatedByUsername(String username) {
        return userMapper.findUserByUsername(username) != null;
    }

    @Transactional(rollbackFor = Exception.class)
    public void signup(SignUpReqDto signupReqDto) {
        String username = signupReqDto.getUsername();
        if (isDuplicatedByUsername(username)) {
            throw new IllegalArgumentException("이미 사용 중인 아이디입니다.");
        }
        int successCount = 0;
        User user = signupReqDto.toEntity(passwordEncoder);
        successCount += userMapper.saveUser(user);
        successCount += userMapper.saveRole(user.getUserId(), 1);
            if(successCount < 1) {
                throw new SaveException();
        }
    }
    @Transactional(rollbackFor = Exception.class)
    public String oAuth2Signup(OAuth2SignupReqDto oAuth2SignupReqDto) {
        int successCount = 0;
        User user = oAuth2SignupReqDto.toEntity(passwordEncoder);
        successCount += userMapper.saveUser(user);
        successCount += userMapper.saveRole(user.getUserId(), 1);
        successCount += userMapper.saveOAuth2(oAuth2SignupReqDto.toOAuth2Entity(user.getUserId()));
        User oauth2user = userMapper.findUserByOAuth2name(user.getUsername());
        if(successCount < 3) {
            throw new SaveException();

        }

        return jwtProvider.generateToken(oauth2user);
    }

    public String signin(SignInReqDto signinReqDto) {
        User user = userMapper.findUserByUsername(signinReqDto.getUsername());
        System.out.println(user);
        if(user == null) {
            throw new UsernameNotFoundException("사용자 정보를 확인하세요");
        }
        if (!passwordEncoder.matches(signinReqDto.getPassword(), user.getPassword())) {
            throw new BadCredentialsException("사용자 정보를 확인하세요.");
        }
        return jwtProvider.generateToken(user);
    }

    public void signout(int userId) {
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
                        userMapper.sendMessage(mem.getUserId(), "리더의 탈퇴로 팀이 해산되었습니다.");
                    }
                }
            } else {
                userMapper.deleteTeamMemberByUserId(userId);
            }
        }
    }
}
