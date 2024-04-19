package com.projectnmt.projectnmt.dto.resp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

    @Builder
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class LikeRespDto {
        private int isLiked;
        private int countLike;
    }

