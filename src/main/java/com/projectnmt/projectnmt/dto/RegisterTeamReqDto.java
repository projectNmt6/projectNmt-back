package com.projectnmt.projectnmt.dto;

import com.projectnmt.projectnmt.entity.Account;
import com.projectnmt.projectnmt.entity.Team;
import lombok.Data;

@Data
public class RegisterTeamReqDto {
    int userId;
    String teamName;
    boolean teamType;
    int teamTypeCategory;
    String teamPhone;
    String teamEmail;
    String companyRegisterNumber;
    String companyRegisterNumberCopyUrl;
    String teamHomepage;
    String teamInfoText;
    String teamLogoImgUrl;
    Account[] accountInfos;

    public Team toEntity() {
        return Team.builder()
                .teamName(teamName)
                .teamType(teamType ? 1 : 2)
                .teamTypeCategory(teamTypeCategory)
                .teamPhoneNumber(teamPhone)
                .teamEmail(teamEmail)
                .companyRegisterNumber(companyRegisterNumber)
                .companyRegisterNumberUrl(companyRegisterNumberCopyUrl)
                .teamHomepage(teamHomepage)
                .teamInfoText(teamInfoText)
                .teamLogoImgUrl(teamLogoImgUrl)
                .build();
    }
}
