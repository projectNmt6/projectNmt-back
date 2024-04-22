package com.projectnmt.projectnmt.dto.resp;

import com.projectnmt.projectnmt.entity.ChallengePage;
import com.projectnmt.projectnmt.entity.User;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ChallengeCommentRespDto {

    private int challengeCommentId;
    private String commentText;
    private int challengePageId;
    private int userId;
    private User user;
    private ChallengePage challengePage;
}
