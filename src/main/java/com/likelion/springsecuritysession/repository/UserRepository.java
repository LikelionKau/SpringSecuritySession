package com.likelion.springsecuritysession.repository;

import com.likelion.springsecuritysession.domain.SiteUser;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<SiteUser, Long> {
    Optional<SiteUser> findByusername(String username);
}