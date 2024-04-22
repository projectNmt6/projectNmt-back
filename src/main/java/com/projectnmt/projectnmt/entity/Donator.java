package com.projectnmt.projectnmt.entity;

import com.projectnmt.projectnmt.dto.GetMyDonationListReqDto;
import com.projectnmt.projectnmt.dto.resp.DonationPageRespDto;
import com.projectnmt.projectnmt.dto.resp.DonatorListRespDto;
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
    private int donationAmount;
    private int donationPageId;
    private int donatorAnonymous;

    private User user;
    private DonationPage donationPage ;
    private Comment comment;

    public DonatorListRespDto toDonatorListRespDto() {

        return DonatorListRespDto.builder()
                .donatorId(donatorId)
                .userId(userId)
                .donationDate(donationDate)
                .donationAmount(donationAmount)
                .donationPageId(donationPageId)
                .donatorAnonymous(donatorAnonymous)
                .build();
    }

}
