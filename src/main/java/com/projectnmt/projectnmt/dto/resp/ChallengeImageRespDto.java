package com.projectnmt.projectnmt.dto.resp;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ChallengeImageRespDto {
    private int challengeImageId; // AI
    private int challengePageId;
    private int challengeImageNumber; // 이미지의 순서
    private String challengeImageURL;
    private int userId;
}
