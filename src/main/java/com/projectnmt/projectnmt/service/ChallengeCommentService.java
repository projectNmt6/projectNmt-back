package com.projectnmt.projectnmt.service;

import com.projectnmt.projectnmt.dto.req.ChallengeCommentReqDto;
import com.projectnmt.projectnmt.dto.resp.ChallengeCommentRespDto;
import com.projectnmt.projectnmt.entity.ChallengeComment;
import com.projectnmt.projectnmt.repository.ChallengeCommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChallengeCommentService {

    @Autowired
    private ChallengeCommentMapper challengeCommentMapper;

    public void saveChallengeComment(ChallengeCommentReqDto challengeCommentReqDto) {
        challengeCommentMapper.saveChallengeComment(challengeCommentReqDto.toEntity());
    }

    public List<ChallengeCommentRespDto> getChallengeComment(ChallengeCommentReqDto challengeCommentReqDto) {

        List<ChallengeComment> comments = challengeCommentMapper.getChallengeCommentList(
                challengeCommentReqDto.getChallengeCommentId(),
                challengeCommentReqDto.getCommentText(),
                challengeCommentReqDto.getChallengePageId(),
                challengeCommentReqDto.getUserId()
        );

        return comments.stream().map(ChallengeComment::toSaveComment).collect(Collectors.toList());
    }

    public List<ChallengeCommentRespDto> getChallengeCommentsByChallengePageId(int challengePageId) {
        List<ChallengeComment> challengeComments = challengeCommentMapper.getChallengeCommentsByChallengePageId(challengePageId);
        return challengeComments.stream().map(ChallengeComment::toSaveComment).collect(Collectors.toList());
    }


    @Transactional(rollbackFor = Exception.class)
    public void deleteChallengeComment(int challengeCommentId){

        ChallengeComment challengeComment = challengeCommentMapper.findCommentById(challengeCommentId);

    }

}
