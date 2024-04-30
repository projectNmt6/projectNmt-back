package com.projectnmt.projectnmt.dto.resp;

import lombok.Data;

@Data
public class CommentListRespDto {
    private int donationCommentId;
    private String commentText;
    private String storyTitle;
    private String name;
}
