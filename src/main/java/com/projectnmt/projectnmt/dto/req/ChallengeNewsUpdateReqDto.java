package com.projectnmt.projectnmt.dto.req;

import com.projectnmt.projectnmt.entity.ChallengeNewsPage;
import lombok.Data;

@Data
public class ChallengeNewsUpdateReqDto {
    private int challengeNewsPageId;
    private int challengePageId;
    private int pageCategoryId;
    private String challengeNewsContent;
    private int teamId;
    public ChallengeNewsPage toEntity() {
        return ChallengeNewsPage.builder()
                .challengeNewsPageId(challengeNewsPageId)
                .challengePageId(challengePageId)
                .pageCategoryId(pageCategoryId)
                .challengeNewsContent(challengeNewsContent)
                .teamId(teamId)
                .build();
    }
}
