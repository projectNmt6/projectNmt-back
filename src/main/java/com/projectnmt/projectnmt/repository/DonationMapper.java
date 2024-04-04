package com.projectnmt.projectnmt.repository;

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

    }

