package com.projectnmt.projectnmt.dto.resp;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
@Builder
@Data
public class ActionBoardRespDto {
    private int actionBoardId;
    private int userId;
    private String actionContent;
    private int imageId;
    private String imageURL;
    private LocalDateTime createDate;
    private int challengePageId;

}
