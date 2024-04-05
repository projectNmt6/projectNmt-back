package com.projectnmt.projectnmt.entity;

import com.projectnmt.projectnmt.dto.resp.DonationPageRespDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DonationPage {

    private Integer donationPageId;
    private int teamId;
    private int mainCategoryId;
    private int donationCategoryId;
    private LocalDateTime createDate;
    private LocalDateTime endDate;
    private int goalAmount;
    private String storyTitle;
    private String storyContent;
    private String mainImgUrl;
    private int donationTagId;
    private Boolean donationPageShow;

    private MainCategory mainCategory;

    public DonationPageRespDto toSavePost() {

        return DonationPageRespDto.builder()
                .donationPageId(donationPageId)
                .teamId(teamId)
                .mainCategoryId(mainCategoryId)
                .donationCategoryId(donationCategoryId)
                .createDate(createDate)
                .endDate(endDate)
                .goalAmount(goalAmount)
                .storyTitle(storyTitle)
                .storyContent(storyContent)
                .mainImgUrl(mainImgUrl)
                .donationTagId(donationTagId)
                .donationPageShow(donationPageShow)
                .build();
    }



}
