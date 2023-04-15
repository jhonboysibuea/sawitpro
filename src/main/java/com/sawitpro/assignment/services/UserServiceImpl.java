package com.sawitpro.assignment.services;

import com.sawitpro.assignment.model.User;
import com.sawitpro.assignment.model.request.RegistrationReq;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Override
    public User getDetail(String phoneNumber) {
        return null;
    }

    @Override
    public void registration(RegistrationReq registrationReq) {

    }

    @Override
    public String login(String phoneNumber, String password) {
        return null;
    }

    @Override
    public String updateName(String name) {
        return null;
    }
}
