package com.projectnmt.projectnmt.dto.resp;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class DonationTagRespDto {
    private int DonationTagId;
    private String DonationTagName;
}
