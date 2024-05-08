package com.projectnmt.projectnmt.repository;

import com.projectnmt.projectnmt.entity.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface DonationMapper {

    public int saveDonationPage(DonationPage donationPage);

    public int saveDonationNewsPage(DonationPage donationPage);

    public List<Donation> getChallengeList(
            @Param("donationPageId") int donationPageId,
            @Param("teamId") int teamId,
            @Param("mainCategoryId") int mainCategoryId,
            @Param("createDate") LocalDateTime createDate,
            @Param("endDate") LocalDateTime endDate,
            @Param("goalAmount") int goalAmount,
            @Param("storyTitle") String storyTitle,
            @Param("mainImgUrl") String mainImgUrl,
            @Param("donationTagId") int donationTagId);


    public List<Donation> getDonationList(
            @Param("donationPageId") int donationPageId,
            @Param("teamId") int teamId,
            @Param("mainCategoryId") int mainCategoryId,
            @Param("createDate") LocalDateTime createDate,
            @Param("endDate") LocalDateTime endDate,
            @Param("goalAmount") int goalAmount,
            @Param("storyTitle") String storyTitle,
            @Param("mainImgUrl") String mainImgUrl,
            @Param("donationTagId") int donationTagId,
            @Param("countLike") Integer countLike);


    public List<Donation> searchDonation(
            @Param("donationPageId") int donationPageId,
            @Param("teamId") int teamId,
            @Param("mainCategoryId") int mainCategoryId,
            @Param("createDate") LocalDateTime createDate,
            @Param("endDate") LocalDateTime endDate,
            @Param("goalAmount") int goalAmount,
            @Param("storyTitle") String storyTitle,
            @Param("mainImgUrl") String mainImgUrl,
            @Param("donationTagId") int donationTagId);

    public List<DonationTag> getDonationTagList(
            @Param("donationTagId") int donationTagId,
            @Param("donationTagName") String donationTagName);

    public DonationPage getDonationPage(
            @Param("donationPageId") Integer donationPageId,
            @Param("teamId") Integer teamId,
            @Param("mainCategoryId") Integer mainCategoryId,
            @Param("createDate") LocalDateTime createDate,
            @Param("endDate") LocalDateTime endDate,
            @Param("storyTitle") String storyTitle,
            @Param("storyContent") String storyContent,
            @Param("mainImgUrl") String mainImgUrl,
            @Param("donationTagId") Integer donationTagId,
            @Param("donationPageShow") Integer donationPageShow);
            @Param("countLike") Integer countLike);

    public List<MainCategory> getMainCategoryList(
            @Param("mainCategoryId") int mainCategoryId,
            @Param("mainCategoryName") String mainCategoryName);

    public int updatePageById(DonationPage donationPage);

    public int deletePageById(@Param("donationPageId") int donationPageId);

    List<Donation> getCurrentFundraisings();
    List<Donation> getEndedFundraisings();

    public int findById(@Param("donationPageId") int donationPageId);
}


