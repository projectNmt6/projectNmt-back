package com.projectnmt.projectnmt.entity;

import com.projectnmt.projectnmt.dto.DonationListRespDto;
import com.projectnmt.projectnmt.dto.DonationTagRespDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DonationTag {
<<<<<<< HEAD

=======
>>>>>>> b23af363d0b51d0ee2f01244a70aab18685d87fc
    private int DonationTagId;
    private String DonationTagName;

    public DonationTagRespDto toDonationTagRespDto() {
        return DonationTagRespDto.builder()
                .DonationTagId(getDonationTagId())
                .DonationTagName(getDonationTagName())
                .build();
    }
}
