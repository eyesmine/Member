package com.member.admin.web;

import com.member.admin.domain.members.Members;
import com.member.admin.domain.members.MemberRepository;
import com.member.admin.web.dto.ManageSaveRequestDto;
import com.member.admin.web.dto.ManageUpdateRequestDto;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ManageApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private MemberRepository memberRepository;

    @After
    public void tearDown() throws Exception {
        memberRepository.deleteAll();
    }

    @Test
    public void Member_insert() throws Exception {
        // given
        String userId = "id";
        String pw = "pw";

        ManageSaveRequestDto requestDto = ManageSaveRequestDto.builder()
                .userId(userId)
                .pw(pw)
                .build();

        String url = "http://localhost:" + port + "/api/save";


        ResponseEntity<Long> responseEntity = restTemplate
                .postForEntity(url, requestDto, Long.class);

        // then
        assertThat(responseEntity.getStatusCode()).
                isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).
                isGreaterThan(0L);

        List<Members> all = memberRepository.findAll();
        assertThat(all.get(0).getId()).isEqualTo(userId);
        assertThat(all.get(0).getPw()).isEqualTo(pw);

    }

    @Test
    public void Member_update() throws Exception {
        // given
        Members savedMember = memberRepository.save(Members.builder().userId("id").pw("pw").build());
        String updatedId = savedMember.getUserId();
        String expectedPw = "pw2";

        ManageUpdateRequestDto requestDto = ManageUpdateRequestDto.builder()
                .pw(expectedPw)
                .build();

        String url = "http://localhost:" + port + "/api/save/"+ updatedId;

        HttpEntity<ManageUpdateRequestDto> requestEntity = new HttpEntity<>(requestDto);

        //when
        ResponseEntity<Long> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, Long.class);

        // then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Members> all = memberRepository.findAll();
        assertThat(all.get(0).getPw());

    }
}
