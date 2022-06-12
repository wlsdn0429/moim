package project.moim.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import project.moim.model.Message;

import javax.validation.Valid;

@Controller
public class HomeController {

    @RequestMapping(value="/")
    public String index() {
        return "index";
    }
/*
    @RequestMapping(value="/login")
    public String login() {
        return "login";
    }
*/
    @RequestMapping(value="/alert")
    public String alert(Model model){
        model.addAttribute("data", new Message("로그아웃 완료","/"));
        //System.out.println("alert ok !!!!!!!!!!!!!!!!!!!!!");
        return "message";
    };
}