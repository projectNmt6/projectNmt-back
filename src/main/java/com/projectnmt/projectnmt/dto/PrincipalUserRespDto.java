package com.projectnmt.projectnmt.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    private int userId;
    private String username;
    private String password;
    private String name;
    private String email;
    private String phone_number;
    private String gender;
    private int age;

}
