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


    @PostMapping("/report")
    public ResponseEntity<CommentReqDto> reportComment(@RequestBody CommentReportReqDto commentReportReqDto) {
        commentService.reportComment(commentReportReqDto);
        return ResponseEntity.created(null).body(null);
    }


}