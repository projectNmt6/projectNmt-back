package com.projectnmt.projectnmt.controller;


import com.projectnmt.projectnmt.dto.req.CommentReqDto;
import com.projectnmt.projectnmt.dto.resp.CommentRespDto;
import com.projectnmt.projectnmt.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
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
    public ResponseEntity<CommentReqDto> saveComment(@Valid @RequestBody CommentReqDto commentReqDto, BindingResult bindingResult) {
        commentService.saveComment(commentReqDto);
        return ResponseEntity.created(null).body(commentReqDto);
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
        commentService.deleteComment(donationCommentId);
        return ResponseEntity.ok().build();
    }
}