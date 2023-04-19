package com.sj.algosphere.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sj.algosphere.models.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    User findByEmail(String email);
    
}
