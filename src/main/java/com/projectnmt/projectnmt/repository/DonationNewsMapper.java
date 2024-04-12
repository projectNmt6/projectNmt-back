package com.projectnmt.projectnmt.repository;

import com.projectnmt.projectnmt.entity.DonationNewsPage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DonationNewsMapper {

    public int saveDonationNewsPage(DonationNewsPage donationNewsPage);

    public DonationNewsPage getNewsPage(
            @Param("donationNewsPageId") Integer donationNewsPageId,
            @Param("donationPageId") Integer donationPageId,
            @Param("PageCategoryId") Integer pageCategoryId,
            @Param("newsContent") String newsContent,
            @Param("userId") Integer userId
    );

    public int updateNewsPageById(DonationNewsPage donationNewsPage);
}
