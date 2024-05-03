package com.projectnmt.projectnmt.controller;


import com.projectnmt.projectnmt.dto.req.ChallengeCommentReqDto;
import com.projectnmt.projectnmt.dto.resp.ChallengeCommentRespDto;
import com.projectnmt.projectnmt.security.PrincipalUser;
import com.projectnmt.projectnmt.service.ChallengeCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/challengeComment")
public class ChallengeCommentController {

    @Autowired
    private ChallengeCommentService challengeCommentService;

    @PostMapping("/upload")
    public ResponseEntity<ChallengeCommentReqDto> saveComment(@Valid @RequestBody ChallengeCommentReqDto challengeCommentReqDto, BindingResult bindingResult){
        challengeCommentService.saveChallengeComment(challengeCommentReqDto);
        return ResponseEntity.created(null).body(challengeCommentReqDto);
    }

    @GetMapping("/get/{challengePageId}")
    public ResponseEntity<List<ChallengeCommentRespDto>> getChallengeCommentListByChallengePageId(@PathVariable int challengePageId){
        List<ChallengeCommentRespDto> commentList = challengeCommentService.getChallengeCommentsByChallengePageId(challengePageId);
        return ResponseEntity.ok(commentList);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteComment(@PathVariable("id") int challengeCommentId,@AuthenticationPrincipal PrincipalUser currentUser){
        try {
            challengeCommentService.deleteChallengeComment(challengeCommentId, currentUser.getUserId());
            return ResponseEntity.ok().build();
        } catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
    }}
}
