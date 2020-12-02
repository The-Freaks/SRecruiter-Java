package com.thefreaks.SRecruiter_java.Controller;

import org.springframework.stereotype.Controller;

import com.thefreaks.SRecruiter_java.Model.English;
import com.thefreaks.SRecruiter_java.Service.English_Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class EnglishController {
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
       return "admin/new_English_student";
   }
   // Save English Student
   @PostMapping("/saveEnglishStudent")
   public String saveEnglishStudent(@ModelAttribute("English_Student") English english){
       english_service.saveEnglishStudent(english);
       return "redirect:/english";
   }
   // Update English Student
   @GetMapping("/showFormForUpdate_English/{id}")
   public String showFormForUpdate_English(@PathVariable (value = "id") long id, Model model){
       English english = english_service.getEnglishStudentById(id);
       model.addAttribute("English_Student", english);
       return "admin/new_English_student";
   }
   // Delete English Student
   @GetMapping("/deleteStudent_English/{id}")
   public String deleteStudent_English(@PathVariable (value = "id") long id){
       this.english_service.deleteEnglishStudentById(id);
       return "redirect:/english";
   }
}