package com.projectnmt.projectnmt.controller;


import com.projectnmt.projectnmt.dto.req.DonationImageReqDto;
import com.projectnmt.projectnmt.dto.resp.DonationImageRespDto;
import com.projectnmt.projectnmt.service.DonationImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/donation")
public class DonationImageController {

    @Autowired
    private DonationImageService donationImageService;

    @PostMapping("/image/upload")
    public ResponseEntity<?> saveDonationImage(@Valid @RequestBody DonationImageReqDto donationImageReqDto, BindingResult bindingResult) {
        donationImageService.saveDonationImage(donationImageReqDto);
        return ResponseEntity.created(null).body(donationImageReqDto);
    }


}
