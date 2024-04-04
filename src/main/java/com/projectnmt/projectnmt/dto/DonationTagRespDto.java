package com.projectnmt.projectnmt.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class DonationTagRespDto {
    private int DonationTagId;
    private String DonationTagName;
}
