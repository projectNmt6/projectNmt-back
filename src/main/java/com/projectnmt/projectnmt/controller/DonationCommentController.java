package com.projectnmt.projectnmt.controller;


import com.projectnmt.projectnmt.dto.req.DonationCommentReqDto;
import com.projectnmt.projectnmt.dto.resp.CommentRespDto;
import com.projectnmt.projectnmt.security.PrincipalUser;
import com.projectnmt.projectnmt.service.DonationCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/comment")
public class DonationCommentController {

    @Autowired
    private DonationCommentService commentService;

    @PostMapping("/upload")
    public ResponseEntity<DonationCommentReqDto> saveComment(@Valid @RequestBody DonationCommentReqDto commentReqDto, BindingResult bindingResult) {
        commentService.saveComment(commentReqDto);
        return ResponseEntity.created(null).body(commentReqDto);
    }

    @GetMapping("/getcomment/{donationPageId}")
    public ResponseEntity<List<CommentRespDto>> getCommentListByDonationPageId(@PathVariable int donationPageId) {
        List<CommentRespDto> commentList = commentService.getChallengeCommentsByChallengePageId(donationPageId);
        return ResponseEntity.ok(commentList);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteComment(@PathVariable("id") int donationCommentId) {
        try {
            commentService.deleteComment(donationCommentId);
            return ResponseEntity.ok().build();
        } catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
        }
    }
}