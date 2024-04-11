package com.projectnmt.projectnmt.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class GetMyDonationListReqDtd {
    public int donationPageId;
    public int donationAmount;
    public LocalDate donationDate;
    public String storyTitle;
}
