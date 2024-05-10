package com.projectnmt.projectnmt.dto.req;

import com.projectnmt.projectnmt.entity.DonationComment;
import com.projectnmt.projectnmt.entity.DonationPage;
import com.projectnmt.projectnmt.entity.User;
import lombok.Data;

@Data
public class DonationCommentReqDto {

    private int donationCommentId;
    private String commentText;
    private int donationPageId;
    private int userId;
    private User user;
    private DonationPage donationPage;

    private String name;
    private String profileImg;
    public DonationComment toEntity() {
        return DonationComment.builder()
                .donationCommentId(donationCommentId)
                .commentText(commentText)
                .donationPageId(donationPageId)
                .userId(userId)
                .name(name)
                .profileImg(profileImg)
                .build();
    }

}