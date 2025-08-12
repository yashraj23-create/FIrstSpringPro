package com.example.demo.Repositary;

import com.example.demo.Entity.UserIdentity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IdentityRepository extends JpaRepository<UserIdentity,Long> {
 Optional<UserIdentity> findByUsername(String username);

}
