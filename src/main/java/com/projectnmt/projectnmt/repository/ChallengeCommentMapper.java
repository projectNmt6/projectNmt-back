package com.projectnmt.projectnmt.repository;

import com.projectnmt.projectnmt.entity.ChallengeComment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ChallengeCommentMapper {

    public int saveChallengeComment(ChallengeComment challengeComment);

    public List<ChallengeComment> getChallengeCommentList(
            @Param("challengeCommentId") int challengeCommentId,
            @Param("commentText") String commentText,
            @Param("challengePageId") int challengePageId,
            @Param("userId") int userId
    );
    List<ChallengeComment> getChallengeCommentList();
    List<ChallengeComment> getChallengeCommentsByChallengePageId(int challengePageId);

    public int deletechallengeCommentById(@Param("challengeCommentId") int challengeCommentId);
    ChallengeComment findCommentById(@Param("challengeCommentId") int challengeCommentId);
    List<ChallengeComment> getCommentByChallengePageId(int challengePageId);
}
