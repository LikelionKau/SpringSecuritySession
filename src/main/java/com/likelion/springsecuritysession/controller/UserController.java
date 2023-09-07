package com.likelion.springsecuritysession.controller;

import com.likelion.springsecuritysession.domain.UserCreateForm;
import com.likelion.springsecuritysession.domain.UserRole;
import com.likelion.springsecuritysession.repository.UserRepository;
import com.likelion.springsecuritysession.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @ModelAttribute("UserRoles")
    public UserRole[] userRoles() {
        return UserRole.values();
    }

    @GetMapping("/signup")
    public String signup(UserCreateForm userCreateForm) {
        return "signup_form";
    }

    @PostMapping("/signup")
    public String signup(@Valid UserCreateForm userCreateForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "signup_form";
        }

        if (!userCreateForm.getPassword1().equals(userCreateForm.getPassword2())) {
            bindingResult.rejectValue("password2", "passwordInCorrect",
                "2개의 패스워드가 일치하지 않습니다.");
            return "signup_form";
        }

        userService.create(userCreateForm.getUsername(),
            userCreateForm.getEmail(), userCreateForm.getPassword1(),userCreateForm.getUserRole());

        return "redirect:/";
    }
    @GetMapping("/login")
    public String login() {
        return "login_form";
    }

    @GetMapping("/admin")
    public String admin(){
        return "admin";
    }

    @GetMapping("/sessionuser")
    public String sessionUser(){
        return "session_user";
    }

}