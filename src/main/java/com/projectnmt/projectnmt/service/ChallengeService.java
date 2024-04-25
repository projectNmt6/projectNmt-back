package com.projectnmt.projectnmt.service;

import com.projectnmt.projectnmt.dto.req.*;
import com.projectnmt.projectnmt.dto.resp.ChallengePageListRespDto;
import com.projectnmt.projectnmt.dto.resp.ChallengePageRespDto;
import com.projectnmt.projectnmt.entity.ChallengePage;
import com.projectnmt.projectnmt.entity.TeamMember;
import com.projectnmt.projectnmt.repository.ChallengeMapper;
import com.projectnmt.projectnmt.repository.DonatorMapper;
import com.projectnmt.projectnmt.repository.TeamMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChallengeService {

    @Autowired
    private ChallengeMapper challengeMapper;
    @Autowired
    private DonatorMapper donatorMapper;
    @Autowired
    private TeamMapper teamMapper;


    public void saveChallengePage(ChallengePageReqDto challengePageReqDto) {
        ChallengePage challengePage = challengePageReqDto.toEntity();
        challengeMapper.saveChallengePage(challengePage);

        }


//    public void saveChallengeNewsPage(ChallengePageReqDto challengePageReqDto) {
//        challengeMapper.saveChallengeNewsPage(challengePageReqDto.toEntity());
//    }

    public ChallengePageRespDto getChallengePage (ChallengePageReqDto challengePageReqDto) {

        ChallengePage challengePage = challengeMapper.getChallengePage(
                challengePageReqDto.getChallengePageId(),
                challengePageReqDto.getTeamId(),
                challengePageReqDto.getMainCategoryId(),
                challengePageReqDto.getPageCategoryId(),
                challengePageReqDto.getCreateDate(),
                challengePageReqDto.getEndDate(),
                challengePageReqDto.getChallengeTitle(),
                challengePageReqDto.getChallengeOverview(),
                challengePageReqDto.getChallengeContent(),
                challengePageReqDto.getChallengeMainImg(),
                challengePageReqDto.getChallengePageShow()
        );

        ChallengePageRespDto challengePageRespDto =
                challengePage.toChallengePageRespDto();
        return challengePageRespDto;

    }

    public List<ChallengePageListRespDto> getChallengeList(ChallengePageListReqDto challengePageListReqDto) {
        List<ChallengePage> challengePageList = challengeMapper.getChallengePageList(
                challengePageListReqDto.getChallengePageId(),
                challengePageListReqDto.getTeamId(),
                challengePageListReqDto.getMainCategoryId(),
                challengePageListReqDto.getPageCategoryId(),
                challengePageListReqDto.getCreateDate(),
                challengePageListReqDto.getEndDate(),
                challengePageListReqDto.getChallengeTitle(),
                challengePageListReqDto.getChallengeOverview(),
                challengePageListReqDto.getChallengeContent(),
                challengePageListReqDto.getChallengeMainImg()
        );

        // 결과가 null인 경우, 빈 리스트 반환
        if (challengePageList == null) {
            return Collections.emptyList();
        }

        // 결과가 null이 아닌 경우, DTO로 매핑하여 반환
        return challengePageList.stream()
                .map(ChallengePage::toChallengePageListRespDto)
                .collect(Collectors.toList());
    }


    @Transactional(rollbackFor = Exception.class)
    public void updateChallengePage(ChallengeUpdatePageReqDto challengeUpdatePageReqDto) {
        challengeMapper.updatePageById(challengeUpdatePageReqDto.toEntity());

//        challengeImageMapper.deleteChallengeImageByPageId(challengeUpdatePageReqDto.getChallengePageId());
//        List<ChallengeImage> list = challengeUpdatePageReqDto.getChallengeImages();
//        for(ChallengeImage challengeImage : list) {
//            challengeImage.setChallengePageId(challengeUpdatePageReqDto.getChallengePageId());
//            challengeImageMapper.saveChallengeImages(challengeImage);
//        }
    }


    @Transactional(rollbackFor = Exception.class)
    public void deleteChallengePage(int challengePageId, int userId) throws Exception {
        ChallengePage challengePage = challengeMapper.findPageById(challengePageId);
        if (challengePage == null) {
            throw new IllegalArgumentException("페이지가 존재하지 않습니다.");

        }

        TeamMember teamMember = teamMapper.findMember(userId, challengePage.getTeamId());
        if(teamMember == null || teamMember.getTeamId() != userId) {
            throw new IllegalAccessException("페이지를 삭제할 권한이 없습니다.");
        }

        challengeMapper.deletePageById(challengePageId);
    }


}
