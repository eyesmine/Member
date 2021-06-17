package com.member.admin.web.dto;

import com.member.admin.domain.members.Members;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ManageResponseDto {

    private Long id;
    private String userId;
    private String pw;
    private LocalDateTime modifiedDate;

    public ManageResponseDto(Members entity) {
        this.id = entity.getId();
        this.userId = entity.getUserId();
        this.pw = entity.getPw();
        this.modifiedDate = entity.getModifiedDate();
    }
}
