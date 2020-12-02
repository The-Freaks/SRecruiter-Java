package com.thefreaks.SRecruiter_java.Controller;

import org.springframework.stereotype.Controller;

import com.thefreaks.SRecruiter_java.Model.BusinessManagement;
import com.thefreaks.SRecruiter_java.Service.BM_Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BMController {
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
       return "admin/new_BM_student";
   }
   // Save Business Management Student
   @PostMapping("/saveBMStudent")
   public String saveBMStudent(@ModelAttribute("BM_Student") BusinessManagement businessManagement){
       bm_service.saveBMStudent(businessManagement);
       return "redirect:/businessManagement";
   }
   // Update Business Management Student
   @GetMapping("/showFormForUpdate_BM/{id}")
   public String showFormForUpdate_BM(@PathVariable (value = "id") long id, Model model){
       BusinessManagement businessManagement = bm_service.getBMStudentById(id);
       model.addAttribute("BM_Student", businessManagement);
       return "admin/new_BM_student";
   }
   // Delete Business Management Student
   @GetMapping("/deleteStudent_BM/{id}")
   public String deleteStudent_BM(@PathVariable (value = "id") long id){
       this.bm_service.deleteBMStudentById(id);
       return "redirect:/businessManagement";
   }
}
