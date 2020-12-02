package com.thefreaks.SRecruiter_java.Controller;

import org.springframework.stereotype.Controller;

import com.thefreaks.SRecruiter_java.Model.GraphicDesign;
import com.thefreaks.SRecruiter_java.Service.GD_Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GDController {
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
       return "admin/new_GD_student";
   }
   // Save Graphic Design Student
   @PostMapping("/saveGDStudent")
   public String saveGDStudent(@ModelAttribute("GD_Student") GraphicDesign graphicDesign){
       gd_service.saveGDStudent(graphicDesign);
       return "redirect:/graphicDesign";
   }
   // Update Graphic Design Student
   @GetMapping("/showFormForUpdate_GD/{id}")
   public String showFormForUpdate_GD(@PathVariable (value = "id") long id, Model model){
       GraphicDesign graphicDesign = gd_service.getGDStudentById(id);
       model.addAttribute("GD_Student", graphicDesign);
       return "admin/new_GD_student";
   }
   // Delete Graphic Design Student
   @GetMapping("/deleteStudent_GD/{id}")
   public String deleteStudent_GD(@PathVariable (value = "id") long id){
       this.gd_service.deleteGDStudentById(id);
       return "redirect:/graphicDesign";
   }
}
