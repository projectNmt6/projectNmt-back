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
    public ResponseEntity<?> updatePage(@PathVariable("page") int page,
                                         @RequestBody ChallengeUpdatePageReqDto challengeUpdatePageReqDto,
                                         @AuthenticationPrincipal PrincipalUser currentUser) {
        challengeUpdatePageReqDto.setChallengePageId(page);

        if (currentUser == null || currentUser.getUserId() == 0) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("사용자 인증 정보가 없습니다.");
        }

        if (!challengeService.isUserPageOwner(page, currentUser.getUserId())) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("접근 권한이 없습니다.");
        }

        try {
            challengeService.updateChallengePage(challengeUpdatePageReqDto, currentUser.getUserId());
            return ResponseEntity.ok(true);
        } catch (IllegalAccessException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("접근 권한이 없습니다.");
        }

    }

    @GetMapping("/challenge/update/{page}")
    public ResponseEntity<?> getUpdatePage(@PathVariable("page") int page) {
        ChallengePageReqDto challengePageReqDto = new ChallengePageReqDto();
        challengePageReqDto.setChallengePageId(page);
        ChallengePageRespDto challengePageRespDto = challengeService.getChallengePage(challengePageReqDto);
        return ResponseEntity.ok(challengePageRespDto);
    }

    @DeleteMapping("/challenge/{id}")
    public ResponseEntity<?> deleteChallengePage(@PathVariable("id") int challengePageId, @AuthenticationPrincipal PrincipalUser currentUser) {
        if (currentUser == null || currentUser.getUserId() == 0) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("사용자 인증 정보가 없습니다.");
        }
        try {
            challengeService.deleteChallengePage(challengePageId, currentUser.getUserId());
            return ResponseEntity.ok().build();
        }  catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("해당 페이지를 찾을 수 없습니다.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("서버 내부 오류: " + e.getMessage());
        }
    }

    @PostMapping("/challenge/news/{page}")
    public ResponseEntity<?> saveChallengeNewsPage(@PathVariable("page") int page,
                                                  @Valid @RequestBody ChallengeNewsPageReqDto challengeNewsPageReqDto,
                                                  BindingResult bindingResult,
                                                  @AuthenticationPrincipal PrincipalUser currentUser) throws IllegalAccessException {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }

        challengeNewsPageReqDto.setChallengePageId(page);
        System.out.println("work");
        challengeNewsService.saveChallengeNewsPage(challengeNewsPageReqDto, page, currentUser.getUserId());

        return ResponseEntity.created(null).body(challengeNewsPageReqDto);
    }

    @GetMapping("/challenge/news/update/{page}")
    public ResponseEntity<?> getNewsPageUpdate(@PathVariable("page") int page, @AuthenticationPrincipal PrincipalUser currentUser) {
        if (currentUser == null || currentUser.getUserId() == 0) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("사용자 인증 정보가 없습니다.");
        }
        ChallengeNewsPageReqDto challengeNewsPageReqDto = new ChallengeNewsPageReqDto();
        challengeNewsPageReqDto.setChallengePageId(page);
        ChallengeNewsPageRespDto challengeNewsPageRespDto = challengeNewsService.getChallengeNews((challengeNewsPageReqDto));
        if (challengeNewsPageRespDto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(challengeNewsPageRespDto);
    }

}
