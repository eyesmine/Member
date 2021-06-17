package com.member.admin.web;

import com.member.admin.service.manages.ManageService;
import com.member.admin.web.dto.ManageListResponseDto;
import com.member.admin.web.dto.ManageSaveRequestDto;
import com.member.admin.web.dto.ManageUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ManageApiController {

    private final ManageService manageService;

    // save
    @PostMapping("/api/save")
    public Long save(@RequestBody ManageSaveRequestDto requestDto) {
        return manageService.save(requestDto);

    }

    // modify
    @PutMapping("/api/save/{id}")
    public Long update(@PathVariable Long id, @RequestBody ManageUpdateRequestDto requestDto) {
        return manageService.update(id, requestDto);
    }

    // search
    @GetMapping("/api/save/list")
    public List<ManageListResponseDto> findAll() {
        return manageService.findAllDesc();
    }

    // delete
    @DeleteMapping("/api/save/{id}")
    public Long delete(@PathVariable Long id) {
        manageService.delete(id);
        return id;

    }
}
