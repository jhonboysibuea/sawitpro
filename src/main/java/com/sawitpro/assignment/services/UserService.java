package com.sawitpro.assignment.services;

import com.sawitpro.assignment.model.User;
import com.sawitpro.assignment.model.request.RegistrationReq;

public interface UserService {
    User getDetail(String phoneNumber);
    User registration(RegistrationReq registrationReq);
    String login(String phoneNumber,String password);
    String updateName(String phoneNumber,String name);
}
