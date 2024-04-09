package com.projectnmt.projectnmt.controller;


import com.projectnmt.projectnmt.dto.req.CommentReqDto;
import com.projectnmt.projectnmt.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/upload")
    public ResponseEntity<?> saveComment(@Valid @RequestBody CommentReqDto commentReqDto, BindingResult bindingResult){
        commentService.saveComment(commentReqDto);

        return ResponseEntity.created(null).body(commentReqDto);
    }

    @GetMapping("/getcomment")
    public ResponseEntity<?> CommentList(CommentReqDto commentReqDto) {
        return ResponseEntity.ok(commentService.getComment(commentReqDto));
    }
}
