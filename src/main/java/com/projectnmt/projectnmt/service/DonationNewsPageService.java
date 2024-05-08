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


    public void updateNewsPage(DonationNewsUpdateReqDto donationNewsUpdateReqDto, int userId) throws IllegalAccessException {
        if (!teamService.isTeamMember(donationNewsUpdateReqDto.getTeamId(), userId)) {
            throw new IllegalAccessException("페이지 수정 권한이 없습니다.");
        }
        donationNewsMapper.updateNewsPageById(donationNewsUpdateReqDto.toEntity());
    }

    public void saveDonationNewsPage(DonationNewsPageReqDto donationNewsPageReqDto, int pageId, int userId) throws IllegalAccessException {
        // 페이지 존재 여부 및 권한 확인
        DonationPage existingPage = donationMapper.findPageById(pageId);
        if (existingPage == null) {
            throw new IllegalArgumentException("해당 페이지가 존재하지 않습니다.");
        }
        // 유저 권한 확인
        if (!teamService.isTeamMember(existingPage.getTeamId(), userId)) {
            throw new IllegalAccessException("이 페이지를 수정할 권한이 없습니다.");
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
            return null;
        }
        DonationNewsPageRespDto donationNewsPageRespDto = donationNewsPage.toDonationNewsPageRespDto();
        return donationNewsPageRespDto;
    }

    public DonationNewsPageRespDto getDonationNewsByPageId(int donationPageId) {
        DonationNewsPage donationNewsPage = donationNewsMapper.getNewsByDonationPageId(donationPageId);
        return donationNewsPage.toDonationNewsPageRespDto();
    }


    private boolean isUserTeamMember(int teamId, int userId) {
        TeamMember teamMember = teamMapper.findMemberByTeamIdAndUserId(teamId, userId);
        return teamMember != null && teamMember.getUserId() == userId;
    }

public boolean isUserPageOwner(int pageId, int userId) {
    DonationPage donationPage = donationMapper.findPageById(pageId);
    if (donationPage == null) {
        throw new IllegalArgumentException("해당 페이지가 존재하지 않습니다.");
    }
    // TeamService의 isTeamMember를 사용하여 유저가 팀의 멤버인지 확인
    return teamService.isTeamMember(donationPage.getTeamId(), userId);
}


}
