package com.primepro.controllers;


import com.primepro.exception.EmailException;
import com.primepro.models.Registration;
import com.primepro.services.RegistrationService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;
import java.util.Optional;

@RestController
public class RegistrationController {
    @Autowired
    private RegistrationService registrationService;
    @PostMapping("/registration")
    @Transactional(rollbackOn = EmailException.class)
    public ResponseEntity<String> saveRegistrationData(@RequestBody Registration registration){
        if(Objects.nonNull(registration)){
            Optional<Registration> byUsername = registrationService.findByUsername(registration.getUsername());
            if(byUsername.isEmpty()){
                if(registrationService.save(registration)!=null){
//                    try {
//                        registrationService.sendWelcomeEmail(registration.getUsername());
//                    } catch (EmailException e) {
//                        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
//                    }
                    return ResponseEntity.ok("Registration successful");
                }else {
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Registration failed");
                }
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Username already exists");
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Registration details not provided");
    }
    @GetMapping("/loadRegistrations")
    public Iterable<Registration> loadAllRegistrationData(){
        return registrationService.loadRegistrationData();
    }

}
