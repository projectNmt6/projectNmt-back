package com.projectnmt.projectnmt.dto.resp;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class DonationListRespDto {

    private int donationPageId;
    private String teamName;
    private String mainCategoryName;
    private LocalDateTime createDate;
    private LocalDateTime endDate;
    private int goalAmount;
    private String storyTitle;
    private String mainImgUrl;
    private String donationTagName;
    private int donationPageShow;
    private int teamId;
    private int countLike;
}