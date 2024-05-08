package com.projectnmt.projectnmt.dto.req;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DonationGivingReqDto {
    private int donatorId;
    private int userId;
    private LocalDateTime donationDate;
    // 기부 금액
    private int amount;
    // 기부시 전송할 메시지
    private int donationPageId;
    // 익명 여부
    private int donatorAnonymous;
    private String message;
}