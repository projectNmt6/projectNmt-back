package com.projectnmt.projectnmt.controller;

import com.projectnmt.projectnmt.dto.req.DonationPageReqDto;
import com.projectnmt.projectnmt.service.DonationPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/main")
public class DonationController {

    @Autowired
    private DonationPageService donationPageService;

    @PostMapping("/write")
    public ResponseEntity<?> saveDonationPage(
            @Valid @RequestBody DonationPageReqDto donationPageReqDto,
            BindingResult bindingResult) {

        donationPageService.saveDonationPage(donationPageReqDto);

        return ResponseEntity.created(null).body(donationPageReqDto);
    }


}
