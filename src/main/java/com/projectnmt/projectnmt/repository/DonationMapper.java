package com.projectnmt.projectnmt.repository;

import com.projectnmt.projectnmt.entity.Donation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface DonationMapper {
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
    }

