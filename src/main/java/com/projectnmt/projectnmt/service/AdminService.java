package com.projectnmt.projectnmt.service;

import com.projectnmt.projectnmt.dto.req.PageShowUpdateReqDto;
import com.projectnmt.projectnmt.entity.User;
import com.projectnmt.projectnmt.repository.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    AdminMapper adminMapper;

    public List<User> getUserList() {
        return adminMapper.userList();
    }

    public Boolean updatePageShow(int donationPageId) {

        try {
            adminMapper.updatePageShow(donationPageId);
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
