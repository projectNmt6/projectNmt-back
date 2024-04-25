package com.projectnmt.projectnmt.repository;

import com.projectnmt.projectnmt.entity.ChallengePage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface ChallengeMapper {

    public int saveChallengePage(ChallengePage challengePage);
    public int saveChallengeNewsPage(ChallengePage challengePage);

    public ChallengePage getChallengePage(
            @Param("challengePageId") int challengePageId,
            @Param("teamId") int teamId,
            @Param("mainCategoryId") int mainCategoryId,
            @Param("pageCategoryId") int pageCategoryId,
            @Param("createDate") LocalDateTime createDate,
            @Param("endDate") LocalDateTime endDate,
            @Param("challengePageTitle") String challengePageTitle,
            @Param("challengeOverview") String challengeOverview,
            @Param("challengePageContent") String challengePageContent,
            @Param("challengeMainImg") String challengeMainImg,
            @Param("challengePageShow") Boolean challengePageShow
    );

    public List<ChallengePage> getChallengePageList(
            @Param("challengePageId") int challengePageId,
            @Param("teamId") int teamId,
            @Param("mainCategoryId") int mainCategoryId,
            @Param("pageCategoryId") int pageCategoryId,
            @Param("createDate") LocalDateTime createDate,
            @Param("endDate") LocalDateTime endDate,
            @Param("challengePageTitle") String challengePageTitle,
            @Param("challengeOverview") String challengeOverview,
            @Param("challengePageContent") String challengePageContent,
            @Param("challengeMainImg") String challengeMainImg
    );

    public int updatePageById(ChallengePage challengePage);
    public int deletePageById(@Param("challengePageId") int challengePageId);

    ChallengePage findPageById(@Param("challengePageId") int challengePageId);



}