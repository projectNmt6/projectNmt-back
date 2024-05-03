package com.projectnmt.projectnmt.dto.req;

import com.projectnmt.projectnmt.entity.DonationPage;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DonationPageReqDto {

    private int donationPageId;
    private int teamId;
    private int mainCategoryId;
    private int pageCategoryId;
    private LocalDateTime createDate;
    private LocalDateTime endDate;
    private int goalAmount;
    private String storyTitle;
    private String storyContent;
    private String mainImgUrl;
    private int donationTagId;
    private Boolean donationPageShow;
    private int countLike;

    public DonationPage toEntity() {
        return DonationPage.builder()
                .donationPageId(donationPageId)
                .teamId(teamId)
                .mainCategoryId(mainCategoryId)
                .pageCategoryId(pageCategoryId)
                .createDate(createDate)
                .endDate(endDate)
                .goalAmount(goalAmount)
                .storyTitle(storyTitle)
                .storyContent(storyContent)
                .mainImgUrl(mainImgUrl)
                .donationTagId(donationTagId)
                .donationPageShow(donationPageShow)
                .countLike(countLike)
                .build();
    }

}
