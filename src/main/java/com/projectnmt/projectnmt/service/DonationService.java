package com.projectnmt.projectnmt.service;

import com.projectnmt.projectnmt.dto.DonationListReqDto;
import com.projectnmt.projectnmt.dto.DonationListRespDto;
import com.projectnmt.projectnmt.entity.Donation;
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
}
