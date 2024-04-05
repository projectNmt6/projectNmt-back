package com.projectnmt.projectnmt.dto.resp.DonationMainTag;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class DonationMainTagRespDto {

    private int mainCategoryId;
    private String mainCategoryName;
}
