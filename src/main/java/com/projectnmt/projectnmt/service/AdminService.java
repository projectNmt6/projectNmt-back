package com.projectnmt.projectnmt.service;

import com.projectnmt.projectnmt.entity.AdminUser;
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
        return adminMapper.userList();
    }
}
