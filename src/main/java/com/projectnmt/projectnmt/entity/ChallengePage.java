package com.projectnmt.projectnmt.entity;

import com.projectnmt.projectnmt.dto.resp.ChallengePageListRespDto;
import com.projectnmt.projectnmt.dto.resp.ChallengePageRespDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ChallengePage {
    private int challengePageId;
    private int teamId;
    private int mainCategoryId;     //1.donation, 2.challenge
    private int pageCategoryId;    // mission, action, news
    private LocalDateTime createDate;
    private LocalDateTime endDate;
    private String challengeTitle;
    private String challengeOverview;   //챌린지 요약
    private String challengeContent;
    private String challengeMainImg;
    private Boolean challengePageShow;

    public ChallengePageRespDto toChallengePageRespDto() {
        return ChallengePageRespDto.builder()
                .challengePageId(challengePageId)
                .teamId(teamId)
                .mainCategoryId(mainCategoryId)
                .pageCategoryId(pageCategoryId)
                .createDate(createDate)
                .endDate(endDate)
                .challengeTitle(challengeTitle)
                .challengeOverview(challengeOverview)
                .challengeContent(challengeContent)
                .challengeMainImg(challengeMainImg)
                .challengePageShow(challengePageShow)
                .build();
    }

    public ChallengePageListRespDto toChallengePageListRespDto() {
        return ChallengePageListRespDto.builder()
                .challengePageId(challengePageId)
                .teamId(teamId)
                .mainCategoryId(mainCategoryId)
                .pageCategoryId(pageCategoryId)
                .createDate(createDate)
                .endDate(endDate)
                .challengeTitle(challengeTitle)
                .challengeOverview(challengeOverview)
                .challengeContent(challengeContent)
                .challengeMainImg(challengeMainImg)
                .build();
    }
}
