package com.member.admin.web.dto;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class JinyResponseDtoTest {

    @Test
    public void JinyTest() {
        // given
        String id = "test";
        String pw = "1234!@#$";

        // when
        JinyResponseDto dto = new JinyResponseDto(id, pw);

        // then
        assertThat(dto.getId()).isEqualTo(id);
        assertThat(dto.getPw()).isEqualTo(pw);
    }
}
