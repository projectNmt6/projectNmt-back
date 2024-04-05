package com.projectnmt.projectnmt.dto.req;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DonationListReqDto {
    private int donationPageId;
    private int teamId;
    private int mainCategoryId;
    private String storyTitle;
    private LocalDateTime createDate;
    private LocalDateTime endDate;
    private int goalAmount;
    private String mainImgUrl;
    private int donationTagId;

}
