package com.projectnmt.projectnmt.repository;

import com.projectnmt.projectnmt.entity.DonationPage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.projectnmt.projectnmt.entity.Donation;
import com.projectnmt.projectnmt.entity.DonationTag;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface DonationMapper {

    public int saveDonationPage(DonationPage donationPage);

    public List<Donation> getDonationList(
            @Param("donationPageId") int donationPageId,
            @Param("teamId") int teamId,
            @Param("mainCategoryId") int mainCategoryId,
            @Param("donationName") String donationName,
            @Param("createDate") LocalDateTime createDate,
            @Param("endDate") LocalDateTime endDate,
            @Param("goalAmount") int goalAmount,
            @Param("mainImgUrl") String mainImgUrl,
            @Param("donationTagId") int donationTagId);

    public List<DonationTag> getDonationTagList(
            @Param("donationTagId") int donationTagId,
            @Param("donationTagName") String donationTagName);

    public List<DonationPage> getDonationPageList(
            @Param("donationPageId") Integer donationPageId,
            @Param("teamId") Integer teamId,
            @Param("mainCategoryId") Integer mainCategoryId,
            @Param("donationCategoryId") Integer donationCategoryId,
            @Param("donationName") String donationName,
            @Param("createDate") LocalDateTime createDate,
            @Param("endDate") LocalDateTime endDate,
            @Param("storyTitle") String storyTitle,
            @Param("storyContent") String storyContent,
            @Param("mainImgUrl") String mainImgUrl,
            @Param("donationTagId") Integer donationTagId,
            @Param("donationPageShow") Boolean donationPageShow);



}


