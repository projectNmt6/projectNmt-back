package com.projectnmt.projectnmt.dto.req;

import com.projectnmt.projectnmt.entity.ChallengeComment;
import com.projectnmt.projectnmt.entity.ChallengePage;
import com.projectnmt.projectnmt.entity.User;
import lombok.Data;

@Data
public class ChallengeCommentReqDto {

    private int challengeCommentId;
    private String commentText;
    private int challengePageId;
    private int userId;

    private String name;
    private User user;
    private ChallengePage challengePage;

    public ChallengeComment toEntity() {
        return ChallengeComment.builder()
                .challengeCommentId(challengeCommentId)
                .commentText(commentText)
                .challengePageId(challengePageId)
                .userId(userId)
                .build();

    }
}
