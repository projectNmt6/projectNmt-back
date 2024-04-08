package com.projectnmt.projectnmt.service;

import com.projectnmt.projectnmt.dto.DonationGivingReqDto;
import com.projectnmt.projectnmt.entity.Comment;
import com.projectnmt.projectnmt.entity.Donator;
import com.projectnmt.projectnmt.repository.DonationMapper;
import com.projectnmt.projectnmt.repository.DonatorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    }
