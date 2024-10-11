package com.primepro.services;

import com.primepro.exception.EmailException;
//import com.primepro.util.EmailService;
import com.primepro.models.Registration;
import com.primepro.repositories.RegistrationRepository;
import com.primepro.util.CommonUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegistrationService {
    @Autowired
    private RegistrationRepository registrationRepository;
//    @Autowired
//    private EmailService emailService;

    public Registration save(Registration registration) {
        registration.setPassword(CommonUtils.hashPassword(registration.getPassword()));
        return registrationRepository.save(registration);
    }
    public Optional<Registration> findByUsername(String username) {
        return registrationRepository.findByUsername(username);
    }
//    public void sendWelcomeEmail(String email) throws EmailException {
//        emailService.sendWelcomeEmail(email,"Welcome to Academic Profile Manager Application");

        /*SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Welcome to IMS Application");
        message.setText(getHtmlWelcomeEmail(email));
        message.setFrom("java_primepro@outlook.com");*/



   // }

    public Iterable<Registration> loadRegistrationData() {
        return registrationRepository.findAll();
    }
}