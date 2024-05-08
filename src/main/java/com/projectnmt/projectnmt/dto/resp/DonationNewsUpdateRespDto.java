package com.projectnmt.projectnmt.dto.resp;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class DonationNewsUpdateRespDto {
    private int donationNewsPageId;
    private int donationPageId;
    private int pageCategoryId;
    private String newsContend;
    private int teamId;
}
