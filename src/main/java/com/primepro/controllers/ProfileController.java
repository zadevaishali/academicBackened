package com.primepro.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.primepro.models.Profile;
import com.primepro.services.ProfileService;

//ProfileController.java
@RestController
@RequestMapping("/api/profiles")
public class ProfileController {

 @Autowired
 private ProfileService profileService;

 @PostMapping()
 public ResponseEntity<Profile> createProfile(@RequestBody Profile profile) {
     return new ResponseEntity<>(profileService.createProfile(profile), HttpStatus.CREATED);
 }
 


 @GetMapping("/{id}")
 public ResponseEntity<Profile> getProfile(@PathVariable Long id) {
     return profileService.getProfile(id)
         .map(ResponseEntity::ok)
         .orElse(ResponseEntity.notFound().build());
 }

 @PutMapping("/{id}")
 public ResponseEntity<Profile> updateProfile(@PathVariable Long id, @RequestBody Profile profileDetails) {
     return new ResponseEntity<>(profileService.updateProfile(id, profileDetails), HttpStatus.OK);
 }

 @DeleteMapping("/{id}")
 public ResponseEntity<Void> deleteProfile(@PathVariable Long id) {
     profileService.deleteProfile(id);
     return new ResponseEntity<>(HttpStatus.NO_CONTENT);
 }
}
