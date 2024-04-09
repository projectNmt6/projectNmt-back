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

//     // 코멘트 작성
//    @PostMapping
//    public ResponseEntity<?> createComment(@Valid @RequestBody CommentReqDto commentReqDto, BindingResult bindingResult) {
//        CommentResDto createdComment = commentService.saveComment(commentReqDto);
//        return ResponseEntity.status(HttpStatus.CREATED).body(createdComment);
//    }
//
//    // 모든 코멘트 조회 또는 특정 조건에 맞는 코멘트 조회
//    @GetMapping
//    public ResponseEntity<List<CommentResDto>> getAllComments(CommentReqDto commentReqDto) {
//        List<CommentResDto> comments = commentService.getComments(commentReqDto);
//        return ResponseEntity.ok(comments);
//    }
//
//    // 특정 코멘트 조회
//    @GetMapping("/{commentId}")
//    public ResponseEntity<CommentResDto> getComment(@PathVariable Long commentId) {
//        CommentResDto comment = commentService.getCommentById(commentId);
//        return ResponseEntity.ok(comment);
//    }
//
//    // 코멘트 수정
//    @PutMapping("/{commentId}")
//    public ResponseEntity<?> updateComment(@PathVariable Long commentId, @Valid @RequestBody CommentReqDto commentReqDto) {
//        CommentResDto updatedComment = commentService.updateComment(commentId, commentReqDto);
//        return ResponseEntity.ok(updatedComment);
//    }
//
//    // 코멘트 삭제
//    @DeleteMapping("/{commentId}")
//    public ResponseEntity<?> deleteComment(@PathVariable Long commentId) {
//        commentService.deleteComment(commentId);
//        return ResponseEntity.noContent().build();
//    }
}
