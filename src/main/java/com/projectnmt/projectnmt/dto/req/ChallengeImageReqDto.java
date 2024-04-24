package com.projectnmt.projectnmt.dto.req;

import lombok.Data;

@Data
public class ChallengeImageReqDto {
    private int challengeImageId; // AI
    private int challengePageId;
    private int challengeImageNumber; // 이미지의 순서
    private String challengeImageURL;
    private int userId;
}

