package com.projectnmt.projectnmt.entity;

import com.projectnmt.projectnmt.dto.resp.ChallengeCommentRespDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChallengeComment {

    private int challengeCommentId;
    private String commentText;
    private int challengePageId;
    private int userId;
    private User user;
    private ChallengePage challengePage;

    public ChallengeCommentRespDto toSaveComment() {
        return ChallengeCommentRespDto.builder()
                .challengeCommentId(challengeCommentId)
                .commentText(commentText)
                .challengePageId(challengePageId)
                .userId(userId)
                .build();
    }

}
