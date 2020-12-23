package com.thefreaks.SRecruiter_java.Controller;

import org.springframework.stereotype.Controller;

import java.util.List;

import com.thefreaks.SRecruiter_java.Model.GraphicDesign;
import com.thefreaks.SRecruiter_java.Service.GD_Service;

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
public class GDController {
    // Display the graphic design student list
   @Autowired
   private GD_Service gd_service;
   @RequestMapping("/graphicDesign")
   public String getGDPage(Model model){
       return findGDPage(1, model);
   }

   // Get Graphic Design Student By Id
   @GetMapping("/getOneGDStudent")
   @ResponseBody
   public GraphicDesign getOne(long id){
       GraphicDesign graphicDesign = gd_service.getGDStudentById(id);
       return graphicDesign;
   }

   // Save Graphic Design Student
   @PostMapping("/saveGDStudent")
   public String saveGDStudent(@ModelAttribute("GD_Student") GraphicDesign graphicDesign){
       gd_service.saveGDStudent(graphicDesign);
       return "redirect:/graphicDesign";
   }

   // Update Graphic Design Student
   @RequestMapping(value = "/updateGDStudent", method = {RequestMethod.PUT, RequestMethod.GET})
   public String showFormForUpdate_GD(GraphicDesign graphicDesign){
       gd_service.saveGDStudent(graphicDesign);
       return "redirect:/graphicDesign";
   }

   // Delete Graphic Design Student
   @GetMapping("/deleteStudent_GD/{id}")
   public String deleteStudent_GD(@PathVariable (value = "id") long id){
       this.gd_service.deleteGDStudentById(id);
       return "redirect:/graphicDesign";
   }

   @GetMapping("/graphicDesign/{pageNumGD}")
   public String findGDPage(@PathVariable (value = "pageNumGD") int pageNumGD ,Model model){
       int pageSizeGD = 5;

       Page<GraphicDesign> pageGD = gd_service.findPaginatedGDPage(pageNumGD, pageSizeGD);
       List<GraphicDesign> listGDStudents = pageGD.getContent();
       model.addAttribute("currentGDPage", pageNumGD);
       model.addAttribute("totalGDPages", pageGD.getTotalPages());
       model.addAttribute("totalGDItems", pageGD.getTotalElements());
       model.addAttribute("GD_StudentList", listGDStudents);

       return "graphicDesign";
   }
}
