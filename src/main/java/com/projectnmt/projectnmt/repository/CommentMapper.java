package com.projectnmt.projectnmt.repository;

import com.projectnmt.projectnmt.dto.resp.CommentRespDto;
import com.projectnmt.projectnmt.entity.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommentMapper {

    public int saveComment(Comment comment);
    List<Comment> getCommentList();

    public List<Comment> getCommentList(
            @Param("donationCommentId") int donationCommentId,
            @Param("commentText") String commentText,
            @Param("donationPageId") int donationPageId,
            @Param("userId") int userId
    );
    public int deleteCommentById(@Param("donationCommentId") int donationCommentId);
    List<Comment> getCommentsByDonationPageId(int donationPageId);
    Comment findCommentById(@Param("donationCommentId") int donationCommentId);
}