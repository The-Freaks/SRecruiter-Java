package com.thefreaks.SRecruiter_java.Controller;

// import com.thefreaks.SRecruiter_java.Service.BM_Service;
// import com.thefreaks.SRecruiter_java.Service.English_Service;
// import com.thefreaks.SRecruiter_java.Service.GD_Service;
// import com.thefreaks.SRecruiter_java.Service.Infirmary_Service;
// import com.thefreaks.SRecruiter_java.Service.SE_Service;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentController {

    // Display the index.html file
    @GetMapping("/")
    public String getHomePage(){
        return "index";
    }

    /*// Display the software engineering students list
    @Autowired
    private SE_Service se_service;
    @GetMapping("/")
    public String getSEPage(Model model){
        model.addAttribute("SE_StudentList", se_service);
        return "softwareEngineering";
    }

    // Display the graphic design student list
    @Autowired
    private GD_Service gd_service;
    @GetMapping("/")
    public String getGDPage(Model model){
        model.addAttribute("GD_StudentList", gd_service);
        return "graphicDesign";
    }

    // Display the business management student list
    @Autowired
    private BM_Service bm_service;
    @GetMapping("/")
    public String getBMPage(Model model){
        model.addAttribute("BM_StudentList", bm_service);
        return "businessManagement";
    }

    // Display the english student list
    @Autowired
    private English_Service english_service;
    @GetMapping("/")
    public String getEnglishPage(Model model){
        model.addAttribute("English_StudentList", english_service);
        return "english";
    }

    // Display the infirmary student list
    @Autowired
    private Infirmary_Service infirmary_service;
    @GetMapping("/")
    public String getInfirmaryPage(Model model){
        model.addAttribute("Infirmary_StudentList", infirmary_service);
        return "infirmary";
    }*/
}
