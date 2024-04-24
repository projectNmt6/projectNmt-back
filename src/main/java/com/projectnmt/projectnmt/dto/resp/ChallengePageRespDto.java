package com.projectnmt.projectnmt.dto.resp;

import com.projectnmt.projectnmt.entity.DonationImage;
import com.projectnmt.projectnmt.entity.MainCategory;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Data
public class ChallengePageRespDto {

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

    private List<DonationImage> donationImages;
}
