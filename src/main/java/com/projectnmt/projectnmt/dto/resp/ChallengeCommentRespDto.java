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
    private String name;
    private String profileImg; // 사용자 프로필 이미지 URL 추가
    private ChallengePage challengePage;
}
