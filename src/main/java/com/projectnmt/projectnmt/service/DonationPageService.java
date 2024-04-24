package com.projectnmt.projectnmt.service;

import com.projectnmt.projectnmt.dto.AmountRespDto;
import com.projectnmt.projectnmt.dto.ProgressAmountReqDto;
import com.projectnmt.projectnmt.dto.ProgressAmountRespDto;
import com.projectnmt.projectnmt.dto.req.DonationImageReqDto;
import com.projectnmt.projectnmt.dto.req.DonationPageReqDto;
import com.projectnmt.projectnmt.dto.req.DonationPageUpdateReqDto;
import com.projectnmt.projectnmt.dto.resp.DonationPageRespDto;
import com.projectnmt.projectnmt.entity.DonationImage;
import com.projectnmt.projectnmt.entity.DonationPage;
import com.projectnmt.projectnmt.entity.Donator;
import com.projectnmt.projectnmt.repository.DonationImageMapper;
import com.projectnmt.projectnmt.repository.DonationMapper;
import com.projectnmt.projectnmt.repository.DonatorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DonationPageService {

    @Autowired
    private DonationMapper donationMapper;
    @Autowired
    private DonatorMapper donatorMapper;
    @Autowired
    private DonationImageMapper donationImageMapper;

    public void saveDonationPage(DonationPageReqDto donationPageReqDto) {
        DonationPage donationPage = donationPageReqDto.toEntity();
        donationMapper.saveDonationPage(donationPage);
        List<DonationImage> list = donationPageReqDto.getDonationImages();
        for(DonationImage donationImage : list){
            donationImage.setDonationPageId(donationPage.getDonationPageId());
            donationImageMapper.saveDonationImages(donationImage);
        }
    }

    public void saveDonationNewsPage(DonationPageReqDto donationPageReqDto) {
        donationMapper.saveDonationNewsPage(donationPageReqDto.toEntity());
    }

    public DonationPageRespDto getDonationPage(DonationPageReqDto donationPageReqDto) {

        DonationPage donationStory = donationMapper.getDonationPage(
                donationPageReqDto.getDonationPageId(),
                donationPageReqDto.getTeamId(),
                donationPageReqDto.getMainCategoryId(),
                donationPageReqDto.getCreateDate(),
                donationPageReqDto.getEndDate(),
                donationPageReqDto.getStoryTitle(),
                donationPageReqDto.getStoryContent(),
                donationPageReqDto.getMainImgUrl(),
                donationPageReqDto.getDonationTagId(),
                donationPageReqDto.getDonationPageShow()
        );

        DonationPageRespDto donationPageRespDto = donationStory.toDonationPageRespDto();
        return donationPageRespDto;
    }

    public DonationPageRespDto getChallengeList(DonationPageReqDto donationPageReqDto) {

        DonationPage donationStory = donationMapper.getDonationPage(
                donationPageReqDto.getDonationPageId(),
                donationPageReqDto.getTeamId(),
                donationPageReqDto.getMainCategoryId(),
                donationPageReqDto.getCreateDate(),
                donationPageReqDto.getEndDate(),
                donationPageReqDto.getStoryTitle(),
                donationPageReqDto.getStoryContent(),
                donationPageReqDto.getMainImgUrl(),
                donationPageReqDto.getDonationTagId(),
                donationPageReqDto.getDonationPageShow()
        );

        DonationPageRespDto donationPageRespDto =
                donationStory.toDonationPageRespDto();
        return donationPageRespDto;
    }

    @Transactional(rollbackFor = Exception.class)
    public void updatePage(DonationPageUpdateReqDto donationPageUpdateReqDto) {
        donationMapper.updatePageById(donationPageUpdateReqDto.toEntity());
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteDonationPage(int donationPageId) {
        donationMapper.deletePageById(donationPageId);
    }


    public AmountRespDto MainAmount() {
        return donatorMapper.saveAmount();
    }
    public ProgressAmountRespDto Homeprogressdonation(ProgressAmountReqDto progressAmountReqDto) {
        return donatorMapper.HomeDonation(progressAmountReqDto.getDonationPageId());

    }

    public List<Donator> AmountList() {

        return null;
    }
}