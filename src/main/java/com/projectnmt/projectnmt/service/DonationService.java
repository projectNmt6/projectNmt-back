package com.projectnmt.projectnmt.service;

import com.projectnmt.projectnmt.dto.req.DonationListReqDto;
import com.projectnmt.projectnmt.dto.resp.DonationListRespDto;
import com.projectnmt.projectnmt.dto.req.DonationTagReqDto;
import com.projectnmt.projectnmt.dto.resp.DonationTagRespDto;
import com.projectnmt.projectnmt.entity.Donation;
import com.projectnmt.projectnmt.entity.DonationTag;
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
}
