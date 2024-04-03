package com.projectnmt.projectnmt.service;

import com.projectnmt.projectnmt.dto.req.DonationPageReqDto;
import com.projectnmt.projectnmt.repository.DonationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DonationPageService {

    @Autowired
    private DonationMapper donationMapper;

    public void saveDonationPage(DonationPageReqDto donationPageReqDto) {
        donationMapper.saveDonationPage(donationPageReqDto.toEntity());
    }


}
