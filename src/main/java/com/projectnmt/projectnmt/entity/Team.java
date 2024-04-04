package com.projectnmt.projectnmt.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Team {
    int teamId;
    String teamName;
    int teamType;
    int teamTypeCategory;
    String teamPhoneNumber;
    String teamEmail;
    String companyRegisterNumber;
    String companyRegisterNumberUrl;
    String teamHomepage;
    String teamInfoText;
    String teamLogoImgUrl;
}
