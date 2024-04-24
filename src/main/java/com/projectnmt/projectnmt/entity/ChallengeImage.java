package com.projectnmt.projectnmt.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ChallengeImage {

    private int challengeImageId; // AI
    private int challengePageId;
    private int challengeImageNumber; // 이미지의 순서
    private String challengeImageURL;
    private int userId;
}
