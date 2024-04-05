package com.projectnmt.projectnmt.dto;

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

    public Team toEntity() {
        return Team.builder()
                .teamName(teamName)
                .teamType(teamType ? 1 : 2)
                .teamTypeCategory(teamTypeCategory)
                .teamPhone(teamPhone)
                .teamEmail(teamEmail)
                .companyRegisterNumber(companyRegisterNumber)
                .companyRegisterNumberUrl(companyRegisterNumberCopyUrl)
                .teamHomepage(teamHomepage)
                .teamInfoText(teamInfoText)
                .teamLogoImgUrl(teamLogoImgUrl)
                .build();
    }
}
