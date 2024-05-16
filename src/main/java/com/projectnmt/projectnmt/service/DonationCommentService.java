package com.projectnmt.projectnmt.service;

import com.projectnmt.projectnmt.dto.req.DonationCommentReqDto;
import com.projectnmt.projectnmt.dto.resp.CommentRespDto;
import com.projectnmt.projectnmt.entity.DonationComment;
import com.projectnmt.projectnmt.repository.DonationCommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DonationCommentService {

    @Autowired
    private DonationCommentMapper donationCommentMapper;

    public void saveComment(DonationCommentReqDto commentReqDto) {
        donationCommentMapper.saveComment(commentReqDto.toEntity());
    }

    public List<CommentRespDto> getComment(DonationCommentReqDto commentReqDto) {

        List<DonationComment> comments = donationCommentMapper.getCommentList(
                commentReqDto.getDonationCommentId(),
                commentReqDto.getCommentText(),
                commentReqDto.getDonationPageId(),
                commentReqDto.getUserId()
        );

        return comments.stream().map(DonationComment::toSaveComment).collect(Collectors.toList());
    }

    public List<CommentRespDto> getChallengeCommentsByChallengePageId(int donationPageId) {
        List<DonationComment> comments = donationCommentMapper.getChallengeCommentsByChallengePageId(donationPageId);
        return comments.stream().map(DonationComment::toSaveComment).collect(Collectors.toList());
    }


    @Transactional(rollbackFor = Exception.class)
    public void deleteComment(int donationCommentId) {
        DonationComment comment = donationCommentMapper.findCommentById(donationCommentId);

    }


}