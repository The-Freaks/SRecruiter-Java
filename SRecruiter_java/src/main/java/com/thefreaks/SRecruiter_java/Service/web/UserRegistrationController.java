package com.thefreaks.SRecruiter_java.Service.web;

import com.thefreaks.SRecruiter_java.Service.UserService;
import com.thefreaks.SRecruiter_java.Service.web.web_dto.UserRegistrationDto;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {
    private UserService userService;

    public UserRegistrationController(UserService userService){
        super();
        this.userService = userService;
    }

    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto(){
        return new UserRegistrationDto();
    }

    @GetMapping
    public String showRegistrationForm(){
        return "/admin/registration";
    }

    @PostMapping
    public String registereUserAccount(@ModelAttribute("user") UserRegistrationDto registrationDto){
        userService.saveUser(registrationDto);
        return "redirect:/registration?success";
    }
}
