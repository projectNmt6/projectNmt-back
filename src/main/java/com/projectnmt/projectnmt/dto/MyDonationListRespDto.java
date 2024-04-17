package com.projectnmt.projectnmt.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MyDonationListRespDto {
    private int donationPageId;
    private String donationDate;
    private String storyTitle;
    private int amount;
}
