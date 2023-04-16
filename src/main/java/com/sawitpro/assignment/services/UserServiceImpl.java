package com.sawitpro.assignment.services;

import com.sawitpro.assignment.model.User;
import com.sawitpro.assignment.model.UserRole;
import com.sawitpro.assignment.model.request.RegistrationReq;
import com.sawitpro.assignment.repository.UserRepository;
import com.sawitpro.assignment.security.JwtTokenProvider;
import exception.CustomException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    JwtTokenProvider jwtTokenProvider;
    @Autowired
    AuthenticationManager authenticationManager;

    @Override
    public User getDetail(String phoneNumber) {
        return userRepository.findByPhoneNumber(phoneNumber);
    }

    @Override
    public User registration(RegistrationReq registrationReq) {
        User userExist=userRepository.findByPhoneNumber(registrationReq.getPhoneNumber());
        if(userExist!=null)
            throw new CustomException("phone number already exist",HttpStatus.BAD_REQUEST);
        User user=new User();
        BeanUtils.copyProperties(registrationReq,user);
        user.setPassword(passwordEncoder.encode(registrationReq.getPassword()));
        List<UserRole> userRoleList=new LinkedList<>();
        userRoleList.add(UserRole.ROLE_CLIENT);
        user.setUserRoles(userRoleList);
        userRepository.save(user);
        return user;
    }

    @Override
    public String login(String phoneNumber, String password) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(phoneNumber, password));
            return jwtTokenProvider.createToken(phoneNumber, userRepository.findByPhoneNumber(phoneNumber).getUserRoles());
        } catch (AuthenticationException e) {
            throw new CustomException("Invalid username/password supplied", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @Override
    public String updateName(String phoneNumber, String name) {
        User user=userRepository.findByPhoneNumber(phoneNumber);
        if(user==null){
            throw new CustomException("Data not found",HttpStatus.BAD_REQUEST);
        }
        user.setName(name);
        userRepository.save(user);
        return "success";
    }
}
