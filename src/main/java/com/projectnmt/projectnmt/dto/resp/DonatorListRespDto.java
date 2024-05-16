package com.projectnmt.projectnmt.dto.resp;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class    DonatorListRespDto {
    private int donatorId;
    private int userId;
    private String name;
    private LocalDateTime donationDate;
    private int amount;
    private int donationPageId;
    private int donatorAnonymous;
    private String username;
    private String storyTitle;
    private String mainImgUrl;
    private int goalAmount;
    private int addAmount;


}


