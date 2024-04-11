package com.projectnmt.projectnmt.controller;


import com.projectnmt.projectnmt.dto.req.DonationListReqDto;
import com.projectnmt.projectnmt.dto.req.PageShowUpdateReqDto;
import com.projectnmt.projectnmt.entity.DonationPage;
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
    private DonationService donationService;
    @Autowired
    AdminService adminService;
    @GetMapping("/user")
    public ResponseEntity<?> getUserList() {
        List<User> userList = adminService.getUserList();
        return ResponseEntity.ok(null);
    }
    @GetMapping("/search")
    public ResponseEntity<?> searchDonation(
            @RequestParam(value = "name", defaultValue = "") String name) {
        DonationListReqDto donationListReqDto1 = new DonationListReqDto();
        donationListReqDto1.setStoryTitle(name);
        return ResponseEntity.ok(donationService.searchDonation(donationListReqDto1));
    }
    @PatchMapping("/updatePageShow")
    public ResponseEntity<?> updateDonationPageShow(@RequestBody PageShowUpdateReqDto pageShowUpdateReqDto) {
        boolean updateResult = adminService.updatePageShow(pageShowUpdateReqDto.getDonationPageId());

        if (updateResult) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}
