package com.projectnmt.projectnmt.dto.resp;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class DonationImageRespDto {
    private int donationImageId; // AI
    private int donationPageId;
    private int donationImageNumber; // 이미지의 순서
    private String donationImageURL;
    private int userId;
    private LocalDateTime createDate;
}
