package com.projectnmt.projectnmt.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OAuth2 {
    private int oAuth2Id;
    private String oAuth2Name;
    private int userId;
    private String providerName;
}
