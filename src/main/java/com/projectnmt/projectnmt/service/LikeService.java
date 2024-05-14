package com.projectnmt.projectnmt.service;

import com.projectnmt.projectnmt.dto.req.BestCommentReqDto;
import com.projectnmt.projectnmt.dto.req.DonationListReqDto;
import com.projectnmt.projectnmt.dto.req.GetLikeReqDto;
import com.projectnmt.projectnmt.dto.req.LikeReqDto;
import com.projectnmt.projectnmt.dto.resp.BestCommentRespDto;
import com.projectnmt.projectnmt.dto.resp.DonationListRespDto;
import com.projectnmt.projectnmt.dto.resp.DonationPageRespDto;
import com.projectnmt.projectnmt.dto.resp.LikeRespDto;
import com.projectnmt.projectnmt.entity.*;
import com.projectnmt.projectnmt.repository.DonationMapper;
import com.projectnmt.projectnmt.repository.LikeMapper;
import com.projectnmt.projectnmt.repository.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LikeService {
    @Autowired
    private LikeMapper likeMapper;

    public String  changeLike(LikeReqDto likeReqDto) {
        Like existingLike = likeMapper.findByUserIdAndDonationPageId(likeReqDto);
        String message;
        if (existingLike != null) {
            likeMapper.deleteByUserIdAndDonationPageId(likeReqDto);
            message = "취소 되었습니다.";
        } else {
            Like newLike = Like.builder()
                    .userId(likeReqDto.getUserId())
                    .donationPageId(likeReqDto.getDonationPageId())
                    .commentId(likeReqDto.getCommentId())
                    .build();
            likeMapper.insert(newLike);
            message = "따뜻한 마음 감사합니다.";
        }
        return message;
    }
    public LikeRespDto getLike(GetLikeReqDto getLikeReqDto) {
        int isLiked = likeMapper.existsByUserIdAndDonationPageId(getLikeReqDto.getDonationPageId(), getLikeReqDto.getUserId(), getLikeReqDto.getCommentId());
        int countLike = likeMapper.countLikesByDonationPageId(getLikeReqDto.getDonationPageId(), getLikeReqDto.getCommentId());

        return LikeRespDto.builder()
                .isLiked(isLiked)
                .countLike(countLike)
                .build();
    }
    public List<String> bestComment(){
        return likeMapper.getBestCommentList();
    }
    }
