package com.sawitpro.assignment.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationReq {
    @Size(min = 10, max = 13, message = " Minimum  length: 10 characters, max=13")
    @Pattern(regexp = "^08.*", message = " start with 08")
    private String phoneNumber;
    @NotEmpty(message = " can't empty")
    @Size(min=5,max=60,message=" Min 5, Max name length=60")
    private String name;
    @Size(min = 6, max = 16, message = " Minimum phoneNumber length: 10 characters, max=13")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[A-Z]).+$",message = " 1 number,1 capital")
    private String password;
}
