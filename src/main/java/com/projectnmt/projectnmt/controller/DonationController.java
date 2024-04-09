package com.projectnmt.projectnmt.controller;

import com.projectnmt.projectnmt.dto.DonationGivingReqDto;
import com.projectnmt.projectnmt.dto.req.DonationPageReqDto;
import com.projectnmt.projectnmt.dto.resp.DonationMainTag.DonationMainTagReqDto;
import com.projectnmt.projectnmt.service.DonationGivingService;
import com.projectnmt.projectnmt.dto.req.DonationPageUpdateReqDto;
import com.projectnmt.projectnmt.dto.resp.DonationPageRespDto;
import com.projectnmt.projectnmt.service.DonationPageService;
import com.projectnmt.projectnmt.dto.req.DonationListReqDto;
import com.projectnmt.projectnmt.dto.req.DonationTagReqDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import com.projectnmt.projectnmt.service.DonationService;

@RestController
@RequestMapping("/main")
public class DonationController {

    @Autowired
    private DonationService donationService;

    @Autowired
    private DonationPageService donationPageService;

    @Autowired
    private DonationGivingService donationGivingService;

    @PostMapping("/write")
    public ResponseEntity<?> saveDonationPage(@Valid @RequestBody DonationPageReqDto donationPageReqDto, BindingResult bindingResult) {
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

    @GetMapping("/search")
    public ResponseEntity<?> searchDonation(
            @RequestParam(value = "name", defaultValue = "") String name) {
        DonationListReqDto donationListReqDto1 = new DonationListReqDto();
        donationListReqDto1.setStoryTitle(name);
        return ResponseEntity.ok(donationService.searchDonation(donationListReqDto1));
    };

    @GetMapping("/donationtag")
    public ResponseEntity<?> DonationTag(DonationTagReqDto donationTagReqDto) {
        return ResponseEntity.ok(donationService.getDonationTagList(donationTagReqDto));
    };

    @GetMapping("/donation")
    public ResponseEntity<?> DonationStory(@RequestParam(value = "page", defaultValue = "1") int page) {
        DonationPageReqDto donationPageReqDto = new DonationPageReqDto();
        donationPageReqDto.setDonationPageId(page);
        System.out.println(page);
        return ResponseEntity.ok(donationPageService.getDonationPage(donationPageReqDto));
    };

    @GetMapping("/storytypes")
    public ResponseEntity<?> getMainType(DonationMainTagReqDto donationMainTagReqDto) {
        return ResponseEntity.ok(donationService.getMainCategoryList(donationMainTagReqDto));
    }

    @PostMapping("/test")
    public ResponseEntity<?> givingDonation(@RequestBody DonationGivingReqDto donationGivingReqDto) {
        donationGivingService.processDonation(donationGivingReqDto);
        return ResponseEntity.created(null).body(donationGivingReqDto);
    }

    @PutMapping("/donation/update/{page}")
    public ResponseEntity<?> updatePage(@PathVariable("page") int page, @RequestBody DonationPageUpdateReqDto donationPageUpdateReqDto) {
        donationPageUpdateReqDto.setDonationPageId(page);
        donationPageService.updatePage(donationPageUpdateReqDto);
        return ResponseEntity.ok(true);
    }


    @GetMapping("/donation/update/{page}")
    public ResponseEntity<?> getPageUpdate(@PathVariable("page") int page) {
        DonationPageReqDto donationPageReqDto = new DonationPageReqDto();
        donationPageReqDto.setDonationPageId(page);
        DonationPageRespDto donationPageRespDto = donationPageService.getDonationPage(donationPageReqDto);
        return ResponseEntity.ok(donationPageRespDto);
    }

    @DeleteMapping("/donation/{id}")
    public ResponseEntity<?> deleteDonationPage(@PathVariable("id") int donationPageId) {
        donationPageService.deleteDonationPage(donationPageId);
        return ResponseEntity.ok().build();
    }
}
