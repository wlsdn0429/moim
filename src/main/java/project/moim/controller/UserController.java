package project.moim.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import project.moim.domain.User;
import project.moim.dto.SignupRequestDto;
import project.moim.service.KaKaoOAuth2;
import project.moim.service.UserService;
import project.moim.service.MemberService;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private MemberService memberService;
    @Autowired
    private KaKaoOAuth2 KaKaoOAuth2;

    // 회원 로그인 페이지
    @GetMapping("/user/login")
    public String login() {
        return "login";
    }

    @GetMapping("/user/login/error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login";
    }


    @PostMapping("/user/signup")
    public String registerUser(SignupRequestDto requestDto) {
        userService.registerUser(requestDto);
        return "redirect:/";
    }

//    @RequestMapping("/user/kakao/callback")
//    public String kakaoLogin(@RequestParam String code, HttpSession session, Model model) {
//        //System.out.println(code);
//        String access_Token = memberService.getKaKaoAccessToken(code);
//        memberService.createKakaoUser(access_Token);
//
//        HashMap<String, Object> userInfo = memberService.kakaogetUserInfo(access_Token);
//        userService.kakaoLogin(code);
//        System.out.println("login Controller : " + userInfo);
//        if (userInfo.get("email") != null) {
//            session.setAttribute("userId", userInfo.get("email"));
//            session.setAttribute("access_Token", access_Token);
//            //model.addAttribute("email",session.getAttribute("userId"));
//            //model.addAttribute("access_Token",session.getAttribute("access_Token"));
//            model.addAttribute("nickname", userInfo.get("nickname"));
//        }
//
//        return "index";
//    }
//    @RequestMapping(value="/logout")
//    public String logout(HttpSession session) {
//        String access_Token = (String)session.getAttribute("access_Token");
//
//        if(access_Token != null && !"".equals(access_Token)){
//            KaKaoOAuth2.kakaoLogout(access_Token);
//            session.removeAttribute("access_Token");
//            session.removeAttribute("userId");
//        }else{
//            System.out.println("access_Token is null");
//            //return "redirect:/";
//        }
//        //return "login";
//        //return "redirect:/";
//        return "redirect:/alert";
//    }
}
