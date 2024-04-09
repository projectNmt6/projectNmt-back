package com.projectnmt.projectnmt.entity;


import com.projectnmt.projectnmt.dto.resp.DonationMainTag.DonationMainTagRespDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MainCategory {
        private int mainCategoryId;
        private String mainCategoryName;

        public DonationMainTagRespDto toDonationMainTagResp() {
                return DonationMainTagRespDto.builder()
                        .mainCategoryId(getMainCategoryId())
                        .mainCategoryName(getMainCategoryName())
                        .build();
        }
}
