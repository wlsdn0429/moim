package project.moim.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import project.moim.domain.MoimRoom;
import project.moim.domain.UserDetailsImpl;
import project.moim.domain.sFile;
import project.moim.dto.FileDto;
import project.moim.service.FileService;
import project.moim.service.MoimService;
import project.moim.service.UserService;

import java.io.File;
import java.util.List;
import java.util.UUID;

@Controller
public class MoimController {
    @Autowired
    UserService userService;
    @Autowired
    MoimService moimService;
    @Autowired
    FileService fileService;
    @GetMapping("/moim")
    public String moim(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        //List<MoimRoom> moimList = moimService.selectAllMoim();
        //List<project.moim.domain.File> fileList = fileService.selectAllFile();
        //List<File> fileList = new ArrayList<File>();
        List<MoimRoom> moimList = moimService.board();
        if(userDetails != null){
            model.addAttribute("username", userDetails.getUsername());
            model.addAttribute("board", moimList);
        }
        return "moim";
    }

    @GetMapping("/insertmoim")
    public String insertMoim(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return "insertmoim";
    }

    @GetMapping("/deleteMoim")
    public String deleteMoim(@AuthenticationPrincipal UserDetailsImpl userDetails, @RequestParam("seq") int seq) {
        moimService.deleteMoim(seq);
        return "redirect:/moim";
    }

    @GetMapping("/updateMoim")
    public String updateMoim(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails, @RequestParam("seq") int seq) {
        MoimRoom moim = moimService.selectMoim(seq);
        model.addAttribute("moim",moim);
        model.addAttribute("seq",seq);
        return "updatemoim";
    }

    @PostMapping("/post")
    public String write(@RequestParam("file") MultipartFile files,  MoimRoom moim)  throws Exception {
        String projectPath = System.getProperty("user.dir") + "/src/main/resources/static/files";
        UUID uuid = UUID.randomUUID();
        String fileName = uuid + "_" + files.getOriginalFilename();
        File saveFile = new File(projectPath, fileName);
        files.transferTo(saveFile);

        FileDto fileDto = new FileDto();
        fileDto.setOrigFilename(files.getOriginalFilename());
        fileDto.setFilename(fileName);
        fileDto.setFilePath("/files/" + fileName);
        String nameFile = "/files/" + fileName;
        sFile file = new sFile(files.getOriginalFilename(), fileName, nameFile);
        fileService.saveFile(file);
        moim.addFile(file);
        moim.setMoimpicture(nameFile);
        moimService.saveMoim(moim);

        return "redirect:/moim";
    }
    @PostMapping("/update")
    public String update(@RequestParam("file") MultipartFile files, @RequestParam("seq") int seq,  MoimRoom moim)  throws Exception {
        String projectPath = System.getProperty("user.dir") + "/src/main/resources/static/files";
        UUID uuid = UUID.randomUUID();
        String fileName = uuid + "_" + files.getOriginalFilename();
        File saveFile = new File(projectPath, fileName);
        files.transferTo(saveFile);

        FileDto fileDto = new FileDto();
        fileDto.setOrigFilename(files.getOriginalFilename());
        fileDto.setFilename(fileName);
        fileDto.setFilePath("/files/" + fileName);
        String nameFile = "/files/" + fileName;
        sFile file = new sFile(files.getOriginalFilename(), fileName, nameFile);
        fileService.saveFile(file);
        moim.addFile(file);
        moim.setMoimpicture(nameFile);
        if(seq > 0){
            System.out.println("UPDATE!!!!!!!");
            moimService.updateMoim(moim, seq);
        }else{
            moimService.saveMoim(moim);
        }
        return "redirect:/moim";
    }
}
