package com.projectnmt.projectnmt.repository;

import com.projectnmt.projectnmt.entity.DonationNewsPage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DonationNewsMapper {

    public int saveDonationNewsPage(DonationNewsPage donationNewsPage);

    public DonationNewsPage getNewsPage(
            @Param("donationNewsPageId") int donationNewsPageId,
            @Param("donationPageId") int donationPageId,
            @Param("PageCategoryId") int pageCategoryId,
            @Param("newsContent") String newsContent,
            @Param("userId") int userId
    );

    List<DonationNewsPage> getAllNewsByDonationPageId(@Param("donationPageId") int donationPageId);
    public int updateNewsPageById(DonationNewsPage donationNewsPage);
    DonationNewsPage getNewsByDonationPageId(@Param("donationPageId") int donationPageId);
}
