package com.projectnmt.projectnmt.controller;

import com.projectnmt.projectnmt.dto.AmountRespDto;
import com.projectnmt.projectnmt.dto.req.DonationGivingReqDto;
import com.projectnmt.projectnmt.dto.req.*;
import com.projectnmt.projectnmt.dto.resp.*;
import com.projectnmt.projectnmt.dto.ProgressAmountReqDto;
import com.projectnmt.projectnmt.dto.ProgressAmountRespDto;
import com.projectnmt.projectnmt.dto.req.DonationPageReqDto;
import com.projectnmt.projectnmt.security.PrincipalUser;
import com.projectnmt.projectnmt.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/main")

public class DonationController {

    @Autowired
    private DonationService donationService;

    @Autowired
    private DonationPageService donationPageService;

    @Autowired
    private DonationNewsPageService donationNewsPageService;

    @Autowired
    private DonationGivingService donationGivingService;

    @Autowired
    private SearchPageService searchPageService;

    @PostMapping("/write")
    public ResponseEntity<?> saveDonationPage(@Valid @RequestBody DonationPageReqDto donationPageReqDto,
                                              @AuthenticationPrincipal PrincipalUser currentUser, BindingResult bindingResult) throws IllegalAccessException {
        donationPageService.saveDonationPage(donationPageReqDto);
        return ResponseEntity.created(null).body(donationPageReqDto);
    }


    @GetMapping("/donation/news/{page}")
    public ResponseEntity<?> getDonationNews(@PathVariable("page") int page) {
        DonationNewsPageRespDto response = donationNewsPageService.getDonationNewsByPageId(page);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/donation")
    public ResponseEntity<?> DonationStory(@RequestParam(value = "page", defaultValue = "1") int page) {
        DonationPageReqDto donationPageReqDto = new DonationPageReqDto();
        donationPageReqDto.setDonationPageId(page);
        return ResponseEntity.ok(donationPageService.getDonationPage(donationPageReqDto));
    };

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


    @PostMapping("/test")
    public ResponseEntity<?> givingDonation(@RequestBody DonationGivingReqDto donationGivingReqDto) {
        donationGivingService.processDonation(donationGivingReqDto);
        return ResponseEntity.created(null).body(donationGivingReqDto);
    }



    @GetMapping("/donation/news/update/{page}")
    public ResponseEntity<?> getNewsPageUpdate(@PathVariable("page") int page) {
        DonationNewsPageReqDto donationNewsPageRepDto = new DonationNewsPageReqDto();
        donationNewsPageRepDto.setDonationPageId(page);
        DonationNewsPageRespDto donationNewsPageRespDto = donationNewsPageService.getDonationNews(donationNewsPageRepDto);
        System.out.println(donationNewsPageRespDto);
        return ResponseEntity.ok(donationNewsPageRespDto);
    }

    @GetMapping("/donation/update/{page}")
    public ResponseEntity<?> getPageUpdate(@PathVariable("page") int page) {

        DonationPageReqDto donationPageReqDto = new DonationPageReqDto();
        donationPageReqDto.setDonationPageId(page);
        DonationPageRespDto donationPageRespDto = donationPageService.getDonationPage(donationPageReqDto);
        return ResponseEntity.ok(donationPageRespDto);
    }

    @PostMapping("/donation/news/{page}")
    public ResponseEntity<?> saveDonationNewsPage(@PathVariable("page") int page,
                                                  @Valid @RequestBody DonationNewsPageReqDto donationNewsPageReqDto,
                                                  BindingResult bindingResult) throws IllegalAccessException {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }
        donationNewsPageReqDto.setDonationPageId(page);
        System.out.println("work");
        donationNewsPageService.saveDonationNewsPage(donationNewsPageReqDto, page);

        return ResponseEntity.ok(donationNewsPageReqDto);
    }


    @PutMapping("/donation/update/{page}")
    public ResponseEntity<?> updatePage(@PathVariable("page") int page,
                                        @RequestBody DonationPageUpdateReqDto donationPageUpdateReqDto
                                        ) throws IllegalAccessException {
        donationPageUpdateReqDto.setDonationPageId(page);
            donationPageService.updatePage(donationPageUpdateReqDto);
            return ResponseEntity.ok(true);

    }
    @PutMapping("/donation/news/update/{page}")
    public ResponseEntity<?> updateNewsPage(@PathVariable("page") int page,
                                            @RequestBody DonationNewsUpdateReqDto donationNewsUpdateReqDto
                                            ) throws IllegalAccessException {

        donationNewsUpdateReqDto.setDonationPageId(page);
        donationNewsPageService.updateNewsPage(donationNewsUpdateReqDto);
        return ResponseEntity.ok(true);
    }

    @DeleteMapping("/donation/{id}")
    public ResponseEntity<?> deleteDonationPage(@PathVariable("id") int donationPageId
           ) throws IllegalAccessException {
            donationPageService.deleteDonationPage(donationPageId);
            return ResponseEntity.ok().build();

    }

    @GetMapping("donation/fundings/now")
    public ResponseEntity<List<DonationListRespDto>> getCurrentFundraisings() {
        List<DonationListRespDto> campaigns = donationService.getCurrentFundings();
        return ResponseEntity.ok(campaigns);
    }

    @GetMapping("donation/fundings/end")
    public ResponseEntity<List<DonationListRespDto>> getEndedFundraisings() {
        List<DonationListRespDto> campaigns = donationService.getEndedFundings();
        return ResponseEntity.ok(campaigns);
    }


    @GetMapping("/amount")
    public ResponseEntity<?> getAmount() {
        AmountRespDto amountRespDto = donationPageService.MainAmount();
        return ResponseEntity.ok(amountRespDto);
    }
    @GetMapping("/progress")
    public ResponseEntity<?> getprogress(ProgressAmountReqDto progressAmountReqDto) {
        ProgressAmountRespDto amountRespDto = donationPageService.Homeprogressdonation(progressAmountReqDto);
        return ResponseEntity.ok(amountRespDto);
    }

    @GetMapping("/donators/{donationPageId}")
    public ResponseEntity<List<DonationGivingRespDto>> getDonatorGivingListByDonationPageId(@PathVariable int donationPageId) {
        List<DonationGivingRespDto> givingList = donationGivingService.getDonationGivingByDonationPageId(donationPageId);
        return ResponseEntity.ok(givingList);
    }


}