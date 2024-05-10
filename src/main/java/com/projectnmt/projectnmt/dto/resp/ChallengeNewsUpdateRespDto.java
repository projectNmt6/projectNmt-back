package com.projectnmt.projectnmt.dto.resp;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ChallengeNewsUpdateRespDto {
    private int challengeNewsPageId;
    private int challengePageId;
    private int pageCategoryId;
    private String challengeNewsContent;
    private int teamId;
}
