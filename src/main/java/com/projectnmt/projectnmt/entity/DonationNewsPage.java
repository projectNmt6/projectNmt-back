package com.projectnmt.projectnmt.entity;


import com.projectnmt.projectnmt.dto.resp.DonationNewsPageRespDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.spec.RSAOtherPrimeInfo;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DonationNewsPage {
    private int donationNewsPageId;
    private int donationPageId;
    private int pageCategoryId;
    private String newsContent;
    private int userId;

    public DonationNewsPageRespDto toDonationNewsPageRespDto() {
        return DonationNewsPageRespDto.builder()
                .donationNewsPageId(donationNewsPageId)
                .donationPageId(donationPageId)
                .pageCategoryId(pageCategoryId)
                .newsContent(newsContent)
                .userId(userId)
                .build();
    }
}
