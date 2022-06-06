package project.moim.controller;
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

    @ResponseBody
    @GetMapping("/kakao")
    public String kakaoCallback(@RequestParam String code, HttpSession session) {

        //System.out.println(code);
        String access_Token = memberService.getKaKaoAccessToken(code);
        memberService.createKakaoUser(access_Token);

        HashMap<String, Object> userInfo = memberService.getUserInfo(access_Token);
        System.out.println("login Controller : " + userInfo);
        if (userInfo.get("email") != null) {
            session.setAttribute("userId", userInfo.get("email"));
            session.setAttribute("access_Token", access_Token);
        }
        return "index";
    }


}