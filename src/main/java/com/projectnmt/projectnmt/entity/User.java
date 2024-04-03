package com.projectnmt.projectnmt.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    private int userId;
    //유저아이디
    private String username;
    //비밀번호
    private String password;
    //닉네임
    private String name;
    //휴대폰 번호
    private String phonenumber;
    //이메일
    private String email;
    //성별
    private String gender;
    //생년월일
    private Date age;
    //프로필 이미지
    private String profileImg;
}
