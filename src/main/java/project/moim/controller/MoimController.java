package project.moim.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.moim.domain.posts.Moim;
import project.moim.service.MoimService;

@Controller
public class MoimController {
    @Autowired
    private final MoimService moimService;

    public MoimController(MoimService moimService) {
        this.moimService = moimService;
    }

    @RequestMapping(value="/moim")
    public String moim(Model model) {
        model.addAttribute("moim", new Moim()); // 속성이 있는 모델을 반환해야 한다.
        return "moim";
    }

    @PostMapping("/moim")
    public String addPageMoim(@ModelAttribute Moim moim, Model model) { // create
        moimService.createMoim(moim);
        return "moim";
    }

    @RequestMapping(value = "/moim/list")
    public String getPagePerson(Model model) {
        // model.addAttribute("moim", moimService.getAllMoims()); // 속성이 있는 모델을 반환
        return "moim/list";
    }

}
