package cn.gdou.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/websocket")
public class SpringmvcController {
    @RequestMapping(value = "/welcome")
    public String welcome(Model model){
        model.addAttribute("welcome","Welcome to My Simple Chat!");
        return "welcome";
    }

    @RequestMapping(value = "/mes")
    public String message(){
        return "message";
    }

}
