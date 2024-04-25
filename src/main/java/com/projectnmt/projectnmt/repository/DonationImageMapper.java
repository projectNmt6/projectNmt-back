package com.projectnmt.projectnmt.repository;

import com.projectnmt.projectnmt.entity.DonationImage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface DonationImageMapper {

    public int saveDonationImages(DonationImage donationImage);

    public int deleteDonationImageById(@Param("donationPageId") int donationPageId);

    public List<DonationImage> getDonationImageLIst(
            @Param("donationImageId") int donationImageId,
            @Param("donationPageId") int donationPageId,
            @Param("donationImageNumber") int donationImageNumber,
            @Param("donationImageURL") String donationImageURL,
            @Param("userId") int userId
    );

    List<DonationImage> getDonationImageByDonationPageId(int donationPageId);

    public int updatePageById(DonationImage donationImage);
}
