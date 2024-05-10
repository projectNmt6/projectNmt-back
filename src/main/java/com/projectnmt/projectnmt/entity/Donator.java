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
    private String username;
    private String storyTitle;
    private String mainImgUrl;
    private int addAmount;
    private User user;
    private DonationPage donationPage ;
    private Comment comment;
    private int goalAmount;
    public DonatorListRespDto toDonatorListRespDto() {
        return DonatorListRespDto.builder()
                .donatorId(donatorId)
                .userId(userId)
                .name(user.getName())
                .donationDate(donationDate)
                .donationAmount(donationAmount)
                .donationPageId(donationPageId)
                .donatorAnonymous(donatorAnonymous)
                .username(username)
                .storyTitle(storyTitle)
                .mainImgUrl(mainImgUrl)
                .goalAmount(goalAmount)
                .addAmount(addAmount)
                .build();
    }

}
