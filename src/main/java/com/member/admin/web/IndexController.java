package com.member.admin.web;

import com.member.admin.service.manages.ManageService;
import com.member.admin.web.dto.ManageResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final ManageService managesService;

    @GetMapping("/")
    public String index(Model model) {

        model.addAttribute("lists", managesService.findAllDesc());

        return "index";
    }

    @GetMapping("/members/save")
    public String membersSave() {
        return "save";
    }

    @GetMapping("/members/update/{seq}")
    public String memberUpdate(@PathVariable Long seq, Model model) {
        ManageResponseDto dto = managesService.findById(seq);
        model.addAttribute("lists", dto);

        return "update";
    }

}
