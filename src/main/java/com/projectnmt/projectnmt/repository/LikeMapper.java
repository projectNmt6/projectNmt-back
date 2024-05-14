package com.projectnmt.projectnmt.repository;

import com.projectnmt.projectnmt.dto.req.LikeReqDto;
import com.projectnmt.projectnmt.entity.BestComment;
import com.projectnmt.projectnmt.entity.DonationPage;
import com.projectnmt.projectnmt.entity.Like;
import com.projectnmt.projectnmt.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LikeMapper {
    // Find an existing like record by userId and donationPageId
    Like findByUserIdAndDonationPageId(LikeReqDto likeReqDto);

    // Delete a like record by userId and donationPageId
    void deleteByUserIdAndDonationPageId(LikeReqDto likeReqDto);

    // Insert a new like record
    void insert(Like like);

    int countLikesByDonationPageId(int donationPageId, int commentId);

    int existsByUserIdAndDonationPageId(int donationPageId, int userId , int commentId);

    List<String> getBestCommentList();
}
