package com.projectnmt.projectnmt.repository;

import com.projectnmt.projectnmt.dto.CommentReportReqDto;
import com.projectnmt.projectnmt.dto.req.CommentReqDto;
import com.projectnmt.projectnmt.dto.resp.CommentRespDto;
import com.projectnmt.projectnmt.entity.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommentMapper {

    public int saveComment(Comment comment);
    public List<Comment> getCommentList();

    public List<Comment> getCommentList(
            @Param("donationCommentId") int donationCommentId,
            @Param("commentText") String commentText,
            @Param("donationPageId") int donationPageId,
            @Param("userId") int userId
    );
    public int getReportDuplication(int userId, int commentId, int isDonation);
    public int deleteCommentById(@Param("donationCommentId") int donationCommentId);
    public int reportComment(CommentReportReqDto commentReportReqDto);
    List<Comment> getCommentsByDonationPageId(int donationPageId);
}