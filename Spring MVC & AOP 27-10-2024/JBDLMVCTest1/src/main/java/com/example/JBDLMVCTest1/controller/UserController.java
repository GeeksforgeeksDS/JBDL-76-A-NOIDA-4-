package com.example.JBDLMVCTest1.controller;

import com.example.JBDLMVCTest1.Model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

//    @GetMapping("/hello")
//    public String hello() {
//        return "home";
//    }

    @GetMapping("/userForm")
    public String showUserForm(Model model) {
        model.addAttribute("user", new User());
        return "userForm";
    }

    @PostMapping("/submitForm")
    public String submitForm(@ModelAttribute User user, Model model) {
        model.addAttribute("user", user);
        return "result";
    }




}
