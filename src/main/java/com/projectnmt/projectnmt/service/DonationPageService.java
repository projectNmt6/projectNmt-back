package com.projectnmt.projectnmt.service;

import com.projectnmt.projectnmt.dto.req.DonationListReqDto;
import com.projectnmt.projectnmt.dto.req.DonationPageReqDto;
import com.projectnmt.projectnmt.dto.resp.DonationPageRespDto;
import com.projectnmt.projectnmt.entity.Donation;
import com.projectnmt.projectnmt.entity.DonationPage;
import com.projectnmt.projectnmt.repository.DonationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DonationPageService {

    @Autowired
    private DonationMapper donationMapper;

    public void saveDonationPage(DonationPageReqDto donationPageReqDto) {
        donationMapper.saveDonationPage(donationPageReqDto.toEntity());
    }

    public List<DonationPageRespDto> getDonationPageList(DonationPageReqDto donationPageReqDto) {

        List<DonationPage> donationStory = donationMapper.getDonationPageList(
                donationPageReqDto.getDonationPageId(),
                donationPageReqDto.getTeamId(),
                donationPageReqDto.getMainCategoryId(),
                donationPageReqDto.getDonationCategoryId(),
                donationPageReqDto.getDonationName(),
                donationPageReqDto.getCreateDate(),
                donationPageReqDto.getEndDate(),
                donationPageReqDto.getStoryTitle(),
                donationPageReqDto.getStoryContent(),
                donationPageReqDto.getMainImgUrl(),
                donationPageReqDto.getDonationTagId(),
                donationPageReqDto.getDonationPageShow()
        );

        return donationStory.stream().map(DonationPage::toDonationPageListRespDto).collect(Collectors.toList());
    }
}
