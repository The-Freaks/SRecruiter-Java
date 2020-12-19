package com.thefreaks.SRecruiter_java.Controller;

import com.thefreaks.SRecruiter_java.Model.BusinessManagement;
import com.thefreaks.SRecruiter_java.Model.English;
import com.thefreaks.SRecruiter_java.Model.GraphicDesign;
import com.thefreaks.SRecruiter_java.Model.Infirmary;
import com.thefreaks.SRecruiter_java.Model.SoftwareEngineering;
import com.thefreaks.SRecruiter_java.Model.User;
import com.thefreaks.SRecruiter_java.Service.BM_Service;
import com.thefreaks.SRecruiter_java.Service.English_Service;
import com.thefreaks.SRecruiter_java.Service.GD_Service;
import com.thefreaks.SRecruiter_java.Service.Infirmary_Service;
import com.thefreaks.SRecruiter_java.Service.SE_Service;
import org.springframework.ui.Model;
import com.thefreaks.SRecruiter_java.Service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    // Display the index.html file
    @Autowired
    private UserService userService;

    @Autowired
    private SE_Service se_service;

    @Autowired
    private GD_Service gd_service;

    @Autowired
    private BM_Service bm_Service;

    @Autowired
    private Infirmary_Service infirmary_service;

    @Autowired
    private English_Service english_service;

    @GetMapping("/")
    public String getHomePage(Model model){

        Page<User> totalUsers = userService.findPaginatedUserPage(1, 1);
        Page<SoftwareEngineering> totalSEStudents = se_service.findPaginatedSEPage(1, 1);
        Page<GraphicDesign> totalGDStudents = gd_service.findPaginatedGDPage(1, 1);
        Page<BusinessManagement> totalBMStudents = bm_Service.findPaginatedBMPage(1, 1);
        Page<English> totalEnglishStudents = english_service.findPaginatedEnglishPage(1, 1);
        Page<Infirmary> totalInfirmaryStudents = infirmary_service.findPaginatedInfirmaryPage(1, 1);

        long countAllStudents = totalSEStudents.getTotalElements() + 
        totalGDStudents.getTotalElements() + totalBMStudents.getTotalElements() + 
        totalEnglishStudents.getTotalElements() + totalInfirmaryStudents.getTotalElements();
        
        model.addAttribute("Count_All_Students", countAllStudents);

        model.addAttribute("Total_Users", totalUsers.getTotalElements());
        model.addAttribute("totalSEItems", totalSEStudents.getTotalElements());
        model.addAttribute("totalGDItems", totalGDStudents.getTotalElements());
        model.addAttribute("totalBMItems", totalBMStudents.getTotalElements());
        model.addAttribute("totalEnglishItems", totalEnglishStudents.getTotalElements());
        model.addAttribute("totalInfirmaryItems", totalInfirmaryStudents.getTotalElements());
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
