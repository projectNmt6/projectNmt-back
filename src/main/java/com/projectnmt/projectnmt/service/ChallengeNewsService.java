package com.projectnmt.projectnmt.service;

import com.projectnmt.projectnmt.dto.req.ChallengeNewsPageReqDto;
import com.projectnmt.projectnmt.dto.req.ChallengeNewsUpdateReqDto;
import com.projectnmt.projectnmt.dto.req.DonationNewsPageReqDto;
import com.projectnmt.projectnmt.dto.resp.ChallengeNewsPageRespDto;
import com.projectnmt.projectnmt.dto.resp.DonationNewsPageRespDto;
import com.projectnmt.projectnmt.entity.*;
import com.projectnmt.projectnmt.repository.ChallengeMapper;
import com.projectnmt.projectnmt.repository.ChallengeNewsMapper;
import com.projectnmt.projectnmt.repository.TeamMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChallengeNewsService {

    @Autowired
    private TeamService teamService;

    @Autowired
    private TeamMapper teamMapper;

    @Autowired
    private ChallengeNewsMapper challengeNewsMapper;

    @Autowired
    private ChallengeMapper challengeMapper;

    public void saveChallengeNewsPage(ChallengeNewsPageReqDto challengeNewsPageReqDto, int pageId) throws IllegalAccessException {

        ChallengeNewsPage challengeNewsPage = challengeNewsPageReqDto.toEntity();
        int count = challengeNewsMapper.saveChallengeNewsPage(challengeNewsPage);
        System.out.println("count:" + count);
    }


    public ChallengeNewsPageRespDto getChallengeNews(ChallengeNewsPageReqDto challengeNewsPageReqDto) {
        ChallengeNewsPage challengeNewsPage = challengeNewsMapper.getChallengeNewsPage(
                challengeNewsPageReqDto.getChallengeNewsPageId(),
                challengeNewsPageReqDto.getChallengePageId(),
                challengeNewsPageReqDto.getPageCategoryId(),
                challengeNewsPageReqDto.getChallengeNewsContent(),
                challengeNewsPageReqDto.getTeamId()
        );
        if (challengeNewsPage == null) {
            return null;
        }
        ChallengeNewsPageRespDto challengeNewsPageRespDto = challengeNewsPage.toChallengeNewsPageRespDto();
        return challengeNewsPageRespDto;
    }

    public ChallengeNewsPageRespDto getChallengeNewsByPageId(int challengePageId) {
        ChallengeNewsPage challengeNewsPage = challengeNewsMapper.getNewsByChallengePageId(challengePageId);
        if (challengeNewsPage == null) {
            System.out.println("No news page found with the given ID");
            return null; // Or handle the error as appropriate
        }
        return challengeNewsPage.toChallengeNewsPageRespDto();
    }

    private boolean isUserTeamMember(int teamId, int userId) {
        TeamMember teamMember = teamMapper.findMemberByTeamIdAndUserId(teamId, userId);
        return teamMember != null && teamMember.getUserId() == userId;
    }

    public boolean isUserPageOwner(int pageId, int userId) {
        ChallengePage challengePage = challengeMapper.findPageById(pageId);
        if (challengePage == null) {
            throw new IllegalArgumentException("해당 페이지가 존재하지 않습니다.");
        }
        // TeamService의 isTeamMember를 사용하여 유저가 팀의 멤버인지 확인
        return teamService.isTeamMember(challengePage.getTeamId(), userId);
    }

    public void updateChallengeNews(ChallengeNewsUpdateReqDto challengeNewsUpdateReqDto) throws IllegalAccessException {
        challengeNewsMapper.updateChallengeNewsPageById(challengeNewsUpdateReqDto.toEntity());
    }
}
