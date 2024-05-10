package com.projectnmt.projectnmt.dto.resp;

import lombok.Data;

@Data
public class CommentListRespDto {
    private int donationCommentId;
    private int donationPageId;
    private String commentText;
    private String storyTitle;


    private String name;
    private String profileImg;

    private int reportCount;

}
