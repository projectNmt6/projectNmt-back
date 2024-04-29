package com.projectnmt.projectnmt.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserCountRespDto {
    private int totalCount;
    private int maxPageNumber;
}
