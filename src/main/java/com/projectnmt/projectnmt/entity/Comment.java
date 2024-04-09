package com.projectnmt.projectnmt.entity;

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
}
