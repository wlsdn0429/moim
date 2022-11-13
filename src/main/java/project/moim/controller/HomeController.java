package project.moim.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import project.moim.domain.Moim;
import project.moim.domain.MoimJoin;
import project.moim.domain.User;
import project.moim.domain.UserDetailsImpl;
import project.moim.model.Message;
import project.moim.service.MoimJoinService;
import project.moim.service.MoimService;
import project.moim.service.UserService;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
public class HomeController {
    @Autowired
    UserService userService;
    @Autowired
    MoimJoinService moimJoinService;
    @Autowired
    MoimService moimService;
    @GetMapping("/")
    public String home(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        if(userDetails != null){
            model.addAttribute("username", userDetails.getUsername());
        }
        return "index";
    }
    @RequestMapping(value = "/member/info")
    public String memInfo(HttpSession session, Model model){
        Long id =  (Long) session.getAttribute("Id");
        int i = 0;
        System.out.println("id : " + id);
        User userInfo = userService.getUserInfo(id);
        ArrayList<MoimJoin> moimJoins = moimJoinService.getGroups(id);
        ArrayList<Moim> moim = new ArrayList<>();
        for (MoimJoin moims: moimJoins
        ) {
            i++;
            moim.add(moimService.getGroupMoim((long) moims.getMoimId()));
        }
        if(i != 0)
            model.addAttribute("moims", moim);
        else
            model.addAttribute("moims",null);
        model.addAttribute("user",userInfo);
        return "membinfo";
    }

    @RequestMapping(value="/alert")
    public String alert(Model model){
        model.addAttribute("data", new Message("로그아웃 완료","/"));
        //System.out.println("alert ok !!!!!!!!!!!!!!!!!!!!!");
        return "message";
    }


}