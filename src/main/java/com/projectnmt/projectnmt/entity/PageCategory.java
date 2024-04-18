package com.projectnmt.projectnmt.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data

@NoArgsConstructor
@AllArgsConstructor
public class PageCategory {
    // 1. 본문 ("/story")
    // 2. 기부현황 ("/donators")
    // 3. 후기 ("/news")

    private int PageCategoryId; //page_category_id;
    private String PageCategoryName; //page_category_name;

}
