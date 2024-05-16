package com.projectnmt.projectnmt.service;

import com.projectnmt.projectnmt.dto.AmountRespDto;
import com.projectnmt.projectnmt.dto.ProgressAmountReqDto;
import com.projectnmt.projectnmt.dto.ProgressAmountRespDto;
import com.projectnmt.projectnmt.dto.req.DonationPageReqDto;
import com.projectnmt.projectnmt.dto.req.DonationPageUpdateReqDto;
import com.projectnmt.projectnmt.dto.resp.DonationPageRespDto;
import com.projectnmt.projectnmt.entity.*;
import com.projectnmt.projectnmt.repository.DonationMapper;
import com.projectnmt.projectnmt.repository.DonatorMapper;
import com.projectnmt.projectnmt.repository.TeamMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DonationPageService {

    @Autowired
    private DonationMapper donationMapper;
    @Autowired
    private DonatorMapper donatorMapper;
    @Autowired
    private TeamMapper teamMapper;

    @Autowired
    private TeamService teamService;


    public void saveDonationPage(DonationPageReqDto donationPageReqDto) throws IllegalAccessException {

        DonationPage donationPage = donationPageReqDto.toEntity();
        donationMapper.saveDonationPage(donationPage);
    }


    public DonationPageRespDto getDonationPage(DonationPageReqDto donationPageReqDto) {
        DonationPage donationStory = donationMapper.getDonationPage(
                donationPageReqDto.getDonationPageId(),
                donationPageReqDto.getTeamId(),
                donationPageReqDto.getMainCategoryId(),
                donationPageReqDto.getCreateDate(),
                donationPageReqDto.getEndDate(),
                donationPageReqDto.getStoryTitle(),
                donationPageReqDto.getStoryContent(),
                donationPageReqDto.getMainImgUrl(),
                donationPageReqDto.getDonationTagId(),
                donationPageReqDto.getDonationPageShow(),
                donationPageReqDto.getCountLike()
        );

        DonationPageRespDto donationPageRespDto = donationStory.toDonationPageRespDto();
        return donationPageRespDto;
    }



    @Transactional(rollbackFor = Exception.class)
    public void updatePage(DonationPageUpdateReqDto donationPageUpdateReqDto) throws IllegalAccessException {

        donationMapper.updatePageById(donationPageUpdateReqDto.toEntity());
    }

//    @Transactional(rollbackFor = Exception.class)
//    public void updatePage(DonationPageUpdateReqDto donationPageUpdateReqDto, int userId) throws IllegalAccessException {
//        if (!teamService.isTeamMember(donationPageUpdateReqDto.getTeamId(), userId)) {
//            throw new IllegalAccessException("수정 권한이 없습니다.");
//        }
//        TeamMember teamMember = teamMapper.findMemberByTeamIdAndUserId(donationPageUpdateReqDto.getTeamId(), userId);
//        if (teamMember == null || teamMember.getUserId() != userId) {
//            throw new IllegalAccessException("이 페이지를 수정할 권한이 없습니다.");
//        }
//        donationMapper.updatePageById(donationPageUpdateReqDto.toEntity());
//    }

    public boolean isUserPageOwner(int donationPageId, int userId) {
        DonationPage donationPage = donationMapper.findPageById(donationPageId);
        if (donationPage == null) {
            throw new IllegalArgumentException("해당 페이지가 존재하지 않습니다.");
        }
        // 페이지의 팀 ID를 통해 팀 멤버를 조회
        TeamMember teamMember = teamMapper.findMemberByTeamIdAndUserId(donationPage.getTeamId(), userId);
        // 팀 멤버가 존재하며, 조회된 팀 멤버의 팀 ID가 페이지의 팀 ID와 일치하는지 확인
        return teamMember != null && teamMember.getTeamId() == donationPage.getTeamId();
    }


    @Transactional(rollbackFor = Exception.class)
    public void deleteDonationPage(int donationPageId) throws IllegalAccessException {
        DonationPage donationPage = donationMapper.findPageById(donationPageId);
        donationMapper.deletePageById(donationPageId);
    }

    public AmountRespDto MainAmount() {
        return donatorMapper.saveAmount();
    }

    public ProgressAmountRespDto Homeprogressdonation(ProgressAmountReqDto progressAmountReqDto) {
        return donatorMapper.HomeDonation(progressAmountReqDto.getDonationPageId());

    }

    public List<Donator> AmountList() {

        return null;
    }
}