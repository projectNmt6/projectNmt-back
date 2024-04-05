package com.projectnmt.projectnmt.service;

import com.projectnmt.projectnmt.dto.DonationGivingReqDto;
import com.projectnmt.projectnmt.repository.DonationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DonationGivingService {

    @Autowired
    DonationMapper donationMapper;

    public void processDonation(DonationGivingReqDto donationGivingReqDto) {
        if (donationGivingReqDto.getAmount() < 0) {
            throw new IllegalArgumentException("기부 금액은 음수일 수 없습니다.");
        }

    }
}
