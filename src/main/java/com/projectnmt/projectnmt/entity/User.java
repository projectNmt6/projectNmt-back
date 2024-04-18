package com.projectnmt.projectnmt.entity;

import com.projectnmt.projectnmt.dto.PrincipalUserRespDto;
import com.projectnmt.projectnmt.security.PrincipalUser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class  User {
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

    private List<Authority> roleRegisters;
    private List<OAuth2> oAuth2s;
    public List<SimpleGrantedAuthority> getAuthorities() {
        return roleRegisters.stream().map(roleRegister -> new SimpleGrantedAuthority(roleRegister.getRole().getRoleName())).collect(Collectors.toList());
    }

    public PrincipalUser toPrincipalUser() {
        LocalDate now = LocalDate.now();
        String[] arr = age.split("-");
        int now_age = now.getYear() - Integer.parseInt(arr[0]) + 1;
        return PrincipalUser.builder()
                .userId(userId)
                .username(username)
                .name(name)
                .email(email)
                .phoneNumber(phoneNumber)
                .gender(gender)
                .age(now_age)
                .profileImg(profileImg)
                .authorities(getAuthorities())
                .build();
    }
}

