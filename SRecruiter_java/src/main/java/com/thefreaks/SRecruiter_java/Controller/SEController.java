package com.thefreaks.SRecruiter_java.Controller;

import com.thefreaks.SRecruiter_java.Model.SoftwareEngineering;
import com.thefreaks.SRecruiter_java.Service.SE_Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SEController {
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
       return "admin/new_SE_student";
   }
   // Save Software Engineering Student
   @PostMapping("/saveSEStudent")
   public String saveSEStudent(@ModelAttribute("SE_Student") SoftwareEngineering softwareEngineering){
       se_service.saveSEStudent(softwareEngineering);
       return "redirect:/softwareEngineering";
   }
   // Update Software Engineering Student
   @GetMapping("/showFormForUpdate_SE/{id}")
   public String showFormForUpdate_SE(@PathVariable (value = "id") long id, Model model){
       SoftwareEngineering softwareEngineering = se_service.getSEStudentById(id);
       model.addAttribute("SE_Student", softwareEngineering);
       return "admin/new_SE_student";
   }
   // Delete Software Engineering Student
   @GetMapping("/deleteStudent_SE/{id}")
   public String deleteStudent_SE(@PathVariable (value = "id") long id){
       this.se_service.deleteSEStudentById(id);
       return "redirect:/softwareEngineering";
   }
}
