package project.moim.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import project.moim.domain.UserDetailsImpl;
import project.moim.model.Message;
import project.moim.service.UserService;

@Controller
public class HomeController {
    @Autowired
    UserService userService;
    @GetMapping("/")
    public String home(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        if(userDetails != null){
            model.addAttribute("username", userDetails.getUsername());
        }
        return "index";
    }

    @RequestMapping(value="/alert")
    public String alert(Model model){
        model.addAttribute("data", new Message("로그아웃 완료","/"));
        //System.out.println("alert ok !!!!!!!!!!!!!!!!!!!!!");
        return "message";
    }


}