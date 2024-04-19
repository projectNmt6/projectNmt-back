package com.projectnmt.projectnmt.entity;

import com.projectnmt.projectnmt.dto.DonationGivingReqDto;
import com.projectnmt.projectnmt.dto.GetMyDonationListReqDto;
import com.projectnmt.projectnmt.dto.resp.DonationGivingRespDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Donator {
    private int donatorId;
    private int userId;
    private LocalDateTime donationDate;
    private int amount;
    private int donationPageId;
    private boolean anonymous;

    private User user;
    private DonationPage donationPage ;
    private Comment comment;

    public DonationGivingRespDto toSaveGivings() {
        return DonationGivingRespDto.builder()
                .donatorId(donatorId)
                .userId(userId)
                .donationDate(donationDate)
                .amount(amount)
                .donationPageId(donationPageId)
                .anonymous(anonymous)
                .build();
    }

}
