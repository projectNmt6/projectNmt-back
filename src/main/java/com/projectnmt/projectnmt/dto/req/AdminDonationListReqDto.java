package com.projectnmt.projectnmt.dto.req;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AdminDonationListReqDto {
    private int pageId;
    private int searchCount;
    private int teamId;
    private int mainCategoryId;
    private int isTimeOut;
    private int donationIsShow;
    private int selectedOption;
    private String searchText;
}
