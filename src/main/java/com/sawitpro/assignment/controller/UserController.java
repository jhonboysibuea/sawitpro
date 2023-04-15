package com.sawitpro.assignment.controller;

import com.sawitpro.assignment.model.User;
import com.sawitpro.assignment.model.request.LoginReq;
import com.sawitpro.assignment.model.request.RegistrationReq;
import com.sawitpro.assignment.security.JwtTokenProvider;
import com.sawitpro.assignment.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/users")
public class UserController extends BaseAdviceController{

    @Autowired
    UserService userService;

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginReq req){

            String token = userService.login(req.getPhoneNumber(), req.getPassword());
            return new ResponseEntity<>(token, HttpStatus.OK);

    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody RegistrationReq req){
        userService.registration(req);
        return new ResponseEntity<>("success register", HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_CLIENT')")
    @PutMapping("/update/{name}")
    public ResponseEntity<?> updateName(HttpServletRequest request,@PathVariable("name")String name){
        String phoneNumber=jwtTokenProvider.getUsername(jwtTokenProvider.resolveToken(request));
        log.info("phoneNumber {}",phoneNumber);
        String status=userService.updateName(phoneNumber,name);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_CLIENT')")
    @GetMapping("/detail")
    public ResponseEntity<?> getDetail(HttpServletRequest req){
        String phoneNumber=jwtTokenProvider.getUsername(jwtTokenProvider.resolveToken(req));
        log.info("phoneNumber {}",phoneNumber);
        User user=userService.getDetail(phoneNumber);
        return new ResponseEntity<>(user.getName(), HttpStatus.OK);
    }
}
