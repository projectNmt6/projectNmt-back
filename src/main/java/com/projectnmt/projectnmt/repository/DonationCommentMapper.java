package com.projectnmt.projectnmt.repository;


import com.projectnmt.projectnmt.dto.req.CommentReqDto;
import com.projectnmt.projectnmt.entity.DonationComment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DonationCommentMapper {

    public int saveComment(DonationComment comment);


    List<DonationComment> getChallengeCommentsByChallengePageId(int donationPageId);

    public List<DonationComment> getCommentList(
            @Param("donationCommentId") int donationCommentId,
            @Param("commentText") String commentText,
            @Param("donationPageId") int donationPageId,
            @Param("userId") int userId
    );

    public int deleteCommentById(@Param("donationCommentId") int donationCommentId);

    List<DonationComment> getCommentsByDonationPageId(int donationPageId);

    DonationComment findCommentById(@Param("donationCommentId") int donationCommentId);

    public int reportComment(CommentReqDto commentReportReqDto);
}