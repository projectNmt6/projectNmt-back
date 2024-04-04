package com.projectnmt.projectnmt.service;

import com.projectnmt.projectnmt.dto.SignInReqDto;
import com.projectnmt.projectnmt.dto.SignUpReqDto;
import com.projectnmt.projectnmt.entity.User;
import com.projectnmt.projectnmt.exception.SaveException;
import com.projectnmt.projectnmt.repository.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public boolean isDuplicatedByUsername(String username) {
        return userMapper.findUserByUsername(username) != null;
    }
    @Transactional(rollbackFor = Exception.class)
        public void signup(SignUpReqDto signupReqDto) {
        String username = signupReqDto.getUsername();
        if (isDuplicatedByUsername(username)) {
            throw new IllegalArgumentException("이미 사용 중인 아이디입니다.");
        }
        User user = signupReqDto.toEntity(passwordEncoder);
        int successCount = 0;
        successCount += userMapper.saveUser(user);
//      successCount += userMapper.saveRole(user.getUserId(), 1);
        if(successCount < 1) {
            throw new SaveException();
        }
    }

    public String signin(SignInReqDto signinReqDto) {
        User user = userMapper.findUserByUsername(signinReqDto.getUsername());
        if(user == null) {
            throw new UsernameNotFoundException("사용자 정보를 확인하세요");
        }
        if(!signinReqDto.getPassword().equals(user.getPassword())) {
            throw new BadCredentialsException("사용자 정보를 확인하세요");
        }
        return "로그인 성공!";
    }
}