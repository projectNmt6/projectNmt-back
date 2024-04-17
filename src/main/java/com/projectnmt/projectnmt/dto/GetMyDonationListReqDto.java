package com.projectnmt.projectnmt.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class GetMyDonationListReqDto {
    public int userId;
    public int donationDate;
    public int mainCategoryId;
}
