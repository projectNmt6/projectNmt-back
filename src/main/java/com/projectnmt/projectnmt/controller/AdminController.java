package com.projectnmt.projectnmt.controller;


import com.projectnmt.projectnmt.dto.req.SearchTeamListDto;
import com.projectnmt.projectnmt.entity.Team;
import com.projectnmt.projectnmt.entity.User;
import com.projectnmt.projectnmt.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminService adminService;
    @GetMapping("/user")
    public ResponseEntity<?> getUserList() {
        List<User> userList = adminService.getUserList();
        return ResponseEntity.ok(null);
    }
}
