package com.projectnmt.projectnmt.controller;


import com.projectnmt.projectnmt.dto.AdminTeamListReqDto;
import com.projectnmt.projectnmt.dto.TeamListReqDto;
import com.projectnmt.projectnmt.dto.UserListRsqDto;
import com.projectnmt.projectnmt.dto.req.*;
import com.projectnmt.projectnmt.dto.resp.CommentListRespDto;
import com.projectnmt.projectnmt.entity.*;
import com.projectnmt.projectnmt.entity.User;
import com.projectnmt.projectnmt.service.AdminService;
import com.projectnmt.projectnmt.service.DonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminService adminService;
    @Autowired
    DonationService donationService;
    @GetMapping("/user/list")
    public ResponseEntity<?> getUserList(UserListRsqDto userListRsqDto) {
        List<AdminUser> userList = adminService.getUserList(userListRsqDto);
        return ResponseEntity.ok(userList);
    }
    @GetMapping("/user")
    public ResponseEntity<?> getUser(int userId) {
        AdminUser findUser = adminService.getUser(userId);
        return ResponseEntity.ok(findUser);
    }
    @GetMapping("/comment")
    public ResponseEntity<?> getCommentList(@RequestParam(defaultValue = "0") int userId) {
        List<CommentListRespDto> commentList = adminService.getCommentList(userId);
        return ResponseEntity.ok(commentList);
    }
    @GetMapping("/user/count")
    public ResponseEntity<?> getCount(UserListRsqDto userListRsqDto) {
        return ResponseEntity.ok(adminService.getUserCount(userListRsqDto));
    }

    @DeleteMapping("/comment/delete")
    public ResponseEntity<?> deleteCommentList(@RequestBody List<Integer> deleteComments) {
        adminService.deleteCommemt(deleteComments);
        return ResponseEntity.ok(null);
    }
    @DeleteMapping("/user/delete")
    public ResponseEntity<?> deleteUserList(@RequestBody List<Integer> userId) {
        adminService.signout(userId);
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
    public ResponseEntity<?> getTeamList(AdminTeamListReqDto adminTeamListReqDto) {
        return ResponseEntity.ok(adminService.getTeamList(adminTeamListReqDto));
    }
    @GetMapping("/team/count")
    public ResponseEntity<?> getTeamCount(AdminTeamListReqDto adminTeamListReqDto) {
        return ResponseEntity.ok(adminService.getTeamCount(adminTeamListReqDto));
    }
    @DeleteMapping("/team/delete")
    public ResponseEntity<?> deleteTeamList(@RequestBody List<Team> teamList) {
        adminService.deleteTeams(teamList);
        return ResponseEntity.ok(null);
    }
    @PutMapping("/donation/show")
    public ResponseEntity<?> updateDonaionPageToShow(@RequestBody List<DonationPage> donationPage) {
        adminService.updatePageShow(donationPage);
        return ResponseEntity.ok(null);
    }
    @GetMapping("/search")
    public ResponseEntity<?> searchDonation(
            @RequestParam(value = "name", defaultValue = "") String name) {
        DonationListReqDto donationListReqDto1 = new DonationListReqDto();
        donationListReqDto1.setStoryTitle(name);
        return ResponseEntity.ok(donationService.searchDonation(donationListReqDto1));
    }

    @GetMapping("/donations")
    public ResponseEntity<?> DonationList(AdminDonationListReqDto adminDonationListReqDto) {
        return ResponseEntity.ok(adminService.getDonationList(adminDonationListReqDto));
    };

    @GetMapping("/story/count")
    public ResponseEntity<?> getStoryCount(AdminDonationListReqDto adminDonationListReqDto) {
        return ResponseEntity.ok(adminService.getStoryCount(adminDonationListReqDto));
    }

    @DeleteMapping("/donation/delete")
    public ResponseEntity<?> deleteDonationList(@RequestBody List<Donation> list) {
        adminService.deleteDonation(list);
        return ResponseEntity.ok(null);
    }

}