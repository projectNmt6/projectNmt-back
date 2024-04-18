package com.projectnmt.projectnmt.entity;
import com.projectnmt.projectnmt.dto.resp.DonationListRespDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Donation {
    private int donationPageId;
    private int teamId;
    private int mainCategoryId;
    private String storyTitle;
    private LocalDateTime createDate;
    private LocalDateTime endDate;
    private int goalAmount;
    private String mainImgUrl;
    private int donationTagId;
    private Team team;
    private MainCategory mainCategory;
    private DonationTag donationTag;

    public DonationListRespDto toDonationListRespDto() {
        return DonationListRespDto.builder()
                .donationPageId(donationPageId)
                .teamName(team.getTeamName())
                .mainCategoryName(mainCategory.getMainCategoryName())
                .storyTitle(storyTitle)
                .createDate(createDate)
                .endDate(endDate)
                .goalAmount(goalAmount)
                .mainImgUrl(mainImgUrl)
                .donationTagName(donationTag.getDonationTagName())
                .build();
    }





}