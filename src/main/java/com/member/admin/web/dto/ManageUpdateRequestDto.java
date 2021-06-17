package com.member.admin.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ManageUpdateRequestDto {
    private String id;
    private String pw;

    @Builder
    public ManageUpdateRequestDto(String id, String pw) {
        this.id = id;
        this.pw = pw;
    }


}
