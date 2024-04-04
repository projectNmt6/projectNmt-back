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
    private int userId;
    //유저아이디
    private String username;
    //비밀번호
    private String password;
    //닉네임
    private String name;
    //휴대폰 번호
    private String phoneNumber;
    //이메일
    private String email;
    //성별
    private String gender;
    //생년월일
    private String age;
    //프로필 이미지
    private String profileImg;

    public PrincipalUserRespDto toDto() {
        LocalDate now = LocalDate.now();
        String[] arr = age.split("-");
        int now_age = now.getYear() - Integer.parseInt(arr[0]) + 1;
        return PrincipalUserRespDto.builder()
                .userId(userId)
                .username(username)
                .name(name)
                .email(email)
                .phone_number(phoneNumber)
                .gender(gender)
                .age(now_age)
                .img(profileImg)
                .build();
    }
}
