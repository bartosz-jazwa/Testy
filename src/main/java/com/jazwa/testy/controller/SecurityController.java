package com.jazwa.testy.controller;

import com.jazwa.testy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@Controller
public class SecurityController {


    /*@RequestMapping(value = "/user", method = RequestMethod.GET)
    @ResponseBody
    public String currentUserName(Model model,Principal principal) {
        model.addAttribute("username",principal.getName());
        return "user";
    }*/

    @GetMapping("/user")
    String user(Model model, Authentication authentication){


        model.addAttribute("username",authentication.getAuthorities());
        return "user";
    }

    @GetMapping("/admin")
    String admin(Model model,Principal principal){
        model.addAttribute("admin",principal.getName());
        return "admin";
    }
}
