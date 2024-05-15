package pinz120.IcePalace.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/Layout")
    public String home(){
        return "Layout";
    }
}
