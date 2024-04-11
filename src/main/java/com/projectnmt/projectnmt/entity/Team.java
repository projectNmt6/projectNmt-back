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
    private int teamTypeCategory;
    private String companyRegisterNumberUrl;
    private String teamLogoImgUrl;
    private int teamId;
    private String teamName;
    private int teamType;
    private String teamPhoneNumber;
    private String teamEmail;
    private int teamAccountNumber;
    private String teamAccountName;
    private String companyRegisterNumber;
    private String teamHomepage;
    private String teamInfoText;
    private TeamMember teamMember;
    private Account account;
}