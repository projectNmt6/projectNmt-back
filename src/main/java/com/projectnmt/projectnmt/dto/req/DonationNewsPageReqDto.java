package com.projectnmt.projectnmt.dto.req;


import com.projectnmt.projectnmt.entity.DonationNewsPage;
import lombok.Data;

@Data
public class DonationNewsPageReqDto {
    private int donationNewsPageId;
    private int donationPageId;
    private int pageCategoryId;
    private String newsContent;
    private int teamId;

    public DonationNewsPage toEntity() {
        return DonationNewsPage.builder()
                .donationNewsPageId(donationNewsPageId)
                .donationPageId(donationPageId)
                .pageCategoryId(pageCategoryId)
                .newsContent(newsContent)
                .teamId(teamId)
                .build();
    }
}
