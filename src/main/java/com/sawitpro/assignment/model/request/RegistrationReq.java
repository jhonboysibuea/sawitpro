package com.sawitpro.assignment.model.request;

import lombok.Data;

@Data
public class RegistrationReq {
    private String phoneNumber;
    private String name;
    private String password;
}
