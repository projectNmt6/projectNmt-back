package com.projectnmt.projectnmt.entity;

import com.projectnmt.projectnmt.dto.resp.DonationImageRespDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DonationImage {

    private int donationImageId; // AI
    private int donationPageId;
    private int donationImageNumber; // 이미지의 순서
    private String donationImageURL;
    private int userId;

    public DonationImageRespDto toDonationImageRespDto() {
        return DonationImageRespDto.builder()
                .donationImageId(donationImageId)
                .donationPageId(donationImageId)
                .donationImageNumber(donationImageNumber)
                .donationImageURL(donationImageURL)
                .userId(userId)
                .build();
    }

}
