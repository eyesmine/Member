package com.member.admin.web;

import com.member.admin.web.dto.JinyResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JinyController {

    @GetMapping("/")
    public String hello() {
        return "Server Start";
    }

    @GetMapping("/hello/dto")
    public JinyResponseDto jinyDto(@RequestParam("id") String id, @RequestParam("pw") String pw) {
        return new JinyResponseDto(id, pw);
    }
}
