package com.projectnmt.projectnmt.controller;

import com.projectnmt.projectnmt.dto.DonationListReqDto;
import com.projectnmt.projectnmt.service.DonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/main")
public class DonationController {
    @Autowired
    private DonationService donationService;
    @GetMapping("/donations")
    public ResponseEntity<?> DonationList(DonationListReqDto donationListReqDto) {
        return ResponseEntity.ok(donationService.getDonationList(donationListReqDto));
    };


}
