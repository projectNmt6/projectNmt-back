package com.projectnmt.projectnmt.service;

import com.projectnmt.projectnmt.dto.req.AdminMessageReqDto;
import com.projectnmt.projectnmt.entity.AdminUser;
import com.projectnmt.projectnmt.entity.Authority;
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
    public void addRole(Authority authority) {
        adminMapper.addRole(authority);
    }
    public void sendMessage(AdminMessageReqDto adminMessageReqDto) {
        for(int userId : adminMessageReqDto.getUserId()) {
            adminMapper.sendMessage(userId, adminMessageReqDto.getMessage());
        }
    }
}
