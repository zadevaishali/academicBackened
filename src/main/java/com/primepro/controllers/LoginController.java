package com.primepro.controllers;

import com.primepro.exception.EmailException;
import com.primepro.models.Login;
import com.primepro.models.LogoutRequest;
import com.primepro.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class LoginController {
	@Autowired
	private LoginService loginService;

	@PostMapping("/login")
	public ResponseEntity<?> validateLogin(@RequestBody Login login) {
		if (Objects.nonNull(login)) {
			try {
				return loginService.validateLogin(login);
			} catch (EmailException e) {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
			}
		}
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username & password");
	}

	@PostMapping("/logout")
	public ResponseEntity<?> userLogout(@RequestBody LogoutRequest logoutRequest) {
		if (Objects.nonNull(logoutRequest) && !logoutRequest.getUsername().isEmpty()) {
			return loginService.logoutUser(logoutRequest);
		}
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username & password");
	}

	@GetMapping("/loadAllUsers")
	public Iterable<Login> loadAllUsers() {

		return loginService.loadAllUsers();
	}

}