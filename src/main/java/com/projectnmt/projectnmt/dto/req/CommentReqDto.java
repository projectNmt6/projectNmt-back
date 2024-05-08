package com.projectnmt.projectnmt.dto.req;

import com.projectnmt.projectnmt.entity.Comment;
import com.projectnmt.projectnmt.entity.DonationPage;
import com.projectnmt.projectnmt.entity.User;
import lombok.Builder;
import lombok.Data;

@Data
public class CommentReqDto {

    private int donationCommentId;
    private String commentText;
    private int donationPageId;
    private int userId;
    private User user;
    private DonationPage donationPage;

    public Comment toEntity() {
        return Comment.builder()
                .donationCommentId(donationCommentId)
                .commentText(commentText)
                .donationPageId(donationPageId)
                .userId(userId)
                .build();
    }

}