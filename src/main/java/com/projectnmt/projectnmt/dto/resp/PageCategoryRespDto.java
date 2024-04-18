package com.projectnmt.projectnmt.dto.resp;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PageCategoryRespDto {

    private int PageCategoryId; //page_category_id;
    private String PageCategoryName; //page_category_name;
}
