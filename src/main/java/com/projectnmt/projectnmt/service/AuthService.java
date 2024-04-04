package com.projectnmt.projectnmt.service;

import com.projectnmt.projectnmt.dto.SignUpReqDto;
import com.projectnmt.projectnmt.entity.User;
import com.projectnmt.projectnmt.exception.SaveException;
import com.projectnmt.projectnmt.repository.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Transactional(rollbackFor = Exception.class)
        public void signup(SignUpReqDto signupReqDto) {
        int successCount = 0;
        System.out.println(signupReqDto);
        User user = signupReqDto.toEntity(passwordEncoder);

        successCount += userMapper.saveUser(user);
//      successCount += userMapper.saveRole(user.getUserId(), 1);

        if(successCount < 1) {
            throw new SaveException();
        }
    }
}