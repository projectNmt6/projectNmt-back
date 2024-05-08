package com.projectnmt.projectnmt.service;

import com.projectnmt.projectnmt.dto.CommentReportReqDto;
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

    public void reportComment(CommentReportReqDto commentReportReqDto) {
        if(commentMapper.getReportDuplication(commentReportReqDto.getUserId(), commentReportReqDto.getDonationCommentId(), commentReportReqDto.getIsDonation()) == 0) {
            commentMapper.reportComment(commentReportReqDto);
        } else {
            throw new IllegalArgumentException("이미 신고 하신 댓글 입니다.");
        }
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteComment(int donationCommentId) {
        commentMapper.deleteCommentById(donationCommentId);
    }
}