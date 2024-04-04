package com.projectnmt.projectnmt.entity;

import com.projectnmt.projectnmt.dto.PrincipalUserRespDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Year;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    private int user_id;
    private String username;
    private String password;
    private String name;
    private String email;
    private String phone_number;
    private String gender;
    private Date age;
    private String profile_img;
    public PrincipalUserRespDto toDto() {
        System.out.println(age.toString());
        LocalDate now = LocalDate.now();
        String[] arr = age.toString().split("-");
        int now_age = now.getYear() - Integer.parseInt(arr[0]) + 1;
        return PrincipalUserRespDto.builder()
                .userId(user_id)
                .username(username)
                .name(name)
                .email(email)
                .phone_number(phone_number)
                .gender(gender)
                .age(now_age)
                .img(profile_img)
                .build();
    }
}
