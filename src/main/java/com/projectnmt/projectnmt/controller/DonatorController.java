package com.projectnmt.projectnmt.controller;

import com.projectnmt.projectnmt.dto.req.DonationPageReqDto;
import com.projectnmt.projectnmt.dto.req.DonatorListReqDto;
import com.projectnmt.projectnmt.service.DonatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DonatorController {
    @Autowired
    private DonatorService donatorService;
    @Autowired
    private DonatorListReqDto donatorListReqDto;
    @GetMapping("/donator")
    public ResponseEntity<?> DonatorList(){
        return ResponseEntity.ok(donatorService.getDonatorList(donatorListReqDto));
    };
}
