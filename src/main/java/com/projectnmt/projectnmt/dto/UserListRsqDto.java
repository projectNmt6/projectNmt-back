package com.projectnmt.projectnmt.dto;

import lombok.Data;

@Data
public class UserListRsqDto {
    int pageNumber;
    int searchCount;
    String searchText;
    int selectedRoleoption;
    int selectedTextOption;
}
