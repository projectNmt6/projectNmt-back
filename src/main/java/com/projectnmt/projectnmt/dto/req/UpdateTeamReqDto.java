package com.projectnmt.projectnmt.dto.req;

import com.projectnmt.projectnmt.entity.Account;
import com.projectnmt.projectnmt.entity.Team;
import lombok.Data;

@Data
public class UpdateTeamReqDto {
    int teamId;
    String teamPhoneNumber;
    String teamEmail;
    String teamHomepage;
    String teamInfoText;
    String teamLogoImgUrl;
    Account[] accountInfos;

    public Team toEntity() {
        return Team.builder()
                .teamId(teamId)
                .teamPhoneNumber(teamPhoneNumber)
                .teamEmail(teamEmail)
                .teamHomepage(teamHomepage)
                .teamInfoText(teamInfoText)
                .teamLogoImgUrl(teamLogoImgUrl)
                .build();
    }
}
