package com.member.admin.web.dto;

import com.member.admin.domain.members.Members;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ManageSaveRequestDto {
    private String userId;
    private String pw;

    @Builder
    public ManageSaveRequestDto(String userId, String pw) {
        this.userId = userId;
        this.pw = pw;
    }

    public Members toEntity() {
        return Members.builder()
                .userId(userId)
                .pw(pw)
                .build();
    }
}
