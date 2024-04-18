package com.projectnmt.projectnmt.controller;

import com.projectnmt.projectnmt.dto.AmountRespDto;
import com.projectnmt.projectnmt.dto.DonationGivingReqDto;
import com.projectnmt.projectnmt.dto.req.*;
import com.projectnmt.projectnmt.dto.resp.CommentRespDto;
import com.projectnmt.projectnmt.dto.resp.DonationListRespDto;
import com.projectnmt.projectnmt.dto.resp.DonationMainTag.DonationMainTagReqDto;
import com.projectnmt.projectnmt.dto.resp.DonationNewsPageRespDto;
import com.projectnmt.projectnmt.entity.DonationNewsPage;
import com.projectnmt.projectnmt.dto.ProgressAmountReqDto;
import com.projectnmt.projectnmt.dto.ProgressAmountRespDto;
import com.projectnmt.projectnmt.dto.req.DonationPageReqDto;
import com.projectnmt.projectnmt.dto.resp.DonationMainTag.DonationMainTagReqDto;
import com.projectnmt.projectnmt.entity.Donator;
import com.projectnmt.projectnmt.service.DonationGivingService;
import com.projectnmt.projectnmt.dto.resp.DonationPageRespDto;
import com.projectnmt.projectnmt.service.DonationNewsPageService;
import com.projectnmt.projectnmt.service.DonationPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import com.projectnmt.projectnmt.service.DonationService;

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

    @PostMapping("/write")
    public ResponseEntity<?> saveDonationPage(@Valid @RequestBody DonationPageReqDto donationPageReqDto, BindingResult bindingResult) {
        donationPageService.saveDonationPage(donationPageReqDto);

        return ResponseEntity.created(null).body(donationPageReqDto);
    }

    @PostMapping("/donation/review")
    public ResponseEntity<?> saveReviewPage(
            @Valid @RequestBody DonationPageReqDto donationPageReqDto,
            BindingResult bindingResult) {
        donationPageService.saveDonationPage(donationPageReqDto);
        return ResponseEntity.created(null).body(donationPageReqDto);
    }

    @PostMapping("/donation/news/{page}")
    public ResponseEntity<?> saveDonationNewsPage(@PathVariable("page") int page,
            @Valid @RequestBody DonationPageReqDto donationPageReqDto,
            BindingResult bindingResult) {
        donationPageReqDto.setDonationPageId(page);
        donationPageService.saveDonationPage(donationPageReqDto);

        return ResponseEntity.created(null).body(donationPageReqDto);
    }

    @PostMapping("/donation/donationnews")
    public ResponseEntity<?> saveDonationNews(@RequestBody DonationNewsPageReqDto donationNewsPageReqDto) {
        donationNewsPageService.saveDonationNewsPage(donationNewsPageReqDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/donation/news/{page}")
    public ResponseEntity<?> getDonationNews(@PathVariable("page") int page) {
        DonationNewsPageRespDto response = donationNewsPageService.getDonationNewsByPageId(page);
        if (response == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(response);
    }

    @GetMapping("/donation")
    public ResponseEntity<?> DonationStory(@RequestParam(value = "page", defaultValue = "1") int page) {
        DonationPageReqDto donationPageReqDto = new DonationPageReqDto();
        donationPageReqDto.setDonationPageId(page);
        System.out.println(page);
        return ResponseEntity.ok(donationPageService.getDonationPage(donationPageReqDto));
    };

    @GetMapping("/donations")
    public ResponseEntity<?> DonationList(DonationListReqDto donationListReqDto) {
        return ResponseEntity.ok(donationService.getDonationList(donationListReqDto));
    };

    @GetMapping("/donations/challenge")
    public ResponseEntity<?> ChallengeList(DonationListReqDto donationListReqDto) {
        System.out.println(donationListReqDto);
        return ResponseEntity.ok(donationService.getChallengeList(donationListReqDto));
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

    @PutMapping("/donation/news/update/{page}")
    public ResponseEntity<?> updateNewsPage(@PathVariable("page") int page, @RequestBody DonationNewsUpdateReqDto donationNewsUpdateReqDto) {
        donationNewsUpdateReqDto.setDonationNewsPageId(page);
        donationNewsPageService.updateNewsPage(donationNewsUpdateReqDto);
        return ResponseEntity.ok(true);
    }

    @GetMapping("/donation/news/update/{page}")
    public ResponseEntity<?> getNewsPageUpdate(@PathVariable("page") int page) {
        DonationNewsPageReqDto donationNewsPageReqDto = new DonationNewsPageReqDto();
        donationNewsPageReqDto.setDonationNewsPageId(page);
        DonationNewsPageRespDto donationNewsPageRespDto = donationNewsPageService.getDonationNews(donationNewsPageReqDto);
        if (donationNewsPageRespDto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(donationNewsPageRespDto);
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
        System.out.println(progressAmountReqDto);
        ProgressAmountRespDto amountRespDto = donationPageService.Homeprogressdonation(progressAmountReqDto);
        return ResponseEntity.ok(amountRespDto);
    }
}
