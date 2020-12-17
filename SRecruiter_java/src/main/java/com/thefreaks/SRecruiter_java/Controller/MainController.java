package com.thefreaks.SRecruiter_java.Controller;

// import com.thefreaks.SRecruiter_java.Repository.UserRepository;
import com.thefreaks.SRecruiter_java.Service.StudentServiceImpl;

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
    private StudentServiceImpl studentServiceImpl;

    @GetMapping("/")
    public String getHomePage(Model model){
        int totalUsers = studentServiceImpl.getMaxUserCount();
        int totalSEStudents = studentServiceImpl.getMaxSEStudents();
        int totalGDStudents = studentServiceImpl.getMaxGDStudents();
        int totalBMStudents = studentServiceImpl.getMaxBMStudents();
        int totalEnglishStudents = studentServiceImpl.getMaxEnglishStudents();
        int totalInfirmaryStudents = studentServiceImpl.getMaxInfirmaryStudents();

        int countAllStudents = totalSEStudents + totalGDStudents + totalBMStudents + totalEnglishStudents + totalInfirmaryStudents;
        model.addAttribute("Count_All_Students", countAllStudents);

        model.addAttribute("Total_Users", totalUsers);
        model.addAttribute("Total_SE_Students", totalSEStudents);
        model.addAttribute("Total_GD_Students", totalGDStudents);
        model.addAttribute("Total_BM_Students", totalBMStudents);
        model.addAttribute("Total_English_Students", totalEnglishStudents);
        model.addAttribute("Total_Infirmary_Students", totalInfirmaryStudents);
        return "index";
    }

    @GetMapping("/login")
    public String login(Model model) {
        if (isAuthenticated()) {
            return "redirect:/";
        }
        return "login";
    }

    private boolean isAuthenticated() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || AnonymousAuthenticationToken.class.
          isAssignableFrom(authentication.getClass())) {
            return false;
        }
        return authentication.isAuthenticated();
    }
}
