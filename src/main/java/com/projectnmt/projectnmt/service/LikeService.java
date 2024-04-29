package com.projectnmt.projectnmt.service;

import com.projectnmt.projectnmt.dto.req.DonationListReqDto;
import com.projectnmt.projectnmt.dto.req.GetLikeReqDto;
import com.projectnmt.projectnmt.dto.req.LikeReqDto;
import com.projectnmt.projectnmt.dto.resp.DonationListRespDto;
import com.projectnmt.projectnmt.dto.resp.DonationPageRespDto;
import com.projectnmt.projectnmt.dto.resp.LikeRespDto;
import com.projectnmt.projectnmt.entity.Donation;
import com.projectnmt.projectnmt.entity.DonationPage;
import com.projectnmt.projectnmt.entity.Like;
import com.projectnmt.projectnmt.entity.User;
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

    public void changeLike(LikeReqDto likeReqDto) {

        Like existingLike = likeMapper.findByUserIdAndDonationPageId(likeReqDto);

        if (existingLike != null) {
            likeMapper.deleteByUserIdAndDonationPageId(likeReqDto);
            System.out.println("좋아요 취소");
        } else {
            Like newLike = Like.builder()
                    .userId(likeReqDto.getUserId())
                    .donationPageId(likeReqDto.getDonationPageId())
                    .build();
            likeMapper.insert(newLike);
            System.out.println("좋아요 성공");
        }
    }
    public LikeRespDto getLike(GetLikeReqDto getLikeReqDto) {
        int isLiked = likeMapper.existsByUserIdAndDonationPageId(getLikeReqDto.getDonationPageId(), getLikeReqDto.getUserId());
        int countLike = likeMapper.countLikesByDonationPageId(getLikeReqDto.getDonationPageId());
        System.out.println("isLiked:"+isLiked);
        System.out.println("isCount:"+countLike);
        return LikeRespDto.builder()
                .isLiked(isLiked)
                .countLike(countLike)
                .build();
    }
    }
