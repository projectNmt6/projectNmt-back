package com.projectnmt.projectnmt.entity;

import com.projectnmt.projectnmt.dto.resp.ChallengeNewsPageRespDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChallengeNewsPage {

    private int challengeNewsPageId;
    private int challengePageId;
    private int pageCategoryId;
    private String challengeNewsContent;
    private int teamId;

    public ChallengeNewsPageRespDto toChallengeNewsPageRespDto() {
        return ChallengeNewsPageRespDto.builder()
                .challengeNewsPageId(challengeNewsPageId)
                .challengePageId(challengePageId)
                .pageCategoryId(pageCategoryId)
                .challengeNewsContent(challengeNewsContent)
                .teamId(teamId)
                .build();
    }
}
