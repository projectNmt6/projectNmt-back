package com.projectnmt.projectnmt.controller;

import com.projectnmt.projectnmt.dto.req.DonationPageReqDto;
import com.projectnmt.projectnmt.dto.resp.DonationMainTag.DonationMainTagReqDto;
import com.projectnmt.projectnmt.service.DonationPageService;
import com.projectnmt.projectnmt.dto.DonationListReqDto;
import com.projectnmt.projectnmt.dto.DonationTagReqDto;
import com.projectnmt.projectnmt.service.DonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/main")
public class DonationController {

    @Autowired
    private DonationService donationService;


    @Autowired
    private DonationPageService donationPageService;

    @PostMapping("/write")
    public ResponseEntity<?> saveDonationPage(
            @Valid @RequestBody DonationPageReqDto donationPageReqDto,
            BindingResult bindingResult) {

        donationPageService.saveDonationPage(donationPageReqDto);

        return ResponseEntity.created(null).body(donationPageReqDto);
    }

    @PostMapping("/review")
    public ResponseEntity<?> saveReviewPage(
            @Valid @RequestBody DonationPageReqDto donationPageReqDto,
            BindingResult bindingResult) {

        donationPageService.saveDonationPage(donationPageReqDto);

        return ResponseEntity.created(null).body(donationPageReqDto);
    }



    @GetMapping("/donations")
    public ResponseEntity<?> DonationList(DonationListReqDto donationListReqDto) {
        return ResponseEntity.ok(donationService.getDonationList(donationListReqDto));
    };

    @GetMapping("/donationtag")
    public ResponseEntity<?> DonationTag(DonationTagReqDto donationTagReqDto) {
        return ResponseEntity.ok(donationService.getDonationTagList(donationTagReqDto));
    };

    @GetMapping("/storytypes")
    public ResponseEntity<?> getMainType(DonationMainTagReqDto donationMainTagReqDto) {
        return ResponseEntity.ok(donationService.getMainCategoryList(donationMainTagReqDto));
    }

}
