package com.projectnmt.projectnmt.dto.req;

import lombok.Data;

@Data
public class AdminMessageReqDto {
    private String message;
    private int[] userId;
    private int isTeam;
    private int senderId;
}
