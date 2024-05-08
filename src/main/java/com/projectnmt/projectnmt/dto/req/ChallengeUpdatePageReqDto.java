package com.projectnmt.projectnmt.dto.req;

import com.projectnmt.projectnmt.entity.ChallengePage;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ChallengeUpdatePageReqDto {

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

    public ChallengePage toEntity() {
        return ChallengePage.builder()
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
}
