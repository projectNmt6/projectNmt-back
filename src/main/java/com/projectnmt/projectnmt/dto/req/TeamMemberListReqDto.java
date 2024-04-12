package com.projectnmt.projectnmt.dto.req;

import lombok.Data;

import java.util.List;

@Data
public class TeamMemberListReqDto {
    private int teamId;
    private List<Integer> userId;
}
