package com.likelion.springsecuritysession.service;

import com.likelion.springsecuritysession.domain.SiteUser;
import com.likelion.springsecuritysession.domain.UserRole;
import com.likelion.springsecuritysession.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public SiteUser create(String username, String email, String password, UserRole userRole) {
        SiteUser user = new SiteUser();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        user.setUserRole(userRole);
        this.userRepository.save(user);
        return user;
    }
}