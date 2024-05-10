package com.projectnmt.projectnmt.entity;

import com.projectnmt.projectnmt.dto.resp.DonationTagRespDto;
import com.projectnmt.projectnmt.dto.resp.LikeRespDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Like {
    private int donationPageId;
    private int userId;
    private int commentId;
    private int challengePageId;
}
