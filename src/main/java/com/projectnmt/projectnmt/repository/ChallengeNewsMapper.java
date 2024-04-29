package com.projectnmt.projectnmt.repository;

import com.projectnmt.projectnmt.entity.ChallengeNewsPage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ChallengeNewsMapper {

    public int saveChallengeNewsPage(ChallengeNewsPage challengeNewsPage);

    public int updateChallengeNewsPageById(ChallengeNewsPage challengeNewsPage);

    public ChallengeNewsPage getChallengeNewsPage(
            @Param("challengeNewsPageId") int challengeNewsPageId,
            @Param("challengePageId") int challengePageId,
            @Param("pageCategoryId") int pageCategoryId,
            @Param("challengeNewsContent") String challengeNewsContent,
            @Param("teamId") int teamId
    );

    ChallengeNewsPage getNewsByChallengePageId(@Param("challengePageId") int challengePageId);
}
