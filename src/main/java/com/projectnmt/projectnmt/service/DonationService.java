package com.projectnmt.projectnmt.service;

import com.projectnmt.projectnmt.dto.DonationListReqDto;
import com.projectnmt.projectnmt.dto.DonationListRespDto;
import com.projectnmt.projectnmt.dto.DonationTagReqDto;
import com.projectnmt.projectnmt.dto.DonationTagRespDto;
import com.projectnmt.projectnmt.dto.resp.DonationMainTag.DonationMainTagReqDto;
import com.projectnmt.projectnmt.dto.resp.DonationMainTag.DonationMainTagRespDto;
import com.projectnmt.projectnmt.entity.Donation;
import com.projectnmt.projectnmt.entity.DonationTag;
import com.projectnmt.projectnmt.entity.MainCategory;
import com.projectnmt.projectnmt.repository.DonationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class DonationService {

    @Autowired
    private DonationMapper donationMapper;
    public List<DonationListRespDto> getDonationList(DonationListReqDto donationListReqDto) {

             List<Donation> donations = donationMapper.getDonationList(
                donationListReqDto.getDonationPageId(),
                donationListReqDto.getTeamId(),
                donationListReqDto.getMainCategoryId(),
                donationListReqDto.getDonationName(),
                donationListReqDto.getCreateDate(),
                donationListReqDto.getEndDate(),
                donationListReqDto.getGoalAmount(),
                donationListReqDto.getMainImgUrl(),
                donationListReqDto.getDonationTagId()
                );

        return donations.stream().map(Donation::toDonationListRespDto).collect(Collectors.toList());
    }
    public List<DonationTagRespDto> getDonationTagList(DonationTagReqDto donationTagReqDto) {
        List<DonationTag> donationTag = donationMapper.getDonationTagList(
                donationTagReqDto.getDonationTagId(),
                donationTagReqDto.getDonationTagName()
        );

        return donationTag.stream().map(DonationTag::toDonationTagRespDto).collect(Collectors.toList());
    }

    public List<DonationMainTagRespDto> getMainCategoryList(DonationMainTagReqDto donationMainTagReqDto) {
        List<MainCategory> mainCategories = donationMapper.getMainCategoryList(
                donationMainTagReqDto.getMainCategoryId(),
                donationMainTagReqDto.getMainCategoryName()
        );
        return mainCategories.stream().map(MainCategory::toDonationMainTagResp).collect(Collectors.toList());
    }
}
