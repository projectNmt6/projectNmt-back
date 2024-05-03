package com.projectnmt.projectnmt.dto.resp;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class DonationPageRespDto {

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

}
