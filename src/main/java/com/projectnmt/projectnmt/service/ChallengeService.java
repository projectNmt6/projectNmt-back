package com.projectnmt.projectnmt.service;

import com.projectnmt.projectnmt.dto.req.*;
import com.projectnmt.projectnmt.dto.resp.ChallengePageListRespDto;
import com.projectnmt.projectnmt.dto.resp.ChallengePageRespDto;
import com.projectnmt.projectnmt.entity.ChallengePage;
import com.projectnmt.projectnmt.entity.DonationPage;
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

    @Autowired
    private TeamService teamService;

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
    public void updateChallengePage(ChallengeUpdatePageReqDto challengeUpdatePageReqDto, int userId) throws IllegalAccessException {
        if (!teamService.isTeamMember(challengeUpdatePageReqDto.getTeamId(), userId)) {
            throw new IllegalAccessException("수정 권한이 없습니다.");
        }
        TeamMember teamMember = teamMapper.findMemberByTeamIdAndUserId(challengeUpdatePageReqDto.getTeamId(), userId);
        if (teamMember == null || teamMember.getUserId() != userId) {
            throw new IllegalAccessException("이 페이지를 수정할 권한이 없습니다.");
        }
        challengeMapper.updatePageById(challengeUpdatePageReqDto.toEntity());


    }



    @Transactional(rollbackFor = Exception.class)
    public void deleteChallengePage(int challengePageId, int userId) throws IllegalAccessException, IllegalArgumentException {
        System.out.println(challengePageId);
        System.out.println(userId);
        ChallengePage challengePage = challengeMapper.findPageById(challengePageId);

        TeamMember teamMember = teamMapper.findMember(userId, challengePage.getTeamId());
        if(teamMember == null || teamMember.getUserId() != userId) {
            throw new IllegalAccessException("페이지를 삭제할 권한이 없습니다.");

        } System.out.println(teamMember.getTeamId());

        challengeMapper.deletePageById(challengePageId);
    }

    public boolean isUserPageOwner(int challengePageId, int userId) {
        ChallengePage challengePage = challengeMapper.findPageById(challengePageId);
        if (challengePage == null) {
            throw new IllegalArgumentException("해당 페이지가 존재하지 않습니다.");
        }
        // 페이지의 팀 ID를 통해 팀 멤버를 조회
        TeamMember teamMember = teamMapper.findMemberByTeamIdAndUserId(challengePage.getTeamId(), userId);
        // 팀 멤버가 존재하며, 조회된 팀 멤버의 팀 ID가 페이지의 팀 ID와 일치하는지 확인
        return teamMember != null && teamMember.getTeamId() == challengePage.getTeamId();
    }

}
