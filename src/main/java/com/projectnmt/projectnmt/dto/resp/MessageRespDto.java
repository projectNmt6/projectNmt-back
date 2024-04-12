package com.projectnmt.projectnmt.dto.resp;

import lombok.Data;

@Data
public class MessageRespDto {
    private int messageId;
    private String teamLogoImgUrl;
    private String teamName;
    private String message;
    private String date;
}
