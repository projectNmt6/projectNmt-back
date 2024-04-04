package com.projectnmt.projectnmt.entity;

import com.projectnmt.projectnmt.dto.DonationListRespDto;
import com.projectnmt.projectnmt.dto.DonationTagRespDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DonationTag {
    private int DonationTagId;
    private String DonationTagName;

    public DonationTagRespDto toDonationTagRespDto() {
        return DonationTagRespDto.builder()
                .DonationTagId(getDonationTagId())
                .DonationTagName(getDonationTagName())
                .build();
    }
}
