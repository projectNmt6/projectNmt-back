package com.projectnmt.projectnmt.service;

import com.projectnmt.projectnmt.dto.PrincipalUserRespDto;
import com.projectnmt.projectnmt.entity.User;
import com.projectnmt.projectnmt.repository.UserMapper;
import com.projectnmt.projectnmt.security.PrincipalUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrincipalService {
    @Autowired
    UserMapper userMapper;
    public PrincipalUser getPrincipal() {
        User user = userMapper.findUserTest();
        return user.toPrincipalUser();
    }
}
