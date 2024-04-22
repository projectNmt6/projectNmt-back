package com.projectnmt.projectnmt.service;

import com.projectnmt.projectnmt.dto.req.ChallengePageListReqDto;
import com.projectnmt.projectnmt.dto.req.ChallengePageReqDto;
import com.projectnmt.projectnmt.dto.req.DonationPageReqDto;
import com.projectnmt.projectnmt.dto.resp.ChallengePageListRespDto;
import com.projectnmt.projectnmt.dto.resp.ChallengePageRespDto;
import com.projectnmt.projectnmt.dto.resp.DonationPageRespDto;
import com.projectnmt.projectnmt.entity.ChallengePage;
import com.projectnmt.projectnmt.entity.DonationPage;
import com.projectnmt.projectnmt.repository.ChallengeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChallengeService {

    @Autowired
    private ChallengeMapper challengeMapper;

    public void saveChallengePage(ChallengePageReqDto challengePageReqDto) {
        challengeMapper.saveChallengePage(challengePageReqDto.toEntity());
    }

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



}
