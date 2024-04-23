package com.projectnmt.projectnmt.controller;

import com.projectnmt.projectnmt.dto.req.*;
import com.projectnmt.projectnmt.dto.resp.ChallengePageListRespDto;
import com.projectnmt.projectnmt.dto.resp.ChallengePageRespDto;
import com.projectnmt.projectnmt.dto.resp.DonationPageRespDto;
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

    @PutMapping("/challenge/update/{page}")
    public ResponseEntity<?> updatePage(@PathVariable("page") int page, @RequestBody ChallengeUpdatePageReqDto challengeUpdatePageReqDto) {
        challengeUpdatePageReqDto.setChallengePageId(page);
        challengeService.updateChallengePage(challengeUpdatePageReqDto);
        return ResponseEntity.ok(true);
    }

    @GetMapping("/challenge/update/{page}")
    public ResponseEntity<?> getUpdatePage(@PathVariable("page") int page) {
        ChallengePageReqDto challengePageReqDto = new ChallengePageReqDto();
        challengePageReqDto.setChallengePageId(page);
        ChallengePageRespDto challengePageRespDto = challengeService.getChallengePage(challengePageReqDto);
        return ResponseEntity.ok(challengePageRespDto);
    }

    @DeleteMapping("/challenge/{id}")
    public ResponseEntity<?> deleteChallengePage(@PathVariable("id") int challengePageId) {
        challengeService.deleteChallengePage(challengePageId);
        return ResponseEntity.ok().build();
    }

}
