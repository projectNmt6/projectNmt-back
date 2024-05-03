package com.projectnmt.projectnmt.dto.resp;

import com.projectnmt.projectnmt.entity.DonationPage;
import com.projectnmt.projectnmt.entity.User;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CommentRespDto {

    private int donationCommentId;
    private String commentText;
    private int donationPageId;
    private int userId;
    private User user;
    private DonationPage donationPage;

    private String name;
    private String profileImg;

}
