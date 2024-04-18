package com.projectnmt.projectnmt.service;

import com.projectnmt.projectnmt.dto.req.DonationPageReqDto;
import com.projectnmt.projectnmt.dto.resp.DonationPageRespDto;
import com.projectnmt.projectnmt.entity.DonationPage;
import com.projectnmt.projectnmt.repository.DonationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DonationPageService {

    @Autowired
    private DonationMapper donationMapper;

    public void saveDonationPage(DonationPageReqDto donationPageReqDto) {
        donationMapper.saveDonationPage(donationPageReqDto.toEntity());
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
                donationPageReqDto.getDonationPageShow()
        );

        DonationPageRespDto donationPageRespDto = donationStory.toDonationPageRespDto();
        return donationPageRespDto;
    }
}
