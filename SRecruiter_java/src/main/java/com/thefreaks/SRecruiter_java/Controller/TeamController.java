package com.thefreaks.SRecruiter_java.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TeamController {
    @RequestMapping("/team")
    public String showTeam(){
        return "team";
    }
}
