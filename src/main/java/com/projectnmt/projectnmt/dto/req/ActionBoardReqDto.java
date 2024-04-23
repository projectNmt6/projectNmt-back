package com.projectnmt.projectnmt.dto.req;

import com.projectnmt.projectnmt.entity.ActionBoard;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class ActionBoardReqDto {
    private int actionBoardId;
    private int userId;
    private String actionContent;
    private int imageId;
    private String imageURL;
    private LocalDateTime createDate;
    private int challengePageId;

    public ActionBoard toEntity() {
        return ActionBoard.builder()
                .actionBoardId(actionBoardId)
                .userId(userId)
                .actionContent(actionContent)
                .imageId(imageId)
                .imageURL(imageURL)
                .createDate(createDate)
                .challengePageId(challengePageId)
                .build();
    }
}
