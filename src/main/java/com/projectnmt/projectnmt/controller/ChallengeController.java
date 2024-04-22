package com.projectnmt.projectnmt.controller;

import com.projectnmt.projectnmt.dto.req.ChallengePageListReqDto;
import com.projectnmt.projectnmt.dto.req.ChallengePageReqDto;
import com.projectnmt.projectnmt.dto.req.DonationPageReqDto;
import com.projectnmt.projectnmt.dto.resp.ChallengePageListRespDto;
import com.projectnmt.projectnmt.service.ChallengeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/main")
public class ChallengeController {

    @Autowired
    private ChallengeService challengeService;

    @GetMapping("/challenges")
    public ResponseEntity<?> getChallengeList(ChallengePageListReqDto challengePageListReqDto) {
        List<ChallengePageListRespDto> challengeList = challengeService.getChallengeList(challengePageListReqDto);
        return ResponseEntity.ok(challengeList);
    }

    @PostMapping("/challenge/write")
    public ResponseEntity<?> saveChallengePage(@Valid @RequestBody ChallengePageReqDto challengePageReqDto, BindingResult bindingResult) {
        challengeService.saveChallengePage(challengePageReqDto);
        return ResponseEntity.created(null).body(challengePageReqDto);
    }

    @GetMapping("/challenge/{page}")
    public ResponseEntity<?> ChallengeMission(@PathVariable("page") int page) {
        ChallengePageReqDto challengePageReqDto = new ChallengePageReqDto();
        challengePageReqDto.setChallengePageId(page);
        return ResponseEntity.ok(challengeService.getChallengePage(challengePageReqDto));
    }



}
