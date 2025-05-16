package com.Chese.KACM_Recommendation.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class WelcomeController {
    @GetMapping("/welcome")
    public String showWelcomePage(){
        return "welcome";
    }
}
