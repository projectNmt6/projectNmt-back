package com.projectnmt.projectnmt.service;

import com.projectnmt.projectnmt.dto.req.CommentReqDto;
import com.projectnmt.projectnmt.dto.resp.CommentRespDto;
import com.projectnmt.projectnmt.entity.Comment;
import com.projectnmt.projectnmt.repository.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {

    @Autowired
    private CommentMapper commentMapper;

    public void saveComment(CommentReqDto commentReqDto) {

        commentMapper.saveComment(commentReqDto.toEntity());
    }

    public List<CommentRespDto> getComment(CommentReqDto commentReqDto) {

        List<Comment> comments = commentMapper.getCommentList(
                commentReqDto.getDonationCommentId(),
                commentReqDto.getCommentText(),
                commentReqDto.getDonationPageId(),
                commentReqDto.getUserId()
        );

        return comments.stream().map(Comment::toSaveComment).collect(Collectors.toList());
    }

    public List<CommentRespDto> getCommentsByDonationPageId(int donationPageId) {
        List<Comment> comments = commentMapper.getCommentsByDonationPageId(donationPageId);
        return comments.stream().map(Comment::toSaveComment).collect(Collectors.toList());
    }


    @Transactional(rollbackFor = Exception.class)
    public void deleteComment(int donationCommentId, int userId) {
        Comment comment = commentMapper.findCommentById(donationCommentId);
        if (comment != null && comment.getUserId() == userId) {
            commentMapper.deleteCommentById(donationCommentId);
        } else {
            throw new IllegalStateException("삭제할 권한이 없습니다.");
        }
    }


}
