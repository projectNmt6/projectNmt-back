package com.projectnmt.projectnmt.dto.req;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Data
@Component
public class DonatorListReqDto {
    private int donatorId;
    private int userId;
    private LocalDateTime donationDate;
    private int donationAmount;
    private int donationPageId;
    private int donatorAnonymous;
    private String username;
    private String storyTitle;
    private String mainImgUrl;
    private int goalAmount;
    private int addAmount;


    private String name;
}
