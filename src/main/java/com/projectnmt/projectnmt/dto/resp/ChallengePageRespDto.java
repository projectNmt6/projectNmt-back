package com.projectnmt.projectnmt.dto.resp;

import com.projectnmt.projectnmt.entity.MainCategory;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class ChallengePageRespDto {

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
