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
            @Param("donationTagId") int donationTagId,
            @Param("donationImage")List<DonationImage> donationImages);

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
            @Param("donationImage")List<DonationImage> donationImages);



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
            @Param("donationPageId") int donationPageId);

    public List<MainCategory> getMainCategoryList(
            @Param("mainCategoryId") int mainCategoryId,
            @Param("mainCategoryName") String mainCategoryName);

    public int updatePageById(DonationPage donationPage);

    public int deletePageById(@Param("donationPageId") int donationPageId);

    DonationPage findPageById(@Param("donationPageId") int donationPageId);

    List<Donation> getCurrentFundraisings();
    List<Donation> getEndedFundraisings();



}


