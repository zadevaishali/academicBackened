package com.primepro.services;


import com.primepro.config.JwtTokenProvider;
import com.primepro.exception.EmailException;
import com.primepro.models.LoginResponse;
import com.primepro.models.LogoutRequest;
import com.primepro.repositories.LoginRepository;
//import com.primepro.util.EmailService;
import com.primepro.util.CommonUtils;
import com.primepro.models.Login;
import com.primepro.models.Registration;
import com.primepro.repositories.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

@Service
public class LoginService {

    @Autowired
    private RegistrationRepository repository;
//    @Autowired
//    private EmailService emailService;

    @Autowired
    private LoginRepository loginRepository;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    public ResponseEntity<?> validateLogin(Login login) throws EmailException {
        Optional<Registration> byUsername = repository.findByUsername(login.getUsername());
        if (byUsername.isPresent()) {
            Registration registration = byUsername.get();
            if (CommonUtils.checkPassword(login.getPassword(), registration.getPassword())) {
                Login login1=new Login();
                login1.setUsername(registration.getUsername());
                login1.setPassword(registration.getPassword());
                login1.setLoginTime(LocalDateTime.now());
                login1.setRole(login.getRole());
                loginRepository.save(login1);
                LoginResponse loginResponse=new LoginResponse();
                loginResponse.setFullName(registration.getFullName());
                loginResponse.setToken(jwtTokenProvider.generateToken(login1));
                loginResponse.setUsername(registration.getUsername());
                loginResponse.setRole(registration.getRole());
               // emailService.sendWelcomeEmail(login.getUsername(),"Successfully Login");
                return ResponseEntity.ok(loginResponse);
            }
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Password does not match");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Username not found");
        }
    }

    public ResponseEntity<?> logoutUser(LogoutRequest logoutRequest) {
        Iterable<Login> byUsername = loginRepository.findByUsername(logoutRequest.getUsername());
        for (Login login : byUsername) {
            if(Objects.isNull(login.getLogoutTime())){
                login.setLogoutTime(LocalDateTime.now());
                loginRepository.save(login);
                return ResponseEntity.ok("Successfully Logout");
            }
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Username not found");
    }

    public Iterable<Login> loadAllUsers() {
        return loginRepository.findAll();
    }
}