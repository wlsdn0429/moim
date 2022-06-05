package project.moim.controller;
import org.springframework.web.bind.annotation.*;
import project.moim.service.MemberService;
import java.io.IOException;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


@Controller
@RequestMapping(value="/member/*")
public class MemberController {
    @Autowired
    MemberService memberService;

    @ResponseBody
    @GetMapping("/kakao")
    public void  kakaoCallback(@RequestParam String code) {

       //System.out.println(code);
        String access_Token = memberService.getKaKaoAccessToken(code);
        memberService.createKakaoUser(access_Token);
    }

}