package com.projectnmt.projectnmt.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MyDonationListRespDto {
    private int donationPageId;
    private int donationDate;
    private String storyTitle;
    private int amount;
}
