package com.projectnmt.projectnmt.dto;

import lombok.Data;

@Data
public class CommentReportReqDto {
    private int donationCommentId;
    private int userId;
    private int isDonation;
    private int donationPageId;
}