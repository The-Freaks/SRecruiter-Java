package com.thefreaks.SRecruiter_java.Controller;

import com.thefreaks.SRecruiter_java.Repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    // Display the index.html file
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String getHomePage(Model model){
        int max = userRepository.maxUser();
        int countStudents= userRepository.maxUser() + userRepository.maxUser();
        model.addAttribute("User_Service", countStudents);
        return "index";
    }

    @GetMapping("/login")
    public String login(Model model) {
        if (isAuthenticated()) {
            return "redirect:/";
        }
        return "login";
    }

    // Count the users
    
    
    // @GetMapping("/test")
    // public void UserCount(Model model){
    //     int max = userRepository.maxUser();
    //     model.addAttribute("User_Service", max);
    //     System.out.println("test" + max);
        
    // }

    private boolean isAuthenticated() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || AnonymousAuthenticationToken.class.
          isAssignableFrom(authentication.getClass())) {
            return false;
        }
        return authentication.isAuthenticated();
    }
}
