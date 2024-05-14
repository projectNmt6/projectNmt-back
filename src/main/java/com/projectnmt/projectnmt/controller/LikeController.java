package com.projectnmt.projectnmt.controller;

import com.projectnmt.projectnmt.dto.req.BestCommentReqDto;
import com.projectnmt.projectnmt.dto.req.GetLikeReqDto;
import com.projectnmt.projectnmt.dto.req.LikeReqDto;
import com.projectnmt.projectnmt.dto.resp.LikeRespDto;
import com.projectnmt.projectnmt.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/like")
public class LikeController {

        @Autowired
        private LikeService likeService;
        @PostMapping("/post")
        public ResponseEntity<?> postLike(@RequestBody LikeReqDto likeReqDto){
            String message = likeService.changeLike(likeReqDto);
            return ResponseEntity.ok(message);
        }
        @GetMapping("/get")
        public ResponseEntity<?> getLike(GetLikeReqDto getLikeReqDto) {
            return ResponseEntity.ok(likeService.getLike(getLikeReqDto));
        }
        @GetMapping("/bestcomment")
        public ResponseEntity<?> getBestComment(){
            return ResponseEntity.ok(likeService.bestComment());
        }
    }

