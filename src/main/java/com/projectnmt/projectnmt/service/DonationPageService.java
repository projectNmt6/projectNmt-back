package com.projectnmt.projectnmt.service;

import com.projectnmt.projectnmt.dto.AmountRespDto;
import com.projectnmt.projectnmt.dto.ProgressAmountReqDto;
import com.projectnmt.projectnmt.dto.ProgressAmountRespDto;
import com.projectnmt.projectnmt.dto.req.DonationImageReqDto;
import com.projectnmt.projectnmt.dto.req.DonationPageReqDto;
import com.projectnmt.projectnmt.dto.req.DonationPageUpdateReqDto;
import com.projectnmt.projectnmt.dto.resp.DonationPageRespDto;
import com.projectnmt.projectnmt.entity.*;
import com.projectnmt.projectnmt.repository.DonationImageMapper;
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
    private DonationImageMapper donationImageMapper;
    @Autowired
    private TeamMapper teamMapper;

    public void saveDonationPage(DonationPageReqDto donationPageReqDto) {
        DonationPage donationPage = donationPageReqDto.toEntity();
        donationMapper.saveDonationPage(donationPage);
//        List<DonationImage> list = donationPageReqDto.getDonationImages();
//        for(DonationImage donationImage : list){
//            donationImage.setDonationPageId(donationPage.getDonationPageId());
//            donationImageMapper.saveDonationImages(donationImage);
//        }
    }



    public void saveDonationNewsPage(DonationPageReqDto donationPageReqDto) {
        donationMapper.saveDonationNewsPage(donationPageReqDto.toEntity());
    }

    public DonationPageRespDto getDonationPage(DonationPageReqDto donationPageReqDto) {
        DonationPage donationStory = donationMapper.getDonationPage(
                donationPageReqDto.getDonationPageId());
        System.out.println(donationStory);
        DonationPageRespDto donationPageRespDto = donationStory.toDonationPageRespDto();
        return donationPageRespDto;
    }

    @Transactional(rollbackFor = Exception.class)
    public void updatePage(DonationPageUpdateReqDto donationPageUpdateReqDto) {
        // 페이지 정보 업데이트
        donationMapper.updatePageById(donationPageUpdateReqDto.toEntity());

        // 기존 이미지 삭제
        donationImageMapper.deleteDonationImageById(donationPageUpdateReqDto.getDonationPageId());

        // 새 이미지 업데이트
        List<DonationImage> list = donationPageUpdateReqDto.getDonationImages();
        for (DonationImage donationImage : list) {
            // 이미지의 페이지 ID 설정
            donationImage.setDonationPageId(donationPageUpdateReqDto.getDonationPageId());
            // 이미지 저장
            donationImageMapper.saveDonationImages(donationImage);
        }
    }



    @Transactional(rollbackFor = Exception.class)
    public void deleteDonationPage(int donationPageId, int userId) throws IllegalAccessException, IllegalArgumentException {
        DonationPage donationPage = donationMapper.findPageById(donationPageId);
        if (donationPage == null) {
            throw new IllegalArgumentException("해당 기부 페이지가 존재하지 않습니다.");
        }

        TeamMember teamMember = teamMapper.findMember(userId, donationPage.getTeamId());
        if (teamMember == null || teamMember.getUserId() != userId) {
            throw new IllegalAccessException("이 페이지를 삭제할 권한이 없습니다.");
        }

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