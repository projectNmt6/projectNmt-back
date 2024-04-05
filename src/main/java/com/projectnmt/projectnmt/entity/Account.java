package com.projectnmt.projectnmt.entity;

import lombok.Data;

@Data
public class Account {
    private int teamId;
    private String accountUsername;
    private String accountNumber;
    private String bankName;
    private String accountUrl;
}
