package com.projectnmt.projectnmt.dto.resp;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class DonatorListRespDto {
    private int donatorId;
    private int userId;
    private LocalDateTime donationDate;
    private int donationAmount;
    private int donationPageId;
    private int donatorAnonymous;
}


