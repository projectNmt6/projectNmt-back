package com.projectnmt.projectnmt.service;

import com.projectnmt.projectnmt.dto.req.CommentReqDto;
import com.projectnmt.projectnmt.dto.resp.CommentRespDto;
import com.projectnmt.projectnmt.entity.Comment;
import com.projectnmt.projectnmt.repository.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    private CommentMapper commentMapper;

    public void saveComment(CommentReqDto commentReqDto) {
        commentMapper.saveComment(commentReqDto.toEntity());
    }

    public CommentRespDto getComment(CommentReqDto commentReqDto) {

        Comment comments = commentMapper.getCommentList(
                commentReqDto.getDonationCommentId(),
                commentReqDto.getCommentText(),
                commentReqDto.getDonationPageId(),
                commentReqDto.getUserId()
        );

        CommentRespDto commentRespDto = comments.toSaveComment();
        return commentRespDto;


    }

}
