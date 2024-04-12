package com.projectnmt.projectnmt.service;

import com.projectnmt.projectnmt.dto.req.DonationNewsPageReqDto;
import com.projectnmt.projectnmt.dto.req.DonationNewsUpdateReqDto;
import com.projectnmt.projectnmt.dto.resp.DonationNewsPageRespDto;
import com.projectnmt.projectnmt.dto.resp.DonationNewsUpdateRespDto;
import com.projectnmt.projectnmt.entity.DonationNewsPage;
import com.projectnmt.projectnmt.entity.DonationPage;
import com.projectnmt.projectnmt.repository.DonationMapper;
import com.projectnmt.projectnmt.repository.DonationNewsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DonationNewsPageService {

    @Autowired
    private DonationNewsMapper donationNewsMapper;

    public DonationNewsPageRespDto getDonationNewsById(DonationNewsPageReqDto donationNewsPageReqDto) {
        DonationNewsPage donationNewsPage = donationNewsMapper.getNewsPage(
                donationNewsPageReqDto.getDonationNewsPageId(),
                donationNewsPageReqDto.getDonationPageId(),
                donationNewsPageReqDto.getPageCategoryId(),
                donationNewsPageReqDto.getNewsContent(),
                donationNewsPageReqDto.getUserId()

        );

        DonationNewsPageRespDto donationNewsPageRespDto =
                donationNewsPage.toDonationNewsPageRespDto();
        return donationNewsPageRespDto;
    }

    @Transactional(rollbackFor = Exception.class)
    public void updateNewsPage(DonationNewsUpdateReqDto donationNewsUpdateReqDto) {
        donationNewsMapper.updateNewsPageById(donationNewsUpdateReqDto.toEntity());
    }

    public DonationNewsPageRespDto getDonationNews(DonationNewsPageReqDto donationNewsPageReqDto) {
        DonationNewsPage donationNewsPage = donationNewsMapper.getNewsPage(
                donationNewsPageReqDto.getDonationNewsPageId(),
                donationNewsPageReqDto.getDonationPageId(),
                donationNewsPageReqDto.getPageCategoryId(),
                donationNewsPageReqDto.getNewsContent(),
                donationNewsPageReqDto.getUserId()
        );
        DonationNewsPageRespDto donationNewsPageRespDto = donationNewsPage.toDonationNewsPageRespDto();
        return donationNewsPageRespDto;
    }


    public void saveDonationNewsPage(DonationNewsPageReqDto donationNewsPageReqDto) {
        DonationNewsPage donationNewsPage = donationNewsPageReqDto.toEntity();
        donationNewsMapper.saveDonationNewsPage(donationNewsPage);
    }

}
