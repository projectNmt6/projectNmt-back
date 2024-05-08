package com.projectnmt.projectnmt.dto.resp;


import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class DonationNewsPageRespDto {
    private int donationNewsPageId;
    private int donationPageId;
    private int pageCategoryId;
    private String newsContent;
    private int teamId;
}
