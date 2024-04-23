package com.projectnmt.projectnmt.entity;

import com.projectnmt.projectnmt.dto.resp.ActionBoardRespDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data

public class ActionBoard {

    private int actionBoardId;
    private int userId;
    private String actionContent;
    private int imageId;
    private String imageURL;
    private LocalDateTime createDate;
    private int challengePageId;

    public ActionBoardRespDto toActionBoardListRespDto() {
        return ActionBoardRespDto.builder()
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
