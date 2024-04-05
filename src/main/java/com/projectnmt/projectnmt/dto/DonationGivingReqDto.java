package com.projectnmt.projectnmt.dto;

import lombok.Data;

@Data
public class DonationGivingReqDto {
    // 기부 금액
    private int amount;
    // 기부시 전송할 메시지
    private String message;
    // 익명 여부
    private boolean anonymous;
}
