package com.thefreaks.SRecruiter_java.Controller;

import org.springframework.stereotype.Controller;

import java.util.List;

import com.thefreaks.SRecruiter_java.Model.English;
import com.thefreaks.SRecruiter_java.Service.English_Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class EnglishController {
    // Display the english student list
   @Autowired
   private English_Service english_service;
   @RequestMapping("/english")
   public String getEnglishPage(Model model){
       return findEnglishPage(1, model);
   }

   // Get English Student By Id
   @GetMapping("/getOneEnglishStudent")
   @ResponseBody
   public English getOne(long id){
       English english = english_service.getEnglishStudentById(id);
       return english;
   }

   // Save English Student
   @PostMapping("/saveEnglishStudent")
   public String saveEnglishStudent(@ModelAttribute("English_Student") English english){
       english_service.saveEnglishStudent(english);
       return "redirect:/english";
   }

   // Update English Student
   @RequestMapping(value = "/updateEnglishStudent", method = {RequestMethod.PUT, RequestMethod.GET})
   public String showFormForUpdate_English(English english){
       english_service.saveEnglishStudent(english);
       return "redirect:/english";
   }

   // Delete English Student
   @GetMapping("/deleteStudent_English/{id}")
   public String deleteStudent_English(@PathVariable (value = "id") long id){
       this.english_service.deleteEnglishStudentById(id);
       return "redirect:/english";
   }

   @GetMapping("/english/{pageNumEnglish}")
   public String findEnglishPage(@PathVariable (value = "pageNumEnglish") int pageNumEnglish ,Model model){
       int pageSizeEnglish = 5;

       Page<English> pageEnglish = english_service.findPaginatedEnglishPage(pageNumEnglish, pageSizeEnglish);
       List<English> listEnglishStudents = pageEnglish.getContent();
       model.addAttribute("currentEnglishPage", pageNumEnglish);
       model.addAttribute("totalEnglishPages", pageEnglish.getTotalPages());
       model.addAttribute("totalEnglishItems", pageEnglish.getTotalElements());
       model.addAttribute("English_StudentList", listEnglishStudents);

       return "english";
   }
}
