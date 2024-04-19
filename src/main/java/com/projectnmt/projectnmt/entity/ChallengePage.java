package com.projectnmt.projectnmt.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ChallengePage {
    private Integer challengePageId;
    private int teamId;
    private MainCategory mainCategoryId;     //1.donation, 2.challenge
    private int pageCategoryId;    // mission, action, news
    private LocalDateTime createDate;
    private String challengeTitle;
    private String challengeOverview;   //챌린지 요약
    private String challengeContent;
    private String challengeMainImg;
    private Boolean challengePageShow;

}
