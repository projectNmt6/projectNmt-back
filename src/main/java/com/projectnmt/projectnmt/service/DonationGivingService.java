package com.projectnmt.projectnmt.service;

import com.projectnmt.projectnmt.dto.req.DonationGivingReqDto;
import com.projectnmt.projectnmt.dto.resp.DonationGivingRespDto;
import com.projectnmt.projectnmt.entity.Comment;
import com.projectnmt.projectnmt.entity.DonationComment;
import com.projectnmt.projectnmt.entity.Donator;
import com.projectnmt.projectnmt.repository.DonatorMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DonationGivingService {

    @Autowired
    DonatorMapper donatorMapper;

    public void processDonation(DonationGivingReqDto donationGivingReqDto) {
        int amount = donationGivingReqDto.getAmount();
        if (donationGivingReqDto.getAmount() < 0) {
            throw new IllegalArgumentException("기부 금액은 음수일 수 없습니다.");
        }
        donatorMapper.saveDonation(donationGivingReqDto);
        donatorMapper.saveComment(Comment.builder()
                .donationPageId(donationGivingReqDto.getDonationPageId())
                .commentText(donationGivingReqDto.getMessage())
                .userId(donationGivingReqDto.getUserId())
                .build());
    }

    public List<DonationGivingRespDto> getGivings(DonationGivingReqDto donationGivingReqDto) {

        List<Donator> donators = donatorMapper.getDonatorList(
                donationGivingReqDto.getDonatorId(),
                donationGivingReqDto.getUserId(),
                donationGivingReqDto.getDonationDate(),
                donationGivingReqDto.getAmount(),
                donationGivingReqDto.getDonationPageId(),
                donationGivingReqDto.getDonatorAnonymous()
        );
        return donators.stream().map(Donator::toSaveGivings).collect(Collectors.toList());
    }


    public List<DonationGivingRespDto> getDonationGivingByDonationPageId(int donationPageId) {
        List<Donator> donators = donatorMapper.getDonationGivingByDonationPageId(donationPageId);
        return donators.stream().map(Donator::toSaveGivings).collect(Collectors.toList());
    }






}