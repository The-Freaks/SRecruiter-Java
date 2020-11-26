package com.thefreaks.SRecruiter_java.Controller;

import com.thefreaks.SRecruiter_java.Model.BusinessManagement;
import com.thefreaks.SRecruiter_java.Model.English;
import com.thefreaks.SRecruiter_java.Model.GraphicDesign;
import com.thefreaks.SRecruiter_java.Model.Infirmary;
import com.thefreaks.SRecruiter_java.Model.SoftwareEngineering;
import com.thefreaks.SRecruiter_java.Service.BM_Service;
import com.thefreaks.SRecruiter_java.Service.English_Service;
import com.thefreaks.SRecruiter_java.Service.GD_Service;
import com.thefreaks.SRecruiter_java.Service.Infirmary_Service;
import com.thefreaks.SRecruiter_java.Service.SE_Service;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
   // Add new software engineering student
   @RequestMapping("/addNewSEStudentForm")
   public String addNewSEStudent(Model model){
       SoftwareEngineering softwareEngineering = new SoftwareEngineering();
       model.addAttribute("SE_Student", softwareEngineering);
       return "new_SE_student";
   }
   // Save Software Engineering Student
   @PostMapping("/saveSEStudent")
   public String saveSEStudent(@ModelAttribute("SE_Student") SoftwareEngineering softwareEngineering){
       se_service.saveSEStudent(softwareEngineering);
       return "redirect:/";
   }


   // Display the graphic design student list
   @Autowired
   private GD_Service gd_service;
   @RequestMapping("/graphicDesign")
   public String getGDPage(Model model){
       model.addAttribute("GD_StudentList", gd_service.getAllGDStudents());
       return "graphicDesign";
   }
   // Add new graphic design student
   @RequestMapping("/addNewGDStudentForm")
   public String addNewGDStudent(Model model){
       GraphicDesign graphicDesign = new GraphicDesign();
       model.addAttribute("GD_Student", graphicDesign);
       return "new_GD_student";
   }
   // Save Graphic Design Student
   @PostMapping("/saveGDStudent")
   public String saveGDStudent(@ModelAttribute("GD_Student") GraphicDesign graphicDesign){
       gd_service.saveGDStudent(graphicDesign);
       return "redirect:/";
   }


   // Display the business management student list
   @Autowired
   private BM_Service bm_service;
   @RequestMapping("/businessManagement")
   public String getBMPage(Model model){
       model.addAttribute("BM_StudentList", bm_service.getAllBMStudents());
       return "businessManagement";
   }
   // Add new business management student
   @RequestMapping("/addNewBMStudentForm")
   public String addNewBMStudent(Model model){
       BusinessManagement businessManagement = new BusinessManagement();
       model.addAttribute("BM_Student", businessManagement);
       return "new_BM_student";
   }
   // Save Business Management Student
   @PostMapping("/saveBMStudent")
   public String saveBMStudent(@ModelAttribute("BM_Student") BusinessManagement businessManagement){
       bm_service.saveBMStudent(businessManagement);
       return "redirect:/";
   }


   // Display the english student list
   @Autowired
   private English_Service english_service;
   @RequestMapping("/english")
   public String getEnglishPage(Model model){
       model.addAttribute("English_StudentList", english_service.getAllEnglishStudents());
       return "english";
   }
   // Add new english student
   @RequestMapping("/addNewEnglishStudentForm")
   public String addNewEnglishStudent(Model model){
       English english = new English();
       model.addAttribute("English_Student", english);
       return "new_English_student";
   }
   // Save English Student
   @PostMapping("/saveEnglishStudent")
   public String saveEnglishStudent(@ModelAttribute("English_Student") English english){
       english_service.saveEnglishStudent(english);
       return "redirect:/";
   }


   // Display the infirmary student list
   @Autowired
   private Infirmary_Service infirmary_service;
   @RequestMapping("/infirmary")
   public String getInfirmaryPage(Model model){
       model.addAttribute("Infirmary_StudentList", infirmary_service.getAllInfirmaryStudents());
       return "infirmary";
   }
   // Add new infirmary student
   @RequestMapping("/addNewInfirmaryStudentForm")
   public String addNewInfirmaryStudent(Model model){
       Infirmary infirmary = new Infirmary();
       model.addAttribute("Infirmary_Student", infirmary);
       return "new_Infirmary_student";
   }
   // Save Infirmary Student
   @PostMapping("/saveInfirmaryStudent")
   public String saveInfirmaryStudent(@ModelAttribute("Infirmary_Student") Infirmary infirmary){
       infirmary_service.saveInfirmaryStudent(infirmary);
       return "redirect:/";
   }
}
