    package com.projectnmt.projectnmt.service;

    import com.projectnmt.projectnmt.dto.req.DonationListReqDto;
    import com.projectnmt.projectnmt.dto.req.DonationTagReqDto;
    import com.projectnmt.projectnmt.dto.resp.DonationListRespDto;
    import com.projectnmt.projectnmt.dto.resp.DonationMainTag.DonationMainTagReqDto;
    import com.projectnmt.projectnmt.dto.resp.DonationMainTag.DonationMainTagRespDto;
    import com.projectnmt.projectnmt.dto.resp.DonationTagRespDto;
    import com.projectnmt.projectnmt.entity.Donation;
    import com.projectnmt.projectnmt.entity.DonationTag;
    import com.projectnmt.projectnmt.entity.MainCategory;
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
                    donationListReqDto.getCreateDate(),
                    donationListReqDto.getEndDate(),
                    donationListReqDto.getGoalAmount(),
                    donationListReqDto.getStoryTitle(),
                    donationListReqDto.getMainImgUrl(),
                    donationListReqDto.getDonationTagId()
                    );

            return donations.stream().map(Donation::toDonationListRespDto).collect(Collectors.toList());
        }

        public List<DonationListRespDto> searchDonation(DonationListReqDto donationListReqDto1) {

            List<Donation> donations = donationMapper.searchDonation(
                    donationListReqDto1.getDonationPageId(),
                    donationListReqDto1.getTeamId(),
                    donationListReqDto1.getMainCategoryId(),
                    donationListReqDto1.getCreateDate(),
                    donationListReqDto1.getEndDate(),
                    donationListReqDto1.getGoalAmount(),
                    donationListReqDto1.getStoryTitle(),
                    donationListReqDto1.getMainImgUrl(),
                    donationListReqDto1.getDonationTagId()
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

        public List<DonationMainTagRespDto> getMainCategoryList(DonationMainTagReqDto donationMainTagReqDto) {
            List<MainCategory> mainCategories = donationMapper.getMainCategoryList(
                    donationMainTagReqDto.getMainCategoryId(),
                    donationMainTagReqDto.getMainCategoryName()
            );
            return mainCategories.stream().map(MainCategory::toDonationMainTagResp).collect(Collectors.toList());
        }
    }
