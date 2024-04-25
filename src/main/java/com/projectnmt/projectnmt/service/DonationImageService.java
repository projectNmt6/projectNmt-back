package com.projectnmt.projectnmt.service;

import com.projectnmt.projectnmt.dto.req.DonationImageReqDto;
import com.projectnmt.projectnmt.dto.req.DonationPageUpdateReqDto;
import com.projectnmt.projectnmt.dto.resp.DonationImageRespDto;
import com.projectnmt.projectnmt.entity.DonationImage;
import com.projectnmt.projectnmt.repository.DonationImageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DonationImageService {
    @Autowired
    private DonationImageMapper donationImageMapper;

    public void saveDonationImage(DonationImageReqDto donationImageReqDto) {
        donationImageMapper.saveDonationImages(donationImageReqDto.toEntity());

    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteDonationImage(int donationPageId){

        donationImageMapper.deleteDonationImageById(donationPageId);
    }

    public List<DonationImageRespDto> getDonationImageByDonationPageId(int donationPageId) {
        List<DonationImage> donationImages = donationImageMapper.getDonationImageByDonationPageId(donationPageId);
        return donationImages.stream().map(DonationImage::toDonationImageRespDto).collect(Collectors.toList());
    }

    public List<DonationImageRespDto> getDonationImageList(DonationImageReqDto donationImageReqDto) {
        List<DonationImage> donationImageList = donationImageMapper.getDonationImageLIst(
                donationImageReqDto.getDonationImageId(),
                donationImageReqDto.getDonationPageId(),
                donationImageReqDto.getDonationImageNumber(),
                donationImageReqDto.getDonationImageURL(),
                donationImageReqDto.getUserId()
        );

        return donationImageList.stream()
                .map(DonationImage::toDonationImageRespDto)
                .collect(Collectors.toList());
    }

    @Transactional(rollbackFor = Exception.class)
    public void updateImage(DonationImageReqDto donationImageReqDto) {
        donationImageMapper.updatePageById(donationImageReqDto.toEntity());
    }


}
