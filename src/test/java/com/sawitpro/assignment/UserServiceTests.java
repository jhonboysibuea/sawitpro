package com.sawitpro.assignment;

import com.sawitpro.assignment.model.User;
import com.sawitpro.assignment.model.request.RegistrationReq;
import com.sawitpro.assignment.repository.UserRepository;
import com.sawitpro.assignment.security.JwtTokenProvider;
import com.sawitpro.assignment.services.UserService;
import com.sawitpro.assignment.services.UserServiceImpl;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;


import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTests {


    @Mock
    private UserRepository userRepository;
    @Mock
    AuthenticationManager authenticationManager;

    @Mock
    JwtTokenProvider jwtTokenProvider;
    @Mock
    PasswordEncoder passwordEncoder;

    @InjectMocks
    private UserServiceImpl userService;

    private User user;

    @BeforeEach
    public void setup(){
        //employeeRepository = Mockito.mock(EmployeeRepository.class);
        //employeeService = new EmployeeServiceImpl(employeeRepository);
        user = User.builder()
                .id(1)
                .name("Jhon")
                .phoneNumber("082167772836")
                .password("Password")
                .build();
    }

    @Test
    public void testRegister() {

        RegistrationReq registrationReq=new RegistrationReq();
        registrationReq.setName("Jhon");
        registrationReq.setPassword("Password");
        registrationReq.setPhoneNumber("082167772836");
        User userRegister=userService.registration(registrationReq);
        assertThat(userRegister.getName(), is("Jhon"));

    }

    @Test
    public void testDetail() {

        given(userRepository.findByPhoneNumber("082167772836")).willReturn(user);

        User userExist=userService.getDetail(user.getPhoneNumber());

        assertThat(userExist.getName(), is("Jhon"));


    }

    @Test
    public void testUpdate() {

        given(userRepository.findByPhoneNumber("082167772836")).willReturn(user);

        String status=userService.updateName("082167772836","jhonUpdated");
        User userExist= userService.getDetail("082167772836");
        assertThat(status, is("success"));
        assertThat(userExist.getName(),is("jhonUpdated"));

    }

    @Test
    public void login(){
        given(userRepository.findByPhoneNumber("082167772836")).willReturn(user);
        String token=userService.login("082167772836","Password");
    }
}
