package com.projectnmt.projectnmt.repository;

import com.projectnmt.projectnmt.entity.DonationPage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DonationMapper {

    public int saveDonationPage(DonationPage donationPage);


}
