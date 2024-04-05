package com.projectnmt.projectnmt.repository;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.projectnmt.projectnmt.entity.DonationPage;
import com.projectnmt.projectnmt.entity.MainCategory;
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
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface DonationMapper {

    public int saveDonationPage(DonationPage donationPage);
    public List<Donation> getDonationList(
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

    public List<MainCategory> getMainCategoryList(
            @Param("mainCategoryId") int mainCategoryId,
            @Param("mainCategoryName") String mainCategoryName);


//    @Bean
//    public Jackson2ObjectMapperBuilder objectMapperBuilder() {
//        Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
//        builder.modules(new JavaTimeModule());
//        builder.featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
//        builder.simpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
//        return builder;
//    }
}


