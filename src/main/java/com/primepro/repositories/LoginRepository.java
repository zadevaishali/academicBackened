package com.primepro.repositories;



import com.primepro.models.Login;
import com.primepro.models.Registration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoginRepository extends CrudRepository<Login,Long> {
    Iterable<Login> findByUsername(String username);
}