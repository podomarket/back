package com.podomarket.user.repository;

import com.podomarket.entity.user.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users,Long> {

    Optional<Users> findByUserId(String userId);
    boolean existsByUserId(String userId);
    Optional<Users> findById(Long id);

    Optional<Users> findByEmail(String email);
}
