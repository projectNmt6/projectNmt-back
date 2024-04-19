package com.projectnmt.projectnmt.dto.req;

import com.projectnmt.projectnmt.entity.ChallengePage;
import com.projectnmt.projectnmt.entity.MainCategory;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ChallengePageReqDto {
    private Integer challengePageId;
    private int teamId;
    private int mainCategoryId;     //1.donation, 2.challenge
    private int pageCategoryId;    // mission, action, news
    private LocalDateTime createDate;
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
                .challengeTitle(challengeTitle)
                .challengeOverview(challengeOverview)
                .challengeContent(challengeContent)
                .challengeMainImg(challengeMainImg)
                .challengePageShow(challengePageShow)
                .build();
    }
}
