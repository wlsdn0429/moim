package project.moim.controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.moim.service.MemberService;
import java.io.IOException;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping(value="/member/*")
public class MemberController {
    @Autowired
    MemberService memberService;

    //@ResponseBody
    //@GetMapping("/kakao")
    @RequestMapping(value="/kakao")
    public String login(@RequestParam String code, HttpSession session, Model model) {

        //System.out.println(code);
        String access_Token = memberService.getKaKaoAccessToken(code);
        memberService.createKakaoUser(access_Token);

        HashMap<String, Object> userInfo = memberService.kakaogetUserInfo(access_Token);
        System.out.println("login Controller : " + userInfo);
        if (userInfo.get("email") != null) {
            session.setAttribute("userId", userInfo.get("email"));
            session.setAttribute("access_Token", access_Token);
            //model.addAttribute("email",session.getAttribute("userId"));
            //model.addAttribute("access_Token",session.getAttribute("access_Token"));
            model.addAttribute("nickname", userInfo.get("nickname"));
        }

        return "index";
    }
    @RequestMapping(value="/logout")
    public String logout(HttpSession session) {
        String access_Token = (String)session.getAttribute("access_Token");

        if(access_Token != null && !"".equals(access_Token)){
            memberService.kakaoLogout(access_Token);
            session.removeAttribute("access_Token");
            session.removeAttribute("userId");
        }else{
            System.out.println("access_Token is null");
            //return "redirect:/";
        }
        //return "login";
        //return "redirect:/";
        return "redirect:/alert";
    }


}