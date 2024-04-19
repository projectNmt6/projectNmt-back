package com.projectnmt.projectnmt.dto.resp;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class DonationGivingRespDto {
    private int donatorId;
    private int userId;
    private LocalDateTime donationDate;
    // 기부 금액
    private int amount;
    // 기부시 전송할 메시지
    private int donationPageId;
    // 익명 여부
    private boolean anonymous;
    private String message;

}
