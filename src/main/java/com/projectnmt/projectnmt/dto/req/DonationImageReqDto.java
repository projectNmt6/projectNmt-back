package com.projectnmt.projectnmt.dto.req;

import com.projectnmt.projectnmt.entity.DonationImage;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DonationImageReqDto {

    private int donationImageId; // AI
    private int donationPageId;
    private int donationImageNumber; // 이미지의 순서
    private String donationImageURL;
    private int userId;

    public DonationImage toEntity() {
        return DonationImage.builder()
                .donationImageId(donationImageId)
                .donationPageId(donationPageId)
                .donationImageNumber(donationImageNumber)
                .donationImageURL(donationImageURL)
                .userId(userId)
                .build();
    }
}
