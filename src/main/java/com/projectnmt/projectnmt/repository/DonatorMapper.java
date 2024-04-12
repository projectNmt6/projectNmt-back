package com.projectnmt.projectnmt.repository;

import com.projectnmt.projectnmt.dto.*;
import com.projectnmt.projectnmt.entity.Comment;
import com.projectnmt.projectnmt.entity.Donator;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DonatorMapper {
    public int saveDonation(DonationGivingReqDto donationGivingReqDto);
    public int saveComment(Comment comment);
    public List<MyDonationListRespDto> getMyList (GetMyDonationListReqDto getMyDonationListReqDto);
    public AmountRespDto saveAmount();
    public ProgressAmountRespDto HomeDonation();
}
