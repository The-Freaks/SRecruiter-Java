package com.thefreaks.SRecruiter_java.Controller;

import org.springframework.stereotype.Controller;

import java.util.List;

import com.thefreaks.SRecruiter_java.Model.BusinessManagement;
import com.thefreaks.SRecruiter_java.Service.BM_Service;

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
public class BMController {
    // Display the business management student list
   @Autowired
   private BM_Service bm_service;
   @RequestMapping("/businessManagement")
   public String getBMPage(Model model){
       return findBMPage(1, model);
   }

   // Add new business management student
   @RequestMapping("/addNewBMStudentForm")
   public String addNewBMStudent(Model model){
       BusinessManagement businessManagement = new BusinessManagement();
       model.addAttribute("BM_Student", businessManagement);
       return "admin/new_BM_student";
   }

   // Get Business Management Student By Id
   @GetMapping("/getOneBMStudent")
   @ResponseBody
   public BusinessManagement getOne(long id){
       BusinessManagement businessManagement = bm_service.getBMStudentById(id);
       return businessManagement;
   }

   // Save Business Management Student
   @PostMapping("/saveBMStudent")
   public String saveBMStudent(@ModelAttribute("BM_Student") BusinessManagement businessManagement){
       bm_service.saveBMStudent(businessManagement);
       return "redirect:/businessManagement";
   }

   // Update Business Management Student
   @RequestMapping(value = "/updateBMStudent", method = {RequestMethod.PUT, RequestMethod.GET})
   public String showFormForUpdate_BM(BusinessManagement businessManagement){
       bm_service.saveBMStudent(businessManagement);
       return "redirect:/businessManagement";
   }

   // Delete Business Management Student
   @GetMapping("/deleteStudent_BM/{id}")
   public String deleteStudent_BM(@PathVariable (value = "id") long id){
       this.bm_service.deleteBMStudentById(id);
       return "redirect:/businessManagement";
   }

   @GetMapping("/businessManagement/{pageNumBM}")
   public String findBMPage(@PathVariable (value = "pageNumBM") int pageNumBM ,Model model){
       int pageSizeBM = 5;

       Page<BusinessManagement> pageBM = bm_service.findPaginatedBMPage(pageNumBM, pageSizeBM);
       List<BusinessManagement> listBMStudents = pageBM.getContent();
       model.addAttribute("currentBMPage", pageNumBM);
       model.addAttribute("totalBMPages", pageBM.getTotalPages());
       model.addAttribute("totalBMItems", pageBM.getTotalElements());
       model.addAttribute("BM_StudentList", listBMStudents);

       return "businessManagement";
   }
}
