package com.projectnmt.projectnmt.entity;

import lombok.Data;

@Data
public class ChallengeNewsPage {

    private int challengeNewsPageId;
    private int challengePageId;
    private int pageCategoryId;
    private String challengeNewsContent;
    private int userId;
}
