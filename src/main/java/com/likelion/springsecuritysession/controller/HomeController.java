package com.likelion.springsecuritysession.controller;

import com.likelion.springsecuritysession.domain.UserCreateForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("")
    public String signup(UserCreateForm userCreateForm) {
        return "index";
    }
}
