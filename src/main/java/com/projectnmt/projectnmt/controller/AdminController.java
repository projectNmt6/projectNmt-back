package com.projectnmt.projectnmt.controller;


import com.projectnmt.projectnmt.dto.req.AdminMessageReqDto;
import com.projectnmt.projectnmt.dto.req.SearchTeamListDto;
import com.projectnmt.projectnmt.dto.resp.CommentListRespDto;
import com.projectnmt.projectnmt.entity.*;
import com.projectnmt.projectnmt.entity.User;
import com.projectnmt.projectnmt.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminService adminService;
    @GetMapping("/user/list")
    public ResponseEntity<?> getUserList() {
        List<AdminUser> userList = adminService.getUserList();
            return ResponseEntity.ok(userList);
    }
    @GetMapping("/user")
    public ResponseEntity<?> getUser(int userId) {
        AdminUser findUser = adminService.getUser(userId);
        return ResponseEntity.ok(findUser);
    }
    @GetMapping("/comment")
    public ResponseEntity<?> getCommentList(int userId) {
        List<CommentListRespDto> commentList = adminService.getCommentList(userId);
        return ResponseEntity.ok(commentList);
    }
    @DeleteMapping("/comment/delete")
    public ResponseEntity<?> deleteCommentList(@RequestBody List<Integer> deleteComments) {
        adminService.deleteCommemt(deleteComments);
        return ResponseEntity.ok(null);
    }

    @PostMapping("/user/role")
    public ResponseEntity<?> postUserRole(@RequestBody Authority authority) {
        adminService.addRole(authority);
        return ResponseEntity.ok(null);
    }
    @PostMapping("/message")
    public ResponseEntity<?> postMessage(@RequestBody AdminMessageReqDto adminMessageReqDto) {
        System.out.println(adminMessageReqDto);
        adminService.sendMessage(adminMessageReqDto);
        return ResponseEntity.ok(null);
    }
    @GetMapping("/teams")
    public ResponseEntity<?> getTeamList() {
        return ResponseEntity.ok(adminService.getTeamList());
    }

    @DeleteMapping("/team/delete")
    public ResponseEntity<?> deleteTeamList(@RequestBody List<Integer> teamIds) {
        adminService.deleteTeams(teamIds);
        return ResponseEntity.ok(null);
    }
}
