package com.projectnmt.projectnmt.entity;

import com.projectnmt.projectnmt.dto.resp.CommentRespDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Comment {
    private int donationCommentId;
    private String commentText;
    private int donationPageId;
    private int userId;
    private User user;
    private DonationPage donationPage;


    public CommentRespDto toSaveComment() {

        return CommentRespDto.builder()
                .donationCommentId(donationCommentId)
                .commentText(commentText)
                .donationPageId(donationPageId)
                .userId(userId)
                .build();
    }

}