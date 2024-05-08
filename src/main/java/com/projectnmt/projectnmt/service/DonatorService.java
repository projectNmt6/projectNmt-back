package com.projectnmt.projectnmt.service;

import com.projectnmt.projectnmt.dto.req.DonationListReqDto;
import com.projectnmt.projectnmt.dto.req.DonatorListReqDto;
import com.projectnmt.projectnmt.dto.resp.DonationListRespDto;
import com.projectnmt.projectnmt.dto.resp.DonatorListRespDto;
import com.projectnmt.projectnmt.entity.Donation;
import com.projectnmt.projectnmt.entity.Donator;
import com.projectnmt.projectnmt.repository.DonatorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class DonatorService {
    @Autowired
    DonatorMapper donatorMapper;

    public List<DonatorListRespDto> getDonatorList(DonatorListReqDto donatorListReqDto) {
        List<Donator> donators = donatorMapper.getDonatorList(
                donatorListReqDto.getDonatorId(),
                donatorListReqDto.getUserId(),
                donatorListReqDto.getDonationDate(),
                donatorListReqDto.getDonationAmount(),
                donatorListReqDto.getDonationPageId(),
                donatorListReqDto.getDonatorAnonymous(),
                donatorListReqDto.getUsername(),
                donatorListReqDto.getStoryTitle(),
                donatorListReqDto.getMainImgUrl(),
                donatorListReqDto.getGoalAmount(),
                donatorListReqDto.getAddAmount()
        );
        return donators.stream().map(Donator::toDonatorListRespDto).collect(Collectors.toList());
    }
    public List<DonatorListRespDto> getDonatorListByPageId(int pageId) {
        List<Donator> donators = donatorMapper.getDonatorListByPageId(pageId);
        return donators.stream().map(Donator::toDonatorListRespDto).collect(Collectors.toList());
    }
}