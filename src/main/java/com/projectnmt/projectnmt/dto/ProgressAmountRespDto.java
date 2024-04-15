package com.projectnmt.projectnmt.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProgressAmountRespDto {
    private int donationPageId;
    private int goalAmount;
    private int addAmount;
    private String storyTitle;
    private LocalDateTime endDate;
}
