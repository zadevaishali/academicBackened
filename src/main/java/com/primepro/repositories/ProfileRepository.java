package com.primepro.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.primepro.models.Profile;
import com.primepro.models.Login;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
   Optional<Profile> findByUser(Login user);
   
}
