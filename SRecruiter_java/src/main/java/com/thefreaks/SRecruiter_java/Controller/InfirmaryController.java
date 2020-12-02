package com.thefreaks.SRecruiter_java.Controller;

import org.springframework.stereotype.Controller;

import com.thefreaks.SRecruiter_java.Model.Infirmary;
import com.thefreaks.SRecruiter_java.Service.Infirmary_Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InfirmaryController {
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
       return "admin/new_Infirmary_student";
   }
   // Save Infirmary Student
   @PostMapping("/saveInfirmaryStudent")
   public String saveInfirmaryStudent(@ModelAttribute("Infirmary_Student") Infirmary infirmary){
       infirmary_service.saveInfirmaryStudent(infirmary);
       return "redirect:/infirmary";
   }
   // Update Infirmary Student
   @GetMapping("/showFormForUpdate_Infirmary/{id}")
   public String showFormForUpdate_Infirmary(@PathVariable (value = "id") long id, Model model){
       Infirmary infirmary = infirmary_service.getInfirmaryStudentById(id);
       model.addAttribute("Infirmary_Student", infirmary);
       return "admin/new_Infirmary_student";
   }
   // Delete Infirmary Student
   @GetMapping("/deleteStudent_Infirmary/{id}")
   public String deleteStudent_Infirmary(@PathVariable (value = "id") long id){
       this.infirmary_service.deleteInfirmaryStudentById(id);
       return "redirect:/infirmary";
   }
}
