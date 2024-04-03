package com.projectnmt.projectnmt.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DonationTag {
    private int DonationTagId;
    private String DonationTagName;
}
