package com.projectnmt.projectnmt.service;

import com.projectnmt.projectnmt.dto.req.DonationNewsPageReqDto;
import com.projectnmt.projectnmt.dto.req.DonationNewsUpdateReqDto;
import com.projectnmt.projectnmt.dto.req.DonationPageReqDto;
import com.projectnmt.projectnmt.dto.resp.DonationNewsPageRespDto;
import com.projectnmt.projectnmt.dto.resp.DonationNewsUpdateRespDto;
import com.projectnmt.projectnmt.entity.DonationNewsPage;
import com.projectnmt.projectnmt.entity.DonationPage;
import com.projectnmt.projectnmt.entity.TeamMember;
import com.projectnmt.projectnmt.repository.DonationMapper;
import com.projectnmt.projectnmt.repository.DonationNewsMapper;
import com.projectnmt.projectnmt.repository.TeamMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DonationNewsPageService {

    @Autowired
    private DonationNewsMapper donationNewsMapper;

    @Autowired
    private TeamMapper teamMapper;

    @Autowired
    private DonationMapper donationMapper;
    @Autowired
    private TeamService teamService;


    public void updateNewsPage(DonationNewsUpdateReqDto donationNewsUpdateReqDto) throws IllegalAccessException {

        donationNewsMapper.updateNewsPageById(donationNewsUpdateReqDto.toEntity());
    }

    public void saveDonationNewsPage(DonationNewsPageReqDto donationNewsPageReqDto, int pageId) throws IllegalAccessException {
        // 페이지 존재 여부 및 권한 확인
        DonationPage existingPage = donationMapper.findPageById(pageId);
        if (existingPage == null) {
            throw new IllegalArgumentException("해당 페이지가 존재하지 않습니다.");
        }
        DonationNewsPage donationNewsPage = donationNewsPageReqDto.toEntity();
        int count = donationNewsMapper.saveDonationNewsPage(donationNewsPage);
        System.out.println("count:" + count);
    }

    public DonationNewsPageRespDto getDonationNews(DonationNewsPageReqDto donationNewsPageReqDto) {
        DonationNewsPage donationNewsPage = donationNewsMapper.getNewsPage(
                donationNewsPageReqDto.getDonationNewsPageId(),
                donationNewsPageReqDto.getDonationPageId(),
                donationNewsPageReqDto.getPageCategoryId(),
                donationNewsPageReqDto.getNewsContent(),
                donationNewsPageReqDto.getTeamId()
        );
        if (donationNewsPage == null) {
            System.out.println("given ID");
            return null; // 혹은 적절한 예외 처리 또는 오류 응답 반환
        }

        System.out.println(donationNewsPage);
        DonationNewsPageRespDto donationNewsPageRespDto = donationNewsPage.toDonationNewsPageRespDto();
        return donationNewsPageRespDto;
    }


    public DonationNewsPageRespDto getDonationNewsByPageId(int donationPageId) {
        DonationNewsPage donationNewsPage = donationNewsMapper.getNewsByDonationPageId(donationPageId);
        if (donationNewsPage == null) {
            System.out.println("No news page found with the given ID");
            return null; // Or handle the error as appropriate
        }
        System.out.println(donationNewsPage);
        return donationNewsPage.toDonationNewsPageRespDto();
    }




}
