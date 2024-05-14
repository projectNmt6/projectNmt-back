package com.projectnmt.projectnmt.entity;

import com.projectnmt.projectnmt.dto.GetMyDonationListReqDto;
import com.projectnmt.projectnmt.dto.resp.DonationGivingRespDto;
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
    private int amount;
    private int donationPageId;
    private int donatorAnonymous;
    private String username;
    private String storyTitle;
    private String mainImgUrl;
    private int addAmount;
    private User user;
    private DonationPage donationPage ;
    private DonationComment comment;
    private int goalAmount;

    private String name;
    private String profileImg;

    public DonatorListRespDto toDonatorListRespDto() {
        System.out.println(user);
        return DonatorListRespDto.builder()
                .donatorId(donatorId)
                .userId(userId)
                .name(user.getName())
                .donationDate(donationDate)
                .amount(amount)
                .donationPageId(donationPageId)
                .donatorAnonymous(donatorAnonymous)
                .username(username)
                .storyTitle(storyTitle)
                .mainImgUrl(mainImgUrl)
                .goalAmount(goalAmount)
                .addAmount(addAmount)
                .build();
    }

    public DonationGivingRespDto toSaveGivings() {
        return DonationGivingRespDto.builder()
                .donatorId(donatorId)
                .userId(userId)
                .donationDate(donationDate)
                .amount(amount)
                .donatorAnonymous(donatorAnonymous)
                .donationPageId(donationPageId)
                .username(username)
                .build();
    }

}