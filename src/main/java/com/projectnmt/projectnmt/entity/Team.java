package com.projectnmt.projectnmt.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Team {
    private int teamId;
    private String teamName;
    private int teamType;
    private String teamPhone;
    private String teamEmail;
    private int teamAccountNumber;
    private String teamAccountName;
    private String companyRegisterNumber;
    private String teamHomepage;
    private String teamInfoText;
}
