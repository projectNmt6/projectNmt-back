package com.projectnmt.projectnmt.controller;

import com.projectnmt.projectnmt.dto.req.*;
import com.projectnmt.projectnmt.dto.resp.*;
import com.projectnmt.projectnmt.security.PrincipalUser;
import com.projectnmt.projectnmt.service.ChallengeNewsService;
import com.projectnmt.projectnmt.service.ChallengeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/main")
public class ChallengeController {

    @Autowired
    private ChallengeService challengeService;
    @Autowired
    private ChallengeNewsService challengeNewsService;

    @GetMapping("/challenge/search")
    public ResponseEntity<?> searchChallenge(
            @RequestParam(value = "name", defaultValue = "") String name) {
        ChallengePageListReqDto challengePageListReqDto = new ChallengePageListReqDto();
        challengePageListReqDto.setChallengeTitle(name);
        return ResponseEntity.ok(challengeService.searchChallenge(challengePageListReqDto));
    };

    @GetMapping("/challenges")
    public ResponseEntity<?> getChallengeList(ChallengePageListReqDto challengePageListReqDto) {
        List<ChallengePageListRespDto> challengeList = challengeService.getChallengeList(challengePageListReqDto);
        return ResponseEntity.ok(challengeList);
    }

    @PostMapping("/challenge/write")
    public ResponseEntity<?> saveChallengePage(@Valid @RequestBody
                                                   ChallengePageReqDto challengePageReqDto,
                                               BindingResult bindingResult) {
        challengeService.saveChallengePage(challengePageReqDto);
        return ResponseEntity.created(null).body(challengePageReqDto);
    }

    @GetMapping("/challenge")
    public ResponseEntity<?> challengeStory(@RequestParam(value = "page", defaultValue = "1") int page) {
        ChallengePageReqDto challengePageReqDto = new ChallengePageReqDto();
        challengePageReqDto.setChallengePageId(page);
        return ResponseEntity.ok(challengeService.getChallengePage(challengePageReqDto));
    };


    @GetMapping("/challenge/{page}")
    public ResponseEntity<?> ChallengeMission(@PathVariable("page") int page) {
        ChallengePageReqDto challengePageReqDto = new ChallengePageReqDto();
        challengePageReqDto.setChallengePageId(page);
        return ResponseEntity.ok(challengeService.getChallengePage(challengePageReqDto));
    }

    @PutMapping("/challenge/update/{page}")
    public ResponseEntity<?> updatePage(@PathVariable("page") int page,
                                         @RequestBody ChallengeUpdatePageReqDto challengeUpdatePageReqDto) throws IllegalAccessException {
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

    @GetMapping("/challenge/news/{page}")
    public ResponseEntity<?> getDonationNews(@PathVariable("page") int page) {
        ChallengeNewsPageRespDto response = challengeNewsService.getChallengeNewsByPageId(page);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/challenge/news/{page}")
    public ResponseEntity<?> saveChallengeNewsPage(@PathVariable("page") int page,
                                                  @Valid @RequestBody ChallengeNewsPageReqDto challengeNewsPageReqDto,
                                                  BindingResult bindingResult) throws IllegalAccessException {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }
        challengeNewsPageReqDto.setChallengePageId(page);
        challengeNewsService.saveChallengeNewsPage(challengeNewsPageReqDto, page);

        return ResponseEntity.created(null).body(challengeNewsPageReqDto);
    }
    @PutMapping("/challenge/news/update/{page}")
    public ResponseEntity<?> updateChallengeNews(@PathVariable("page") int page,
                                                 @RequestBody ChallengeNewsUpdateReqDto challengeNewsUpdateReqDto) throws IllegalAccessException {
        challengeNewsUpdateReqDto.setChallengeNewsPageId(page);
        challengeNewsService.updateChallengeNews(challengeNewsUpdateReqDto);
        return ResponseEntity.ok(true);
    }



}
