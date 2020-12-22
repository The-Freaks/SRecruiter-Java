package com.thefreaks.SRecruiter_java.Controller;

import org.springframework.stereotype.Controller;

import java.util.List;

import com.thefreaks.SRecruiter_java.Model.Infirmary;
import com.thefreaks.SRecruiter_java.Service.Infirmary_Service;

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
public class InfirmaryController {
    // Display the infirmary student list
   @Autowired
   private Infirmary_Service infirmary_service;
   @RequestMapping("/infirmary")
   public String getInfirmaryPage(Model model){
       return findInfirmaryPage(1, model);
   }

   // Get Infirmary Student By Id
   @GetMapping("/getOneInfirmaryStudent")
   @ResponseBody
   public Infirmary getOne(long id){
       Infirmary infirmary = infirmary_service.getInfirmaryStudentById(id);
       return infirmary;
   }

   // Save Infirmary Student
   @PostMapping("/saveInfirmaryStudent")
   public String saveInfirmaryStudent(@ModelAttribute("Infirmary_Student") Infirmary infirmary){
       infirmary_service.saveInfirmaryStudent(infirmary);
       return "redirect:/infirmary";
   }

   // Update Software Engineering Student
   @RequestMapping(value = "/updateInfirmaryStudent", method = {RequestMethod.PUT, RequestMethod.GET})
   public String showFormForUpdate_Infirmary(Infirmary infirmary){
       infirmary_service.saveInfirmaryStudent(infirmary);
       return "redirect:/infirmary";
   }

   // Delete Infirmary Student
   @GetMapping("/deleteStudent_Infirmary/{id}")
   public String deleteStudent_Infirmary(@PathVariable (value = "id") long id){
       this.infirmary_service.deleteInfirmaryStudentById(id);
       return "redirect:/infirmary";
   }

   @GetMapping("/infirmary/{pageNumInfirmary}")
   public String findInfirmaryPage(@PathVariable (value = "pageNumInfirmary") int pageNumInfirmary ,Model model){
       int pageSizeInfirmary = 5;

       Page<Infirmary> pageInfirmary = infirmary_service.findPaginatedInfirmaryPage(pageNumInfirmary, pageSizeInfirmary);
       List<Infirmary> listInfirmaryStudents = infirmary_service.getAllInfirmaryStudents();
       model.addAttribute("currentInfirmaryPage", pageNumInfirmary);
       model.addAttribute("totalInfirmaryPages", pageInfirmary.getTotalPages());
       model.addAttribute("Infirmary_StudentList", listInfirmaryStudents);

       return "infirmary";
   }
}
