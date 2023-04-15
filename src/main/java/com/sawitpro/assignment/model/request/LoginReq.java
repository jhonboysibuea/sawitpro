package com.sawitpro.assignment.model.request;

import lombok.Data;

@Data
public class LoginReq {
    private String phoneNumber;
    private String password;
}
