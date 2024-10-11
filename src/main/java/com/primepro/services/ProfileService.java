package com.primepro.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.primepro.exception.ResourceNotFoundException;
import com.primepro.models.Achievement;
import com.primepro.models.Course;
import com.primepro.models.Profile;
import com.primepro.models.Publication;
import com.primepro.repositories.AchievementRepository;
import com.primepro.repositories.CourseRepository;
import com.primepro.repositories.ProfileRepository;
import com.primepro.repositories.PublicationRepository;

//ProfileService.java
@Service
public class ProfileService {

 @Autowired
 private ProfileRepository profileRepository;
 @Autowired
 private CourseRepository courseRepository;
 @Autowired
 private AchievementRepository achievementRepository;
 
 @Autowired
 private PublicationRepository publicationRepository;

 public Profile createProfile(Profile profile) {
//	 for (Course course : profile.getCourses()) {
//	        if (course.getId() == null) {
//	            courseRepository.save(course); 
//	        }
//	    }
//	 for(Achievement achievement:profile.getAchievements())
//	 {
//		 if(achievement.getId()==null)
//		 {
//			 achievementRepository.save(achievement);
//		 }
//	 }
//	 
//	 for(Publication publication:profile.getPublications())
//	 {
//		 if(publication.getId()==null)
//		 {
//			 publicationRepository.save(publication);
//		 }
//	 }
//    
     return profileRepository.save(profile);
 }

 public Optional<Profile> getProfile(Long id) {
     return profileRepository.findById(id);
 }

 public Profile updateProfile(Long id, Profile profileDetails) {
     Profile profile = profileRepository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));
     profile.setName(profileDetails.getName());
     profile.setDepartment(profileDetails.getDepartment());
     profile.setBio(profileDetails.getBio());
     profile.setContactDetails(profileDetails.getContactDetails());
     return profileRepository.save(profile);
 }

 public void deleteProfile(Long id) {
     Profile profile = profileRepository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));
     profileRepository.delete(profile);
 }
}
