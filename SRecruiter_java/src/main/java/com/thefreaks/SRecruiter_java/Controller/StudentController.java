package com.thefreaks.SRecruiter_java.Controller;

import com.thefreaks.SRecruiter_java.Service.BM_Service;
import com.thefreaks.SRecruiter_java.Service.English_Service;
import com.thefreaks.SRecruiter_java.Service.GD_Service;
import com.thefreaks.SRecruiter_java.Service.Infirmary_Service;
import com.thefreaks.SRecruiter_java.Service.SE_Service;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {

    // Display the index.html file
    @GetMapping("/")
    public String getHomePage(){
        return "index";
    }

   // Display the software engineering students list
   @Autowired
   private SE_Service se_service;
   @RequestMapping("/softwareEngineering")
   public String getSEPage(Model model){
       model.addAttribute("SE_StudentList", se_service.getAllSEStudents());
       return "softwareEngineering";
   }

   // Display the graphic design student list
   @Autowired
   private GD_Service gd_service;
   @RequestMapping("/graphicDesign")
   public String getGDPage(Model model){
       model.addAttribute("GD_StudentList", gd_service.getAllGDStudents());
       return "graphicDesign";
   }

   // Display the business management student list
   @Autowired
   private BM_Service bm_service;
   @RequestMapping("/businessManagement")
   public String getBMPage(Model model){
       model.addAttribute("BM_StudentList", bm_service.getAllBMStudents());
       return "businessManagement";
   }

   // Display the english student list
   @Autowired
   private English_Service english_service;
   @RequestMapping("/english")
   public String getEnglishPage(Model model){
       model.addAttribute("English_StudentList", english_service.getAllEnglishStudents());
       return "english";
   }

   // Display the infirmary student list
   @Autowired
   private Infirmary_Service infirmary_service;
   @RequestMapping("/infirmary")
   public String getInfirmaryPage(Model model){
       model.addAttribute("Infirmary_StudentList", infirmary_service.getAllInfirmaryStudents());
       return "infirmary";
   }
}
