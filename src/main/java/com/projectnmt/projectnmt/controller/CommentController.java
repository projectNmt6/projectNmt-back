package com.projectnmt.projectnmt.controller;


import com.projectnmt.projectnmt.dto.CommentReportReqDto;
import com.projectnmt.projectnmt.dto.req.CommentReqDto;
import com.projectnmt.projectnmt.dto.resp.CommentRespDto;
import com.projectnmt.projectnmt.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/upload")
    public ResponseEntity<CommentReqDto> saveComment(@RequestBody CommentReqDto commentReqDto) {
        commentService.saveComment(commentReqDto);
        return ResponseEntity.created(null).body(commentReqDto);
    }
    @PostMapping("/report")
    public ResponseEntity<CommentReqDto> reportComment(@RequestBody CommentReportReqDto commentReportReqDto) {
        commentService.reportComment(commentReportReqDto);
        return ResponseEntity.created(null).body(null);
    }


//    @GetMapping("/getcomment")
//    public ResponseEntity<List<CommentRespDto>> getAllComments() {
//        List<CommentRespDto> comments = commentService.getComment(new CommentReqDto()); // Assuming an overloaded method or modify existing one
//        return ResponseEntity.ok(comments);
//    }

    @GetMapping("/getcomment/{donationPageId}")
    public ResponseEntity<List<CommentRespDto>> getCommentListByDonationPageId(@PathVariable int donationPageId) {
        List<CommentRespDto> commentList = commentService.getCommentsByDonationPageId(donationPageId);
        return ResponseEntity.ok(commentList);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteComment(@PathVariable("id") int donationCommentId) {
        System.out.println(donationCommentId);
        commentService.deleteComment(donationCommentId);
        return ResponseEntity.ok().build();
    }
}