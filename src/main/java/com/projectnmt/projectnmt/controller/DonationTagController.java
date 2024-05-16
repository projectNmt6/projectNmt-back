package com.projectnmt.projectnmt.controller;

import com.projectnmt.projectnmt.dto.req.DonationTagReqDto;
import com.projectnmt.projectnmt.dto.resp.DonationMainTag.DonationMainTagReqDto;
import com.projectnmt.projectnmt.entity.DonationTag;
import com.projectnmt.projectnmt.service.DonationPageService;
import com.projectnmt.projectnmt.service.DonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/main")
public class DonationTagController {
    @Autowired
    private DonationService donationService;

    @Autowired
    private DonationPageService donationPageService;


    @GetMapping("/donationtag")
    public ResponseEntity<?> DonationTag(DonationTagReqDto donationTagReqDto) {
        List<DonationTag> tagList = donationService.getDonationTagList(donationTagReqDto);
        System.out.println(tagList);
        return ResponseEntity.ok(tagList);
    };


}
