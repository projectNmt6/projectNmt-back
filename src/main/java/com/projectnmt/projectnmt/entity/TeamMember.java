package com.projectnmt.projectnmt.entity;

import lombok.Data;

@Data
public class TeamMember {
    private int teamMemberId;
    private int teamId;
    private int userId;
    private int teamRoleId;
}
