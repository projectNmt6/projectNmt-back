package com.projectnmt.projectnmt.dto.req;

import com.projectnmt.projectnmt.entity.DonationImage;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class DonationListReqDto {
    private int donationPageId;
    private int teamId;
    private int mainCategoryId;
    private LocalDateTime createDate;
    private LocalDateTime endDate;
    private int goalAmount;
    private String storyTitle;
    private String mainImgUrl;
    private int donationTagId;

    private List<DonationImage> donationImages;
}
